package com.kow.budgit.event;

import com.kow.budgit.Budgit;
import com.kow.budgit.capabilities.Currency;
import com.kow.budgit.capabilities.CurrencyStorage;
import com.kow.budgit.capabilities.ICurrency;
import com.kow.budgit.config.ConfigHelper;
import com.kow.budgit.config.ConfigHolder;

import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@EventBusSubscriber(modid = Budgit.modId, bus = EventBusSubscriber.Bus.MOD)
public final class ModEventSubscriber {

	@SubscribeEvent
	public static void onCommonSetup(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(ICurrency.class, new CurrencyStorage(),
				Currency::new);
	}

	@SubscribeEvent
	public static void onModConfigEvent(final ModConfig.ModConfigEvent event) {
		final ModConfig config = event.getConfig();
		// Rebake the configs when they change
		if (config.getSpec() == ConfigHolder.CLIENT_SPEC) {
			ConfigHelper.bakeClient(config);
		} else if (config.getSpec() == ConfigHolder.SERVER_SPEC) {
			ConfigHelper.bakeServer(config);

		}
	}

}
