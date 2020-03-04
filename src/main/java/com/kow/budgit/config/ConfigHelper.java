package com.kow.budgit.config;

import net.minecraftforge.fml.config.ModConfig;

public final class ConfigHelper {

	public static void bakeClient(final ModConfig config) {
		BudgitConfig.clientCurrencyString = ConfigHolder.CLIENT.clientCurrencyString.get();
	}

	public static void bakeServer(final ModConfig config) {
		BudgitConfig.serverCurrencyString = ConfigHolder.SERVER.serverCurrencyString.get();
	}

}