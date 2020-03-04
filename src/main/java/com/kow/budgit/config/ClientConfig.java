package com.kow.budgit.config;

import com.kow.budgit.Budgit;

import net.minecraftforge.common.ForgeConfigSpec;

final class ClientConfig {

	final ForgeConfigSpec.ConfigValue<String> clientCurrencyString;
	
	ClientConfig(final ForgeConfigSpec.Builder builder) {
		builder.push("general");
		
		clientCurrencyString = builder
				.comment("The identifier for the currency")
				.translation(Budgit.modId + ".config.clientCurrencyString")
				.define("clientCurrencyString", "P");
		
		builder.pop();
	}

}
