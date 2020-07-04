package com.lumos21.luminousmod.objects.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;


public class SpecialBlock extends Block
{
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final VoxelShape SHAPE_N = Stream.of(
			Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
			Block.makeCuboidShape(6, 1, 6, 10, 6, 10),
			Block.makeCuboidShape(2, 6, 2, 14, 7, 14),
			Block.makeCuboidShape(2, 7, 2, 14, 17, 3)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	private static final VoxelShape SHAPE_E = Stream.of(
			Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
			Block.makeCuboidShape(6, 1, 6, 10, 6, 10),
			Block.makeCuboidShape(2, 6, 2, 14, 7, 14),
			Block.makeCuboidShape(2, 7, 2, 3, 17, 14)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	private static final VoxelShape SHAPE_W = Stream.of(
			Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
			Block.makeCuboidShape(6, 1, 6, 10, 6, 10),
			Block.makeCuboidShape(2, 6, 2, 14, 7, 14),
			Block.makeCuboidShape(13, 7, 2, 14, 17, 14)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	private static final VoxelShape SHAPE_S = Stream.of(
			Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
			Block.makeCuboidShape(6, 1, 6, 10, 6, 10),
			Block.makeCuboidShape(2, 6, 2, 14, 7, 14),
			Block.makeCuboidShape(2, 7, 2, 14, 17, 3)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	
	public SpecialBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch(state.get(FACING)) {
		case NORTH:
			return SHAPE_N;
		case SOUTH:
			return SHAPE_S;
		case EAST:
			return SHAPE_E;
		case WEST:
			return SHAPE_W;
		default:
			return SHAPE_N;
		}
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}
	
	@Override
	public BlockState rotate(BlockState state, Rotation rot)
	{
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}
	
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}
	@Override
	public ActionResultType func_225533_a_(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
		if(!p_225533_2_.isRemote())
		{
			ServerWorld serverWorld = (ServerWorld)p_225533_2_;
			LightningBoltEntity entity = new LightningBoltEntity(p_225533_2_, p_225533_3_.getX(), p_225533_3_.getY(), p_225533_3_.getZ(), false);
			serverWorld.addLightningBolt(entity);
			
		}
		return ActionResultType.SUCCESS;
	}
}

