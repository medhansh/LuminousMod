
package com.lumos21.luminousmod.world.gen;

import com.lumos21.luminousmod.init.BlockInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class ModOreGen {
	public static void generateOre() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			
				ConfiguredPlacement customConfig = Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(20, 5, 5, 25));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.nitrate_ore.getDefaultState(), 10)).func_227228_a_(customConfig));
		}}}
	