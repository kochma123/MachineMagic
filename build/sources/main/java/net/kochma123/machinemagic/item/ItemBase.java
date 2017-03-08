package net.kochma123.machinemagic.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.kochma123.machinemagic.Main;

public class ItemBase extends Item implements ItemModelProvider{

	protected String name;
	
	public ItemBase(String name){
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.creativeTab);
	}
	
	public void registerItemModel(Item item){
		Main.proxy.registerItemRenderer(item, 0, name);
	}
	
	@Override
	public ItemBase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
	
	
}