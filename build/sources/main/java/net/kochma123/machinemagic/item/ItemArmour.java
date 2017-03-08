package net.kochma123.machinemagic.item;

import net.kochma123.machinemagic.Main;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;

public class ItemArmour extends net.minecraft.item.ItemArmor implements ItemModelProvider {

	private String name;

	public ItemArmour(ArmorMaterial material, EntityEquipmentSlot slot, String name) {
		super(material, 0, slot);
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
