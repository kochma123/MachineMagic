package net.kochma123.machinemagic.item.tool;

import net.kochma123.machinemagic.Main;
import net.kochma123.machinemagic.item.ItemModelProvider;
import net.minecraft.item.Item;

public class ItemHoe extends net.minecraft.item.ItemHoe implements ItemModelProvider{

	private String name;
	
	public ItemHoe(ToolMaterial material, String name) {
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(Main.creativeTab);
		this.name = name;
	}

	@Override
	public void registerItemModel(Item item) {
		Main.proxy.registerItemRenderer(this, 0, name);
	}

}
