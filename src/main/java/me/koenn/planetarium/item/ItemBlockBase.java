package me.koenn.planetarium.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockBase extends ItemBlock {

    public ItemBlockBase(Block block) {
        super(block);
        this.setUnlocalizedName(block.getUnlocalizedName());
        this.setRegistryName(block.getUnlocalizedName());
    }
}
