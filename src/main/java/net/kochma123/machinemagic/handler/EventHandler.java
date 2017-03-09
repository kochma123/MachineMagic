package net.kochma123.machinemagic.handler;

import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemPickupEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;

public class EventHandler {

	@SubscribeEvent
	public void crafting(ItemCraftedEvent event) {

	}

	@SubscribeEvent
	public void smelting(ItemSmeltedEvent event) {

	}

	@SubscribeEvent
	public void pickup(ItemPickupEvent event) {

	}

	@SubscribeEvent
	public void world(WorldEvent event) {
		if (event instanceof WorldEvent.Load) {
		} else if (event instanceof WorldEvent.Save) {
		} else if (event instanceof WorldEvent.Unload) {
		}
	}
}