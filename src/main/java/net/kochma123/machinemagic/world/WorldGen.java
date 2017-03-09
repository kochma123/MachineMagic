package net.kochma123.machinemagic.world;

import java.util.Random;

import net.kochma123.machinemagic.handler.BlockHandler;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDesert;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {

		int blockX = chunkX * 16;
		int blockZ = chunkZ * 16;

		switch (world.provider.getDimension()) {
		case -1:
			generateNether(world, random, blockX, blockZ);
			break;
		case 0:
			generateOverworld(world, random, blockX, blockZ);
			break;
		case 1:
			generateEnd(world, random, blockX, blockZ);
			break;
		}
	}

	private void generateNether(World world, Random random, int blockX, int blockZ) {

	}

	private void generateEnd(World world, Random random, int blockX, int blockZ) {

	}

	private void generateOverworld(World world, Random random, int blockX, int blockZ) {
		generateOre(BlockHandler.oreCopper.getDefaultState(), world, random, blockX, blockZ, 16, 64,
				4 + random.nextInt(4), 6);

		if(world.getBiome(new BlockPos(blockX, 64, blockZ)) instanceof BiomeDesert)
			generateGate(world, random, blockX, blockZ);

	}

	private void generateGate(World world, Random rand, int blockX, int blockZ) {
		WorldGenerator genCabin = new GateGen();
		final float CABIN_CHANCE = 100f;
		if (rand.nextFloat() * 100 < CABIN_CHANCE) {
			// get a random position in the chunk
			int randX = blockX + rand.nextInt(16);
			int randZ = blockZ + rand.nextInt(16);
			// use our custom function to get the ground height
			int groundY = getGroundFromAbove(world, randX, randZ);
			if (groundY >= 0)
				genCabin.generate(world, rand, new BlockPos(randX, groundY + 1, randZ));
		}
	}

	private int getGroundFromAbove(World world, int x, int z) {
		int y = world.getActualHeight();
		boolean foundGround = false;
		while (!foundGround && y-- >= 0) {
			Block blockAt = world.getBlockState(new BlockPos(x, y, z)).getBlock();
			// "ground" for our bush is grass or dirt
			foundGround = blockAt == Blocks.DIRT || blockAt == Blocks.GRASS || blockAt == Blocks.SAND
					|| blockAt == Blocks.STONE;
		}
		return y;
	}

	private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size,
			int chances) {
		int deltaY = maxY - minY;
		for (int i = 0; i < chances; i++) {
			BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));
			WorldGenMinable generator = new WorldGenMinable(ore, size);
			generator.generate(world, random, pos);
		}
	}
}