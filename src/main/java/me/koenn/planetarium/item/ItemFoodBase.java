package me.koenn.planetarium.item;

import me.koenn.planetarium.Planetarium;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import toughasnails.api.thirst.ThirstHelper;

public class ItemFoodBase extends ItemFood {

    private final String name;
    private final int water;
    private final boolean use;
    private final int eatDuration;

    public ItemFoodBase(String name, int amount, float saturation, int water, boolean use, int eatDuration) {
        super(amount, saturation, false);
        this.name = name;
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.water = water;
        this.use = use;
        this.eatDuration = eatDuration;
    }

    public ItemFoodBase(String name, int amount, float saturation, int eatDuration) {
        this(name, amount, saturation, 0, false, eatDuration);
    }

    public void registerItemModel() {
        Planetarium.proxy.registerItemRenderer(this, 0, this.name);
    }

    @Override
    public CreativeTabs getCreativeTab() {
        return Planetarium.CREATIVE_TAB;
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        if (this.water > 0) {
            ThirstHelper.getThirstData(player).addStats(Math.round(this.water * (this.use ? 1 : -1)), 0.0F);
        }
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return this.eatDuration;
    }
}
