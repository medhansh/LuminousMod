package com.lumos21.luminousmod.init;

import com.lumos21.luminousmod.LuminousMod;
import com.lumos21.luminousmod.LuminousMod.LuminousItemGroup;
import com.lumos21.luminousmod.objects.blocks.SpecialBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(LuminousMod.MOD_ID)
@Mod.EventBusSubscriber(modid = LuminousMod.MOD_ID, bus = Bus.MOD)
public class BlockInit {

	public static final Block example_block = null;
	public static final Block nitrate_ore = null;
	public static final Block special_block = null;

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry()
				.register(new Block(
						Block.Properties.create(Material.IRON).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.SAND))
								.setRegistryName("example_block"));
		event.getRegistry().register(new Block(
				Block.Properties.create(Material.IRON).hardnessAndResistance(7.0f, 15.0f).sound(SoundType.STONE))
						.setRegistryName("nitrate_ore"));
		event.getRegistry()
				.register(new SpecialBlock(Block.Properties.create(Material.PORTAL).hardnessAndResistance(2.0F, 10.0F)
						.harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.GLASS).lightValue(30)
						.slipperiness(3.6F).noDrops()).setRegistryName("special_block"));
	}

	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().register(
				new BlockItem(example_block, new Item.Properties().maxStackSize(16).group(LuminousItemGroup.instance))
						.setRegistryName("example_block"));
		event.getRegistry().register(
				new BlockItem(nitrate_ore, new Item.Properties().maxStackSize(64).group(LuminousItemGroup.instance))
						.setRegistryName("nitrate_ore"));
		//event.getRegistry().register(
		//		new BlockItem(nitrate_ore, new Item.Properties().maxStackSize(64).group(LuminousItemGroup.instance))
		//				.setRegistryName("special_block"));
	}

	

	

}
