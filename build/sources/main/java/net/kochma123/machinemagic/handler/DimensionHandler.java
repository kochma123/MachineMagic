package net.kochma123.machinemagic.handler;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.DimensionManager;

public class DimensionHandler {

	public static void init() {
		DimensionType t = DimensionType.register("TestDimension","test", 2, WorldProvider.class, true);
		DimensionManager.registerDimension(2, t);
	}
}