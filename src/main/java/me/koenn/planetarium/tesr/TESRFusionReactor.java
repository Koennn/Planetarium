package me.koenn.planetarium.tesr;

import me.koenn.planetarium.block.ModBlocks;
import me.koenn.planetarium.tileentity.TileEntityFusionReactor;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

public class TESRFusionReactor extends TileEntitySpecialRenderer<TileEntityFusionReactor> {

    private static final ResourceLocation METAL = new ResourceLocation("textures/blocks/anvil_base.png");
    private static final ModelFusionPlate PLATE = new ModelFusionPlate();
    private static final float SCALE = 0.0625F;
    private static final float COLOR = 0.35F;

    @Override
    public void render(TileEntityFusionReactor te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        Block block = te.getWorld().getBlockState(te.getPos().add(0, -1, 0)).getBlock();
        if (!block.equals(ModBlocks.fusion_reactor_controller)) {
            return;
        }

        GlStateManager.pushMatrix();
        {
            GlStateManager.translate((float) x, (float) y, (float) z);
            GlStateManager.scale(SCALE, SCALE, SCALE);
            GlStateManager.color(COLOR, COLOR, COLOR);
            this.bindTexture(METAL);

            PLATE.render(null, 0, 0, 0, 0, 0, 1.0F);
        }
        GlStateManager.popMatrix();
    }
}
