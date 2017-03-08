package net.kochma123.machinemagic.handler;

import net.kochma123.machinemagic.Main;
import net.kochma123.machinemagic.item.ItemArmour;
import net.kochma123.machinemagic.item.ItemBase;
import net.kochma123.machinemagic.item.ItemCorn;
import net.kochma123.machinemagic.item.ItemCornSeed;
import net.kochma123.machinemagic.item.ItemModelProvider;
import net.kochma123.machinemagic.item.ItemOre;
import net.kochma123.machinemagic.item.ItemOreDict;
import net.kochma123.machinemagic.item.tool.ItemAxe;
import net.kochma123.machinemagic.item.tool.ItemHoe;
import net.kochma123.machinemagic.item.tool.ItemPickaxe;
import net.kochma123.machinemagic.item.tool.ItemShovel;
import net.kochma123.machinemagic.item.tool.ItemSword;
import net.minecraft.entity.Entity;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemHandler {

	public static ItemBase ingotCopper;
	
	public static ItemCornSeed cornSeed;
	public static ItemCorn corn;
	
	public static ItemPickaxe emeraldPickaxe;
	
	public static ItemSword copperSword;
	public static ItemPickaxe copperPickaxe;
	public static ItemHoe copperHoe;
	public static ItemAxe copperAxe;
	
	public static ItemShovel copperShovel;
	public static ItemArmour copperHelmet;
	public static ItemArmour copperChestplate;
	public static ItemArmour copperLeggings;
	public static ItemArmour copperBoots;

	public static void init() {
		emeraldPickaxe = register(new ItemPickaxe(Main.emeraldToolMaterial,"emerald_pickaxe"){@Override
		public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
			stack.addEnchantment(Enchantments.SILK_TOUCH, 1);
		}});
		
		copperHelmet = register(new ItemArmour(Main.copperArmorMaterial,EntityEquipmentSlot.HEAD,"copper_helmet"));
		copperChestplate = register(new ItemArmour(Main.copperArmorMaterial, EntityEquipmentSlot.CHEST, "copper_chestplate"));
		copperLeggings = register(new ItemArmour(Main.copperArmorMaterial, EntityEquipmentSlot.LEGS, "copper_leggings"));
		copperBoots = register(new ItemArmour(Main.copperArmorMaterial, EntityEquipmentSlot.FEET, "copper_boots"));
		
		copperAxe = register(new ItemAxe(Main.copperToolMaterial, "copper_axe"));
		copperHoe = register(new ItemHoe(Main.copperToolMaterial, "copper_hoe"));
		copperPickaxe = register(new ItemPickaxe(Main.copperToolMaterial, "copper_pickaxe"));
		copperShovel = register(new ItemShovel(Main.copperToolMaterial, "copper_shovel"));
		copperSword = register(new ItemSword(Main.copperToolMaterial, "copper_sword"));
		
		corn = register(new ItemCorn());
		cornSeed = register(new ItemCornSeed());
		
		ingotCopper = register(new ItemOre("ingot_copper", "ingotCopper"));
	}

	private static <T extends Item> T register(T item) {
		GameRegistry.register(item);
		if (item instanceof ItemModelProvider) {
			((ItemModelProvider) item).registerItemModel(item);
		}
		if (item instanceof ItemOreDict) {
			((ItemOreDict) item).initOreDict();
		}
		return item;
	}
}