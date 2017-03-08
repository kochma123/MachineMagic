package net.kochma123.machinemagic.block;

import net.kochma123.machinemagic.Main;
import net.kochma123.machinemagic.handler.ItemHandler;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockCropCorn extends BlockCrops {
	public BlockCropCorn() {
		setUnlocalizedName("crop_corn");
		setRegistryName("crop_corn");
		setCreativeTab(Main.creativeTab);
	}

	@Override
	protected Item getSeed() {
		return ItemHandler.cornSeed;
	}

	@Override
	protected Item getCrop() {
		return ItemHandler.corn;
	}
}
