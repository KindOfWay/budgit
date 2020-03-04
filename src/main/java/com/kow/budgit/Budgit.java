package com.kow.budgit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.kow.budgit.config.ConfigHolder;
import com.kow.budgit.init.ModItems;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("budgit")
public class Budgit {

	public static final String modId = "budgit";
	public static final Logger LOGGER = LogManager.getLogger();

	public Budgit() {
		final ModLoadingContext modLoadingContext = ModLoadingContext.get();
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ModItems.ITEMS.register(modEventBus);
		
		modLoadingContext.registerConfig(ModConfig.Type.CLIENT, ConfigHolder.CLIENT_SPEC);
		modLoadingContext.registerConfig(ModConfig.Type.SERVER, ConfigHolder.SERVER_SPEC);
	}

}
