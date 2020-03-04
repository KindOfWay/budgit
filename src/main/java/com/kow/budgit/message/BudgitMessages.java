package com.kow.budgit.message;

import com.kow.budgit.capabilities.CurrencyProvider;
import com.kow.budgit.capabilities.ICurrency;
import com.kow.budgit.config.BudgitConfig;
import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public final class BudgitMessages {

	public static StringTextComponent get_tag() {
		String tag = new TranslationTextComponent("messages.budgit.currency.tag")
				.getFormattedText();
		return new StringTextComponent(
				"[" + ChatFormatting.DARK_GREEN + tag + ChatFormatting.WHITE + "]: ");
	}

	public static void currency_status(PlayerEntity player) {
		ICurrency currency = player.getCapability(CurrencyProvider.CURRENCY_CAP)
				.orElseThrow(IllegalStateException::new);
		Integer amount = currency.get();
		player.sendMessage(get_tag().appendSibling(
				new TranslationTextComponent("messages.budgit.currency.status",
						amount.toString() + BudgitConfig.serverCurrencyString)));
	}

	public static void pay_success(PlayerEntity src, PlayerEntity dst,
			Integer amount) {
		src.sendMessage(get_tag().appendSibling(new TranslationTextComponent(
				"messages.budgit.currency.send.status", amount,
				BudgitConfig.serverCurrencyString, dst.getName().getString())));
		dst.sendMessage(get_tag().appendSibling(new TranslationTextComponent(
				"messages.budgit.currency.receive.status", amount,
				BudgitConfig.serverCurrencyString, src.getName().getString())));

	}
	
	public static void pay_fail(PlayerEntity src) {
		src.sendMessage(get_tag().appendSibling(new TranslationTextComponent("messages.budgit.currency.pay.fail")));
	}

}
