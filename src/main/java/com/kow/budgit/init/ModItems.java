package com.kow.budgit.init;

import com.kow.budgit.Budgit;
import com.kow.budgit.item.VesaCardItem;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModItems {

	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(
			ForgeRegistries.ITEMS, Budgit.modId);

	public static final RegistryObject<VesaCardItem> vesa_card = ITEMS
			.register("vesa_card", () -> new VesaCardItem(
					new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP).maxStackSize(1)));
}
