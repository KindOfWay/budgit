package com.kow.budgit.command;

import net.minecraftforge.fml.event.server.FMLServerStartingEvent;

public class ModCommands {

	public ModCommands(FMLServerStartingEvent event) {
		BudgitCommand.register(event.getCommandDispatcher());
		PayCommand.register(event.getCommandDispatcher());
	}

}
