package net.kochma123.machinemagic.dimension;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.storage.WorldInfo;

public class MybiomeProvider extends BiomeProvider {

	private List<Biome> biomesToSpawnIn = Lists.newArrayList(Biomes.DESERT);

	public MybiomeProvider(WorldInfo info){
		super(info);
	}
	
	public List<Biome> getBiomesToSpawnIn()
    {
        return this.biomesToSpawnIn ;
    }
}
