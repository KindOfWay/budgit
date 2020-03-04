package com.kow.budgit.command;

import com.kow.budgit.message.BudgitMessages;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

public class BudgitCommand {

	private static final BudgitCommand budgit = new BudgitCommand();

	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(Commands.literal("budgit")
				.executes(cs -> budgit.run(cs.getSource().getEntity())));
	}

	int run(Entity player) throws CommandSyntaxException {
		
		BudgitMessages.currency_status((PlayerEntity)player);
		return 0;
	}

}
