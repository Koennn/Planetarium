package me.koenn.planetarium;

import me.koenn.planetarium.block.ModBlocks;
import me.koenn.planetarium.container.ModGuiHandler;
import me.koenn.planetarium.item.ModItems;
import me.koenn.planetarium.proxy.CommonProxy;
import me.koenn.planetarium.tab.PlanetariumTab;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(
        modid = Planetarium.MOD_ID,
        name = Planetarium.MOD_NAME,
        version = Planetarium.VERSION
)
public class Planetarium {

    public static final String MOD_ID = "planetarium";
    public static final String MOD_NAME = "Planetarium";
    public static final String VERSION = "1.0";

    public static final CreativeTabs CREATIVE_TAB = new PlanetariumTab();

    static {
        FluidRegistry.enableUniversalBucket();
    }

    @Mod.Instance
    public static Planetarium INSTANCE;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new ModGuiHandler());
        proxy.registerRenderers();
    }

    @SidedProxy(serverSide = "me.koenn.planetarium.proxy.CommonProxy", clientSide = "me.koenn.planetarium.proxy.ClientProxy")
    public static CommonProxy proxy;

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModItems.register(event.getRegistry());
            ModBlocks.registerItemBlocks(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            ModBlocks.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event) {
            ModItems.registerModels();
            ModBlocks.registerModels();
        }
    }
}
