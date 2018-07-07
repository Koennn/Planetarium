package me.koenn.planetarium.item;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    public static final ItemFoodBase nutrition_bar = new ItemFoodBase("nutrition_bar", 7, 0.8F, 24);
    public static final ItemFoodBase sealed_mre = new ItemFoodBase("sealed_mre", 8, 1.2F, 4, false, 48);
    public static final ItemFoodBase sealed_soup = new ItemFoodBase("sealed_soup", 5, 0.3F, 10, true, 32);
    public static final ItemFoodBase jelly_bean = new ItemJellyBean("jelly_bean", 1, 0.1F);

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                nutrition_bar,
                sealed_mre,
                sealed_soup,
                jelly_bean
        );
    }

    public static void registerModels() {
        nutrition_bar.registerItemModel();
        sealed_mre.registerItemModel();
        sealed_soup.registerItemModel();
        jelly_bean.registerItemModel();
    }
}
