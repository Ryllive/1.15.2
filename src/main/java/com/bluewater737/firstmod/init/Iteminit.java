package com.bluewater737.firstmod.init;

import java.util.function.Supplier;

import com.bluewater737.firstmod.FirstMod;
import com.bluewater737.firstmod.FirstMod.TutorialItemGroup;
import com.bluewater737.firstmod.objects.items.SpecialItem;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Food;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
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

@Mod.EventBusSubscriber(modid = FirstMod.MOD_ID, bus = Bus.MOD)
@ObjectHolder(FirstMod.MOD_ID)
public class Iteminit {
	// ITEMS
	public static final Item example_item = null;
	public static final Item test_item = null;
	public static final Item special_item = null;

	// TOOLS
	public static final Item example_sword = null;

	// ARMOR
	public static final Item example_helmet = null;
	public static final Item example_chestplate = null;
	public static final Item example_leggings = null;
	public static final Item example_boots = null;

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		// ITEMS
		event.getRegistry().register(
				new Item(new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("example_item"));
		event.getRegistry()
				.register(new Item(new Item.Properties().group(TutorialItemGroup.instance)
						.food(new Food.Builder().hunger(6).saturation(1.2f)
								.effect(new EffectInstance(Effects.STRENGTH, 6000, 2), 1f).build()))
										.setRegistryName("test_item"));
		event.getRegistry().register(new SpecialItem(new Item.Properties().group(TutorialItemGroup.instance))
				.setRegistryName("special_item"));

		// TOOLS
		event.getRegistry().register(
				new SwordItem(ModItemTier.EXAMPLE, 5, 3.0f, new Item.Properties().group(TutorialItemGroup.instance))
						.setRegistryName("example_sword"));

		// ARMOR
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.EXAMPLE, EquipmentSlotType.HEAD,
				new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("example_helmet"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.EXAMPLE, EquipmentSlotType.CHEST,
				new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("example_chestplate"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.EXAMPLE, EquipmentSlotType.LEGS,
				new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("example_leggings"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.EXAMPLE, EquipmentSlotType.FEET,
				new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("example_boots"));
	}
	//TOOLS
	public enum ModItemTier implements IItemTier {
		// int harvestLevel, int maxUses, float efficiency, float attackDamage, int
		// enchantability, Supplier<Ingredient> repairMaterial
		EXAMPLE(4, 1500, 15.0f, 5.0f, 30, () -> {
			return Ingredient.fromItems(Iteminit.example_item);
		});

		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchantability;
		private final LazyValue<Ingredient> repairMaterial;

		private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability,
				Supplier<Ingredient> repairMaterial) {
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.attackDamage = attackDamage;
			this.enchantability = enchantability;
			this.repairMaterial = new LazyValue<>(repairMaterial);
		}

		@Override
		public int getMaxUses() {
			return this.maxUses;
		}

		@Override
		public float getEfficiency() {
			return this.efficiency;
		}

		@Override
		public float getAttackDamage() {
			return this.attackDamage;
		}

		@Override
		public int getHarvestLevel() {
			return this.harvestLevel;
		}

		@Override
		public int getEnchantability() {
			return this.enchantability;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}
	}
	//ARMOR
	public enum ModArmorMaterial implements IArmorMaterial {
		EXAMPLE(FirstMod.MOD_ID + ":example", 5, new int[] { 7, 9, 11, 7 }, 420, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 6.9F, () -> {
			return Ingredient.fromItems(Iteminit.example_item);
		});

		private static final int[] MAX_DAMAGE_ARRAY = new int[] { 16, 16, 16, 16 };
		private final String name;
		private final int maxDamageFactor;
		private final int[] damageReductionAmountArray;
		private final int enchantability;
		private final SoundEvent soundEvent;
		private final float toughness;
		private final LazyValue<Ingredient> repairMaterial;

		private ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn,
				int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn,
				Supplier<Ingredient> repairMaterialIn) {
			this.name = nameIn;
			this.maxDamageFactor = maxDamageFactorIn;
			this.damageReductionAmountArray = damageReductionAmountIn;
			this.enchantability = enchantabilityIn;
			this.soundEvent = soundEventIn;
			this.toughness = toughnessIn;
			this.repairMaterial = new LazyValue<>(repairMaterialIn);
		}

		@Override
		public int getDurability(EquipmentSlotType slotIn) {

			return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
		}

		@Override
		public int getDamageReductionAmount(EquipmentSlotType slotIn) {

			return damageReductionAmountArray[slotIn.getIndex()];
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
