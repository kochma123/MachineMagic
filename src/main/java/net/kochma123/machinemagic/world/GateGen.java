package net.kochma123.machinemagic.world;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GateGen extends WorldGenerator {

	int[][] blockPositions = new int[][] {
												{0,13,5},{0,13,6},{0,13,7},{0,13,8},
								{0,12,3},{0,12,4},									{0,12,9},{0,12,10},
						{0,11,2},																	{0,11,11},
				{0,10,1},																					{0,10,12},
				{0,9,1},																					{0,9,12},
		{0,8,0},																								{0,8,13},
		{0,7,0},																								{0,7,13},
		{0,6,0},																								{0,6,13},
		{0,5,0},																								{0,5,13},
				{0,4,1},																				{0,4,12},
				{0,3,1},																				{0,3,12},
						{0,2,2},																{0,2,11},
								{0,1,3},{0,1,4},								{0,1,9},{0,1,10},
												{0,0,5},{0,0,6},{0,0,7},{0,0,8}
		
		};

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos corner) {
		if (canSpawnHere(worldIn, corner)) {
			IBlockState n = Blocks.BEDROCK.getDefaultState();
			BuildGate(worldIn, corner, n);
			System.out.println("Built a cabin starting at " + corner + "!");
			return true;
		} else
			System.out.println("Sorry, can't spawn a cabin at " + corner);
		return false;
	}

	private boolean canSpawnHere(World worldIn, BlockPos pos) {
		return canReplace(worldIn, pos);
	}

	private void BuildGate(World world, BlockPos frontLeftCorner, IBlockState toPlace) {
		for (int[] coord : blockPositions) {
			placeBlock(world, frontLeftCorner, coord[0], coord[1], coord[2], toPlace);
		}
	}

	private void placeBlock(World world, BlockPos frontLeftCorner, int offsetX, int offsetY, int offsetZ,
			IBlockState toPlace) {
		BlockPos placePos = frontLeftCorner.add(offsetX, offsetY, offsetZ);
		world.setBlockState(placePos, toPlace, 2);
	}

	private boolean canReplace(World world, BlockPos pos) {
		IBlockState at = world.getBlockState(pos);
		Material material = at.getMaterial();
		// we think it's replaceable if it's air / liquid / snow, plants, or
		// leaves
		return material.isReplaceable() || material == Material.PLANTS || material == Material.LEAVES;
	}
}