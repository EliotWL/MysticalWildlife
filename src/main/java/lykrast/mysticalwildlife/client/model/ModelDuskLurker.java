package lykrast.mysticalwildlife.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
//import com.mojang.blaze3d.platform.GlStateManager;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * dusk_lurker - Lykrast
 * Created using Tabula 7.0.0
 */
public class ModelDuskLurker<T extends Entity> extends QuadrupedBaseModel<T> {

    //public ModelRenderer legLeftFront;
    public ModelRenderer snout;
    //public ModelRenderer body;
    //public ModelRenderer legRightBack;
    //public ModelRenderer head;
    //public ModelRenderer legRightFront;
    //public ModelRenderer legLeftBack;

    public ModelDuskLurker() {
        super(6, 0.0F, false, 4.0F, 4.0F, 2.0F, 2.0F, 24);
    	textureWidth = 64;
        textureHeight = 48;
        legLeftFront = new ModelRenderer(this, 0, 34);
        legLeftFront.setRotationPoint(7.0F, 14.0F, -4.0F);
        legLeftFront.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
        snout = new ModelRenderer(this, 0, 16);
        snout.setRotationPoint(0.0F, 0.0F, 0.0F);
        snout.addBox(-3.0F, -1.0F, -14.0F, 6, 4, 6, 0.0F);
        legRightBack = new ModelRenderer(this, 0, 34);
        legRightBack.mirror = true;
        legRightBack.setRotationPoint(-7.0F, 14.0F, 5.0F);
        legRightBack.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
        body = new ModelRenderer(this, 28, 24);
        body.setRotationPoint(0.0F, 12.0F, 2.0F);
        body.addBox(-5.0F, -10.0F, -7.0F, 10, 16, 8, 0.0F);
        //setRotationAngles(body, 1.5707963267948966F, 0.0F, 0.0F, 0.0F, 0.0F);
        head = new ModelRenderer(this, 0, 0);
        head.setRotationPoint(0.0F, 14.0F, -6.0F);
        head.addBox(-4.0F, -4.0F, -8.0F, 8, 8, 8, 0.0F);
        legRightFront = new ModelRenderer(this, 0, 34);
        legRightFront.mirror = true;
        legRightFront.setRotationPoint(-7.0F, 14.0F, -4.0F);
        legRightFront.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
        legLeftBack = new ModelRenderer(this, 0, 34);
        legLeftBack.setRotationPoint(7.0F, 14.0F, 5.0F);
        legLeftBack.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
        head.addChild(snout);
    }
}
