package me.koenn.planetarium.proxy;

import me.koenn.planetarium.Planetarium;
import me.koenn.planetarium.tesr.TESRFusionReactor;
import me.koenn.planetarium.tileentity.TileEntityFusionReactor;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

    private static final String MOD_ID_PREFIX = Planetarium.MOD_ID + ":%s";

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(String.format(MOD_ID_PREFIX, id), "inventory"));
    }

    @Override
    public void registerRenderers() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFusionReactor.class, new TESRFusionReactor());
    }
}
