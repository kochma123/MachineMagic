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
		{0,-1,0},{1,-1,0},{2,-1,0},{3,-1,0},{4,-1,0},
		{0,-1,1},{1,-1,1},{2,-1,1},{3,-1,1},{4,-1,1},
		{0,-1,2},{1,-1,2},{2,-1,2},{3,-1,2},{4,-1,2},
		{0,-1,3},{1,-1,3},{2,-1,3},{3,-1,3},{4,-1,3},
		{0,-1,4},{1,-1,4},{2,-1,4},{3,-1,4},{4,-1,4},
		
		{0,0,0},{4,0,0},
		{0,0,4},{4,0,4},
		
		{0,1,0},{4,1,0},
		{0,1,4},{4,1,4}
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