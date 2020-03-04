package com.kow.budgit.command;

import com.kow.budgit.capabilities.CurrencyProvider;
import com.kow.budgit.capabilities.ICurrency;
import com.kow.budgit.message.BudgitMessages;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.ServerPlayerEntity;

public class PayCommand {

	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(Commands.literal("pay")
				.then(Commands.argument("player", EntityArgument.player())
						.then(Commands.argument("amount", IntegerArgumentType.integer())
								.executes(c -> run(c, EntityArgument.getPlayer(c, "player"),
										IntegerArgumentType.getInteger(c, "amount"))))));
	}

	static int run(final CommandContext<CommandSource> context,
			final ServerPlayerEntity targetPlayer, final Integer amount) {
		// TODO: check sender money add options for administrators and server to
		// currency
		ServerPlayerEntity sourcePlayer = null;
		try {
			sourcePlayer = context.getSource().asPlayer();
		} catch (CommandSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ICurrency sourceCurrency = sourcePlayer
				.getCapability(CurrencyProvider.CURRENCY_CAP)
				.orElseThrow(IllegalStateException::new);

		ICurrency targetCurrency = targetPlayer
				.getCapability(CurrencyProvider.CURRENCY_CAP)
				.orElseThrow(IllegalStateException::new);
		
		if (sourceCurrency.get() < amount && !sourcePlayer.hasPermissionLevel(4)) {
			BudgitMessages.pay_fail(sourcePlayer);
			return -1;
		}

		sourceCurrency.set(sourceCurrency.get() - amount);
		targetCurrency.set(targetCurrency.get() + amount);
		
		BudgitMessages.pay_success(sourcePlayer, targetPlayer, amount);

		return 0;

	}
}
