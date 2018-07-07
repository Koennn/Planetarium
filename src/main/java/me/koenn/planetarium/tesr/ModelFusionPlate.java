package me.koenn.planetarium.tesr;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFusionPlate extends ModelBase {

    private ModelRenderer renderer;

    public ModelFusionPlate() {
        this.renderer = new ModelRenderer(this, 2, 1);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.renderer = new ModelRenderer(this, 2, 1);
        this.renderer.addBox(1, -1, 1, 14, 1, 14);

        this.renderer.addBox(14, 0.5F, 14, 1, 1, 14);
        this.renderer.addBox(14, 0.5F, 14, 14, 1, 1);
        this.renderer.addBox(28, -16, 13.5F, 2, 28, 2);
        this.renderer.addBox(13.5F, -16, 28, 2, 28, 2);

        this.renderer.addBox(-12, 0.5F, 14, 14, 1, 1);
        this.renderer.addBox(1, 0.5F, 14, 1, 1, 14);
        this.renderer.addBox(0.5F, -16, 28, 2, 28, 2);
        this.renderer.addBox(-14F, -16, 13.5F, 2, 28, 2);

        this.renderer.addBox(1, 0.5F, -12, 1, 1, 14);
        this.renderer.addBox(-12, 0.5F, 1, 14, 1, 1);
        this.renderer.addBox(-14F, -16, 0.5F, 2, 28, 2);
        this.renderer.addBox(0.5F, -16, -12, 2, 28, 2);

        this.renderer.addBox(14, 0.5F, -12, 1, 1, 14);
        this.renderer.addBox(14, 0.5F, 1, 14, 1, 1);
        this.renderer.addBox(13.5F, -16, -12, 2, 28, 2);
        this.renderer.addBox(28, -16, 0.5F, 2, 28, 2);
        this.renderer.render(scale);
    }
}
