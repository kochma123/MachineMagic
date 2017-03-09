package net.kochma123.machinemagic.handler;

import net.kochma123.machinemagic.block.BlockBase;
import net.kochma123.machinemagic.block.BlockCropCorn;
import net.kochma123.machinemagic.block.BlockTileEntity;
import net.kochma123.machinemagic.block.counter.BlockCounter;
import net.kochma123.machinemagic.block.BlockOre;
import net.kochma123.machinemagic.item.ItemModelProvider;
import net.kochma123.machinemagic.item.ItemOreDict;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockHandler {
	
	public static BlockOre oreCopper;
	public static BlockCropCorn cropCorn;
	public static BlockCounter counter;
	
	public static BlockBase naquadah;
	
	public static void init() {
		naquadah = register(new BlockBase(Material.ROCK, "test"));
		naquadah.setBlockUnbreakable();
		cropCorn = register(new BlockCropCorn(), null);
		oreCopper = register(new BlockOre("ore_copper","oreCopper"));
		counter = register(new BlockCounter());
	}

	private static <T extends Block> T register(T block) {
		ItemBlock itemBlock = new ItemBlock(block);
		itemBlock.setRegistryName(block.getRegistryName());
		return register(block, itemBlock);
	}
	
	private static <T extends Block> T register(T block, ItemBlock itemBlock) {
		GameRegistry.register(block);
		if (block instanceof BlockTileEntity){
			GameRegistry.registerTileEntity(((BlockTileEntity<?>)block).getTileEntityClass(), block.getRegistryName().toString());
		}
		if(itemBlock != null)
			GameRegistry.register(itemBlock);
		if (block instanceof ItemModelProvider) {
			((ItemModelProvider) block).registerItemModel(itemBlock);
		}
		if (block instanceof ItemOreDict) {
			((ItemOreDict)block).initOreDict();
		}
		if (itemBlock instanceof ItemOreDict) {
			((ItemOreDict)itemBlock).initOreDict();
		}

		return block;
	}

	
}
