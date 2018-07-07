package me.koenn.planetarium.tab;

import me.koenn.planetarium.Planetarium;
import me.koenn.planetarium.item.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class PlanetariumTab extends CreativeTabs {

    public PlanetariumTab() {
        super(Planetarium.MOD_ID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.nutrition_bar);
    }
}
