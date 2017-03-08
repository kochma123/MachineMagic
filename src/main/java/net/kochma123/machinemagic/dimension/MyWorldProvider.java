package net.kochma123.machinemagic.dimension;

import net.kochma123.machinemagic.handler.DimensionHandler;
import net.minecraft.world.DimensionType;
import net.minecraft.world.GameType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;
import net.minecraft.world.storage.WorldInfo;

public class MyWorldProvider extends WorldProvider{
	
	public MybiomeProvider biomeProvider;
	
	public void init(){
		Long seed = 2052930197336800526L;
		WorldSettings settings = new WorldSettings(seed, GameType.SURVIVAL, true, false, new WorldType("OurDimension"));
		WorldInfo info = new WorldInfo(settings, "OurDimension");
		this.biomeProvider = new MybiomeProvider(info);
	}
	
	@Override
	public DimensionType getDimensionType() {
		return DimensionHandler.t;
	}
	
	@Override
	public boolean isSurfaceWorld(){
		return true;
	}
}
