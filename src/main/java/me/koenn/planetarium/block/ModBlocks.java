package me.koenn.planetarium.block;

import me.koenn.planetarium.Planetarium;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {

    public static BlockRadioactiveIce radioactive_ice = new BlockRadioactiveIce("radioactive_ice");
    public static BlockFusionReactor fusion_reactor = new BlockFusionReactor("fusion_reactor");
    public static BlockFusionReactorController fusion_reactor_controller = new BlockFusionReactorController("fusion_reactor_controller");
    public static BlockCrate crate = new BlockCrate("crate");

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                radioactive_ice,
                fusion_reactor,
                fusion_reactor_controller,
                crate
        );

        GameRegistry.registerTileEntity(crate.getTileEntityClass(), new ResourceLocation(Planetarium.MOD_ID, crate.getUnlocalizedName()));
        GameRegistry.registerTileEntity(fusion_reactor.getTileEntityClass(), new ResourceLocation(Planetarium.MOD_ID, fusion_reactor.getUnlocalizedName()));
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(
                radioactive_ice.createItemBlock(),
                fusion_reactor.createItemBlock(),
                fusion_reactor_controller.createItemBlock(),
                crate.createItemBlock()
        );
    }

    public static void registerModels() {
        radioactive_ice.registerItemModel(Item.getItemFromBlock(radioactive_ice));
        fusion_reactor.registerItemModel(Item.getItemFromBlock(fusion_reactor));
        fusion_reactor_controller.registerItemModel(Item.getItemFromBlock(fusion_reactor_controller));
        crate.registerItemModel(Item.getItemFromBlock(crate));
    }
}
