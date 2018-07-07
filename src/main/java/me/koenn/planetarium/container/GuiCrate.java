package me.koenn.planetarium.container;

import me.koenn.planetarium.block.ModBlocks;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiCrate extends GuiContainer {

    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation("planetarium", "textures/gui/crate.png");

    private final InventoryPlayer playerInv;

    public GuiCrate(Container container, InventoryPlayer playerInv) {
        super(container);
        this.playerInv = playerInv;
        this.ySize = 114 + (3 * 18);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String name = I18n.format(ModBlocks.crate.getUnlocalizedName() + ".name");
        fontRenderer.drawString(name, 8, 6, 4210752);
        fontRenderer.drawString(playerInv.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1, 1, 1, 1);
        mc.getTextureManager().bindTexture(GUI_TEXTURE);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
}
