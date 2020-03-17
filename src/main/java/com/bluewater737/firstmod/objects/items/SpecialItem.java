package com.bluewater737.firstmod.objects.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public class SpecialItem extends Item 
{

	public SpecialItem(Properties properties) 
	{
		super(properties);
	}

	@Override
	public boolean hasEffect(ItemStack stack) 
	{
		return true;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		{
			playerIn.addPotionEffect(new EffectInstance(Effects.LEVITATION, 500, 5));
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	@Override
	public int getBurnTime(ItemStack itemStack) 
	{
		return 100;
	}
}
