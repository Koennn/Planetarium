package me.koenn.planetarium.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockFusionReactorController extends BlockBase {

    public BlockFusionReactorController(String name) {
        super(name, Material.IRON);
    }

    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    public boolean isFullCube(IBlockState state) {
        return false;
    }
}
