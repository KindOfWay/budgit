package com.kow.budgit.init;

import java.util.function.Supplier;

import com.kow.budgit.Budgit;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroups {
	
	public static final ItemGroup MOD_ITEM_GROUP =
			new ModItemGroup(Budgit.modId, () -> new ItemStack(ModItems.vesa_card.get()));
	
	public static class ModItemGroup extends ItemGroup {
		private final Supplier<ItemStack> iconSupplier;
		
		public ModItemGroup(final String name, final Supplier<ItemStack> iconSupplier) {
			super(name);
			this.iconSupplier = iconSupplier;
		}
		
		@Override
		public ItemStack createIcon() {
			return iconSupplier.get();
		}
	}

}
