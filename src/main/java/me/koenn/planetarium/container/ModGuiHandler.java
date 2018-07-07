package me.koenn.planetarium.container;

import me.koenn.planetarium.tileentity.TileEntityCrate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import java.util.Objects;

public class ModGuiHandler implements IGuiHandler {

    public static final int CRATE = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case CRATE:
                return new ContainerCrate(player.inventory, (TileEntityCrate) Objects.requireNonNull(world.getTileEntity(new BlockPos(x, y, z))));
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case CRATE:
                return new GuiCrate((Container) getServerGuiElement(ID, player, world, x, y, z), player.inventory);
            default:
                return null;
        }
    }
}
