package me.koenn.planetarium.block;

import me.koenn.planetarium.Planetarium;
import me.koenn.planetarium.container.ModGuiHandler;
import me.koenn.planetarium.tileentity.TileEntityCrate;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class BlockCrate extends BlockTileEntity<TileEntityCrate> {

    public BlockCrate(String name) {
        super(name, Material.WOOD);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.isSneaking()) {
            if (!worldIn.isRemote) {
                playerIn.openGui(Planetarium.INSTANCE, ModGuiHandler.CRATE, worldIn, pos.getX(), pos.getY(), pos.getZ());
            }
            return true;
        }
        return false;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntityCrate tile = getTileEntity(world, pos);
        IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        if (itemHandler != null) {
            for (int i = 0; i < itemHandler.getSlots(); i++) {
                ItemStack stack = itemHandler.getStackInSlot(i);
                if (!stack.isEmpty()) {
                    world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack));
                }
            }
        }
        super.breakBlock(world, pos, state);
    }

    @Override
    public Class<TileEntityCrate> getTileEntityClass() {
        return TileEntityCrate.class;
    }

    @Override
    public TileEntityCrate createTileEntity(World world, IBlockState state) {
        return new TileEntityCrate();
    }
}
