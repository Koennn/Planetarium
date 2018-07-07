package me.koenn.planetarium.tesr;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelActiveFusion extends ModelBase {

    private ModelRenderer renderer;

    public ModelActiveFusion() {

    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.renderer = new ModelRenderer(this, 2, 1);
        this.renderer.render(scale);
    }
}
