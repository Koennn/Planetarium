package me.koenn.planetarium.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemJellyBean extends ItemFoodBase {

    public ItemJellyBean(String unlocalizedName, int amount, float saturation) {
        super(unlocalizedName, amount, saturation, 8);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("Just a single jelly bean...");
    }
}
