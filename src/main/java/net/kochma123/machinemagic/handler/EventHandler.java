package net.kochma123.machinemagic.handler;

import net.minecraft.init.Enchantments;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemPickupEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;

public class EventHandler {

	@SubscribeEvent
	public void crafting(ItemCraftedEvent event){
		System.out.println("TESTING THIS THING");
		if(event.crafting.getItem() ==  ItemHandler.emeraldPickaxe)
			event.crafting.addEnchantment(Enchantments.SILK_TOUCH,1);
	}

	@SubscribeEvent
	public void smelting(ItemSmeltedEvent event) {

	}
	
	@SubscribeEvent
	public void pickup(ItemPickupEvent event) {
		
	}
}
