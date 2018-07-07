package me.koenn.planetarium.block;

import me.koenn.planetarium.Planetarium;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block {

    private final String name;

    public BlockBase(String name, Material materialIn) {
        super(materialIn);
        this.name = name;
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(Planetarium.CREATIVE_TAB);
    }

    public void registerItemModel(Item itemBlock) {
        Planetarium.proxy.registerItemRenderer(itemBlock, 0, this.name);
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(this.name);
    }
}
