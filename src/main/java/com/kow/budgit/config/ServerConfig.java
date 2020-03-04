package com.kow.budgit.config;

import com.kow.budgit.Budgit;

import net.minecraftforge.common.ForgeConfigSpec;

public final class ServerConfig {
	
		final ForgeConfigSpec.ConfigValue<String> serverCurrencyString;
		
		ServerConfig(final ForgeConfigSpec.Builder builder) {
			builder.push("general");
			
			serverCurrencyString = builder
					.comment("The identifier for the currency")
					.translation(Budgit.modId + ".config.serverCurrencyString")
					.define("serverCurrencyString", "P");
			
			builder.pop();
		}
}
