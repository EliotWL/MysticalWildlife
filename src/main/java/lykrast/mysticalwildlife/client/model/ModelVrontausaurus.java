package lykrast.mysticalwildlife.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
//import com.mojang.blaze3d.platform.GlStateManager;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * vrontausurus2 - Lykrast Created using Tabula 7.0.0
 */
public class ModelVrontausaurus<T extends Entity> extends QuadrupedBaseModel<T> {
	public ModelRenderer plateLowerFront;
	public ModelRenderer plateLowerBack;
	public ModelRenderer plateUpperFront;
	public ModelRenderer plateUpperBack;
	public ModelRenderer snout;

	public ModelVrontausaurus() {
		super(6, 0.0F, false, 4.0F, 4.0F, 2.0F, 2.0F, 24);
	    float childYOffset = 8.0F;
	    float childZOffset = 7.0F;
	    
		textureWidth = 128;
		textureHeight = 64;
		legRightFront = new ModelRenderer(this, 0, 38);
		legRightFront.mirror = true;
		legRightFront.setRotationPoint(-12.0F, 6.0F, -4.0F);
		legRightFront.addBox(-4.0F, 0.0F, -4.0F, 8, 18, 8, 0.0F);
		body = new ModelRenderer(this, 68, 18);
		body.setRotationPoint(0.0F, 8.0F, 0.0F);
		body.addBox(-8.0F, -12.0F, -9.0F, 16, 32, 14, 0.0F);
		//setRotationAngles(1.5707963267948966F, 0.0F, 0.0F);
		legLeftFront = new ModelRenderer(this, 0, 38);
		legLeftFront.setRotationPoint(12.0F, 6.0F, -4.0F);
		legLeftFront.addBox(-4.0F, 0.0F, -4.0F, 8, 18, 8, 0.0F);
		plateLowerBack = new ModelRenderer(this, 58, 55);
		plateLowerBack.setRotationPoint(0.0F, 12.0F, 5.0F);
		plateLowerBack.addBox(-2.0F, -4.0F, 0.0F, 4, 8, 1, 0.0F);
		legLeftBack = new ModelRenderer(this, 0, 38);
		legLeftBack.setRotationPoint(12.0F, 6.0F, 12.0F);
		legLeftBack.addBox(-4.0F, 0.0F, -4.0F, 8, 18, 8, 0.0F);
		plateLowerFront = new ModelRenderer(this, 58, 55);
		plateLowerFront.setRotationPoint(0.0F, -4.0F, 5.0F);
		plateLowerFront.addBox(-2.0F, -4.0F, 0.0F, 4, 8, 1, 0.0F);
		legRightBack = new ModelRenderer(this, 0, 38);
		legRightBack.mirror = true;
		legRightBack.setRotationPoint(-12.0F, 6.0F, 12.0F);
		legRightBack.addBox(-4.0F, 0.0F, -4.0F, 8, 18, 8, 0.0F);
		head = new ModelRenderer(this, 0, 0);
		head.setRotationPoint(0.0F, 7.0F, -12.0F);
		head.addBox(-6.0F, -5.0F, -8.0F, 12, 10, 8, 0.0F);
		plateUpperFront = new ModelRenderer(this, 60, 46);
		plateUpperFront.setRotationPoint(0.0F, 0.0F, 1.0F);
		plateUpperFront.addBox(-0.5F, -3.0F, 0.0F, 1, 6, 3, 0.0F);
		plateUpperBack = new ModelRenderer(this, 60, 46);
		plateUpperBack.setRotationPoint(0.0F, 0.0F, 1.0F);
		plateUpperBack.addBox(-0.5F, -3.0F, 0.0F, 1, 6, 3, 0.0F);
		snout = new ModelRenderer(this, 0, 18);
		snout.setRotationPoint(0.0F, 0.0F, 0.0F);
		snout.addBox(-4.0F, -2.0F, -16.0F, 8, 6, 8, 0.0F);
		body.addChild(plateLowerBack);
		body.addChild(plateLowerFront);
		plateLowerFront.addChild(plateUpperFront);
		plateLowerBack.addChild(plateUpperBack);
		head.addChild(snout);
	}
}
