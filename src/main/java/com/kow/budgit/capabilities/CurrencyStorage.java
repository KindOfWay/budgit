package com.kow.budgit.capabilities;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class CurrencyStorage implements IStorage<ICurrency>{
	@Override
	public INBT writeNBT(Capability<ICurrency> capability, ICurrency instance, Direction side) {
		CompoundNBT tag = new CompoundNBT();
		tag.putInt("currency", instance.get());
		return tag;
	}

	@Override
	public void readNBT(Capability<ICurrency> capability, ICurrency instance, Direction side, INBT nbt) {
		CompoundNBT tag = (CompoundNBT) nbt;
		instance.set(tag.getInt("currency"));
		
	}
	
}
