package com.kow.budgit.event;

import com.kow.budgit.Budgit;
import com.kow.budgit.capabilities.CurrencyProvider;
import com.kow.budgit.capabilities.ICurrency;
import com.kow.budgit.command.ModCommands;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;

@EventBusSubscriber(modid = Budgit.modId, bus = EventBusSubscriber.Bus.FORGE)
public final class ForgeEventSubscriber {

	/*
	 * @SubscribeEvent public void onPlayerLogsIn(PlayerLoggedInEvent event) {
	 * 
	 * 
	 * } /*
	 * 
	 * 
	 * /** Copy data from dead player to the new player (includes transfer)
	 */
	
	@SubscribeEvent
	public static void onServerStart(FMLServerStartingEvent event) {
		new ModCommands(event);
	}

	@SubscribeEvent
	public static void onPlayerClone(PlayerEvent.Clone event) {
		PlayerEntity player = event.getPlayer();
		ICurrency currency = player.getCapability(CurrencyProvider.CURRENCY_CAP)
				.orElseThrow(IllegalStateException::new);
		ICurrency oldCurrency = event.getOriginal()
				.getCapability(CurrencyProvider.CURRENCY_CAP)
				.orElseThrow(IllegalStateException::new);
		currency.set(oldCurrency.get());
	}
	
	@SubscribeEvent
	public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof ServerPlayerEntity) {
			if (event.getObject() instanceof PlayerEntity) {
				event.addCapability(new ResourceLocation(Budgit.modId, "currency"),
						new CurrencyProvider());
			}
		}
	}

}
