package net.kochma123.machinemagic.client;

import net.kochma123.machinemagic.Main;
import net.kochma123.machinemagic.handler.ItemHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs{

	public CreativeTab(){
		super(Main.MODID);
		setBackgroundImageName("machinemagic.png");
	}
	
	@Override
	public ItemStack getTabIconItem(){
		return new ItemStack(ItemHandler.ingotCopper);
		
	}
	@Override
	public boolean hasSearchBar() {
		return true;
	}
}
