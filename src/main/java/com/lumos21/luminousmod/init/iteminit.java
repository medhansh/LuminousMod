package com.lumos21.luminousmod.init;

import java.util.function.Supplier;

import com.lumos21.luminousmod.LuminousMod;
import com.lumos21.luminousmod.LuminousMod.LuminousItemGroup;
import com.lumos21.luminousmod.objects.items.SpecialItem;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = LuminousMod.MOD_ID, bus = Bus.MOD)
@ObjectHolder(LuminousMod.MOD_ID)
public class iteminit {

	public static final Item example_item = null;
	public static final Item nitrate_crystal = null;
	public static final Item special_item = null;

	// Tools
	public static final Item kryptonite_sword = null;
	public static final Item kryptonite_shovel = null;
	public static final Item kryptonite_pickaxe = null;
	public static final Item kryptonite_axe = null;
	public static final Item kryptonite_hoe = null;

	// Armor
	public static final Item kryptonite_helmet = null;
	public static final Item kryptonite_chestplate = null;
	public static final Item kryptonite_leggings = null;
	public static final Item kryptonite_boots = null;

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry()
				.register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("example_item"));
		event.getRegistry()
				.register(new Item(new Item.Properties().group(LuminousItemGroup.instance)
						.food(new Food.Builder().hunger(26).saturation(12.0f)
								.effect(new EffectInstance(Effects.GLOWING, 60000, 200), 1.0f).build()))
										.setRegistryName("fooditem"));
		event.getRegistry().register(new SpecialItem(new Item.Properties().group(LuminousItemGroup.instance))
				.setRegistryName("special_item"));
		event.getRegistry().register(
				new Item(new Item.Properties().group(LuminousItemGroup.instance)).setRegistryName("nitrate_crystal"));

		// Tools
		event.getRegistry().register(new SwordItem(KryptoniteItemTier.EXAMPLE, 7, 7.0F,
				new Item.Properties().group(LuminousItemGroup.instance)).setRegistryName("kryptonite_sword"));
		event.getRegistry().register(new PickaxeItem(KryptoniteItemTier.EXAMPLE, 4, 7.0F,
				new Item.Properties().group(LuminousItemGroup.instance)).setRegistryName("kryptonite_pickaxe"));
		event.getRegistry().register(new AxeItem(KryptoniteItemTier.EXAMPLE, 6, 12.0F,
				new Item.Properties().group(LuminousItemGroup.instance)).setRegistryName("kryptonite_axe"));
		event.getRegistry().register(new ShovelItem(KryptoniteItemTier.EXAMPLE, 4, 7.0F,
				new Item.Properties().group(LuminousItemGroup.instance)).setRegistryName("kryptonite_shovel"));
		event.getRegistry().register(
				new HoeItem(KryptoniteItemTier.EXAMPLE, 7.0F, new Item.Properties().group(LuminousItemGroup.instance))
						.setRegistryName("kryptonite_hoe"));

		// Armor
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.HEAD,
				new Item.Properties().group(LuminousItemGroup.instance)).setRegistryName("kryptonite_helmet"));
		event.getRegistry()
				.register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.CHEST,
						new Item.Properties().group(LuminousItemGroup.instance))
								.setRegistryName("kryptonite_chestplate"));
		event.getRegistry()
				.register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.LEGS,
						new Item.Properties().group(LuminousItemGroup.instance))
								.setRegistryName("kryptonite_leggings"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.FEET,
				new Item.Properties().group(LuminousItemGroup.instance)).setRegistryName("kryptonite_boots"));

	}

	public enum KryptoniteItemTier implements IItemTier {
		EXAMPLE(4, 1500, 15.0F, 7.0F, 250, () -> {
			return Ingredient.fromItems(iteminit.example_item);
		});

		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchantability;
		private final LazyValue<Ingredient> repairMaterial;

		private KryptoniteItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage,
				int enchantability, Supplier<Ingredient> repairMaterial) {
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.attackDamage = attackDamage;
			this.efficiency = efficiency;
			this.enchantability = enchantability;
			this.repairMaterial = new LazyValue<>(repairMaterial);
		}

		@Override
		public int getMaxUses() {
			// TODO Auto-generated method stub
			return this.maxUses;
		}

		@Override
		public float getEfficiency() {
			// TODO Auto-generated method stub
			return this.efficiency;
		}

		@Override
		public float getAttackDamage() {
			// TODO Auto-generated method stub
			return this.attackDamage;
		}

		@Override
		public int getHarvestLevel() {
			// TODO Auto-generated method stub
			return this.harvestLevel;
		}

		@Override
		public int getEnchantability() {
			// TODO Auto-generated method stub
			return this.enchantability;
		}

		@Override
		public Ingredient getRepairMaterial() {
			// TODO Auto-generated method stub
			return this.repairMaterial.getValue();
		}
	}

	public enum ModArmorMaterial implements IArmorMaterial {
		TEST(LuminousMod.MOD_ID + ":test", 7, new int[] { 7, 9, 11, 7 }, 420, SoundEvents.field_226124_Y_, 10.3F, () ->

		{
			return Ingredient.fromItems(iteminit.nitrate_crystal);
		});

		private static final int[] MAX_DAMAGE_ARRAY = new int[] { 17, 17, 17, 17 };
		private final String name;
		private final int maxDamageFactor;
		private final int[] damageReductionAmountArray;
		private final int enchantability;
		private final SoundEvent soundEvent;
		private final float toughness;
		private final LazyValue<Ingredient> repairMaterial;

		private ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn,
				int enchantabilityIn, SoundEvent soundEvent, float toughnessIn, Supplier<Ingredient> repairMaterial) {
			this.name = nameIn;
			this.maxDamageFactor = maxDamageFactorIn;
			this.damageReductionAmountArray = damageReductionAmountIn;
			this.enchantability = enchantabilityIn;
			this.soundEvent = soundEvent;
			this.toughness = toughnessIn;
			this.repairMaterial = new LazyValue<>(repairMaterial);
			
		}

		@Override
		public int getDurability(EquipmentSlotType slotIn) {
			return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
		}

		@Override
		public int getDamageReductionAmount(EquipmentSlotType slotIn) {
			return this.damageReductionAmountArray[slotIn.getIndex()];
		}

		@Override
		public int getEnchantability() {
			return this.enchantability;
		}

		@Override
		public SoundEvent getSoundEvent() {
			return this.soundEvent;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}

		@OnlyIn(Dist.CLIENT)	
		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public float getToughness() {
			return this.toughness;
		}
	}

}
