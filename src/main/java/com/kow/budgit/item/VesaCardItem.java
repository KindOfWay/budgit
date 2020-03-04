package com.kow.budgit.item;

import com.kow.budgit.init.ModItems;
import com.kow.budgit.message.BudgitMessages;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class VesaCardItem extends Item {

	public VesaCardItem(Properties properties) {
		super(properties);
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn,
			PlayerEntity playerIn, Hand handIn) {
		if (!worldIn.isRemote) {
			if (playerIn.getHeldItem(handIn).getItem() == ModItems.vesa_card.get()) {
				BudgitMessages.currency_status(playerIn);
			}
		}
		return ActionResult.func_226250_c_(playerIn.getHeldItem(handIn));
	}

}