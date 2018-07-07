package me.koenn.planetarium.block;

import me.koenn.planetarium.tileentity.TileEntityFusionReactor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFusionReactor extends BlockTileEntity<TileEntityFusionReactor> {

    //private static final AxisAlignedBB AXIS_ALIGNED_BB = new AxisAlignedBB();

    public BlockFusionReactor(String name) {
        super(name, Material.IRON);
    }

    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public Class<TileEntityFusionReactor> getTileEntityClass() {
        return TileEntityFusionReactor.class;
    }

    @Override
    public TileEntityFusionReactor createTileEntity(World world, IBlockState state) {
        return new TileEntityFusionReactor();
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return new AxisAlignedBB(0.1, 0, 0.1, 0.9, 1.1, 0.9);
    }
}
