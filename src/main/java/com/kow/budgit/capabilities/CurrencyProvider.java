package com.kow.budgit.capabilities;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class CurrencyProvider implements ICapabilitySerializable<INBT> {

	@CapabilityInject(ICurrency.class)
	public static final Capability<ICurrency> CURRENCY_CAP = null;

	private LazyOptional<ICurrency> instance = LazyOptional.of(CURRENCY_CAP::getDefaultInstance);

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		return cap == CURRENCY_CAP ? instance.cast() : LazyOptional.empty();
	}

	@Override
	public INBT serializeNBT() {
		return CURRENCY_CAP.getStorage().writeNBT(
				CURRENCY_CAP,
				this.instance.orElseThrow(() -> new IllegalArgumentException("Lazyoptional must not be empty")),
				null);
	}

	@Override
	public void deserializeNBT(INBT nbt) {
		CURRENCY_CAP.getStorage().readNBT(
				CURRENCY_CAP,
				this.instance.orElseThrow(() -> new IllegalArgumentException("Lazyoptional must not be empty")),
				null, 
				nbt);

	}

}
