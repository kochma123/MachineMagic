package net.kochma123.machinemagic.handler;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class RecipeHandler {
	
	public static void init(){
		GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.cornSeed), ItemHandler.corn);
		GameRegistry.addShapedRecipe(new ItemStack(Items.RABBIT_STEW), " R ","CPM"," B ",'R',Items.COOKED_RABBIT,'C',ItemHandler.corn,'P',Items.BAKED_POTATO,'M',Blocks.BROWN_MUSHROOM,'B', Items.BOWL);
		
		//Armour Recipes
		GameRegistry.addShapedRecipe(new ItemStack(ItemHandler.copperHelmet), "CCC","C C",'C',ItemHandler.ingotCopper);
		GameRegistry.addShapedRecipe(new ItemStack(ItemHandler.copperChestplate), "C C","CCC","CCC",'C',ItemHandler.ingotCopper);
		GameRegistry.addShapedRecipe(new ItemStack(ItemHandler.copperLeggings), "CCC","C C","C C",'C',ItemHandler.ingotCopper);
		GameRegistry.addShapedRecipe(new ItemStack(ItemHandler.copperBoots),"C C","C C",'C',ItemHandler.ingotCopper);
		
		//Tool Recipes
		
		//Copper Tools
		GameRegistry.addShapedRecipe(new ItemStack(ItemHandler.copperAxe),"CC ","CS "," S ",'C',ItemHandler.ingotCopper,'S',Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ItemHandler.copperHoe),"CC "," S "," S ",'C',ItemHandler.ingotCopper,'S',Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ItemHandler.copperPickaxe),"CCC"," S "," S ",'C',ItemHandler.ingotCopper,'S',Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ItemHandler.copperShovel)," C "," S "," S ",'C',ItemHandler.ingotCopper,'S',Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ItemHandler.copperSword)," C "," C "," S ",'C',ItemHandler.ingotCopper,'S',Items.STICK);
		
		//Emerald Tools
		GameRegistry.addShapedRecipe(new ItemStack(ItemHandler.emeraldPickaxe), "EEE"," S "," S ",'E',Items.EMERALD,'S',Items.STICK);
		
		//Smelting Recipes
		GameRegistry.addSmelting(BlockHandler.oreCopper, new ItemStack(ItemHandler.ingotCopper), 0.7f);
		
		//OreDict Recipes
		GameRegistry.addRecipe(new ShapedOreRecipe(Items.BUCKET, "I I"," I ",'I',"ingotCopper"));
	}
}
