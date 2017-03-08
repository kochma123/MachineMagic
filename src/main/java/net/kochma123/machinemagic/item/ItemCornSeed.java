package net.kochma123.machinemagic.item;

import net.kochma123.machinemagic.Main;
import net.kochma123.machinemagic.handler.BlockHandler;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;

public class ItemCornSeed extends ItemSeeds implements ItemModelProvider {

	public ItemCornSeed() {
		super(BlockHandler.cropCorn, Blocks.FARMLAND);
		setUnlocalizedName("corn_seed");
		setRegistryName("corn_seed");
		setCreativeTab(Main.creativeTab);
	}

	@Override
	public void registerItemModel(Item item) {
		Main.proxy.registerItemRenderer(item, 0, "corn_seed");
	}

}
