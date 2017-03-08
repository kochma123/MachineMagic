package net.kochma123.machinemagic.handler;

import net.kochma123.machinemagic.Main;
import net.kochma123.machinemagic.dimension.MyWorldProvider;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class DimensionHandler {
	
	public static DimensionType t;

	public static void init() {
		DimensionType t = DimensionType.register("TestDimension","test", Main.DimID, MyWorldProvider.class, true);
		DimensionManager.registerDimension(Main.DimID, t);
	}
}