package com.bluewater737.firstmod.init;

import com.bluewater737.firstmod.FirstMod;
import com.bluewater737.firstmod.FirstMod.TutorialItemGroup;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(FirstMod.MOD_ID)
@Mod.EventBusSubscriber(modid = FirstMod.MOD_ID, bus = Bus.MOD)
public class Blockinit {
	public static final Block example_block = null;
	public static final Block example_ore = null;
	public static final Block custom_block = null;

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().register(
				new Block(Block.Properties.create(Material.CLAY).hardnessAndResistance(1.5f, 10f).sound(SoundType.WOOD))
						.setRegistryName("example_block"));
		event.getRegistry().register(
				new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3f, 15f).sound(SoundType.STONE))
						.setRegistryName("example_ore"));
	}

	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry()
				.register(new BlockItem(example_block, new Item.Properties().group(TutorialItemGroup.instance))
						.setRegistryName("example_block"));
		event.getRegistry().register(new BlockItem(example_ore, new Item.Properties().group(TutorialItemGroup.instance))
				.setRegistryName("example_ore"));
	}

}
