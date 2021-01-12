package lykrast.mysticalwildlife.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
//import com.mojang.blaze3d.platform.GlStateManager;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.MathHelper;

/**
 * cicaptera - Lykrast
 * Edited for 1.15.2 by EliotWL
 */
public class ModelCicaptera<T extends MobEntity> extends EntityModel<T> {
	protected static final float PI_HALF = ((float)Math.PI / 2F); //90�
	protected static final float PI_THIRD = ((float)Math.PI / 3F); //60�
	protected static final float PI_NINTH = ((float)Math.PI / 9F); //20�
	protected static final float PI_TWELVETH = ((float)Math.PI / 12F); //15�
	protected static final float WING_BASE = 0.17453292519943295F; //From Tabula
    
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer wingLeft;
    public ModelRenderer wingRight;
    public ModelRenderer legLeftFront;
    public ModelRenderer legLeftBack;
    public ModelRenderer legRightFront;
    public ModelRenderer legRightBack;
    public ModelRenderer eyeLeft;
    public ModelRenderer eyeRight;

    public ModelCicaptera() {
        textureWidth = 32;
        textureHeight = 32;
        body = new ModelRenderer(this, 12, 18);
        body.setRotationPoint(0.0F, 20.2F, -4.0F);
        body.addBox(-3.0F, 0.0F, -3.0F, 6, 10, 4, 0.0F);
        setRotateAngle(body, 1.5707963267948966F, 0.0F, 0.0F);
        legLeftFront = new ModelRenderer(this, 0, 26);
        legLeftFront.setRotationPoint(3.5F, 2.0F, 0.0F);
        legLeftFront.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        setRotateAngle(legLeftFront, -1.5707963267948966F, -0.2617993877991494F, 0.0F);
        legRightFront = new ModelRenderer(this, 0, 26);
        legRightFront.mirror = true;
        legRightFront.setRotationPoint(-3.5F, 2.0F, 0.0F);
        legRightFront.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        setRotateAngle(legRightFront, -1.5707963267948966F, 0.2617993877991494F, 0.0F);
        legRightBack = new ModelRenderer(this, 0, 26);
        legRightBack.mirror = true;
        legRightBack.setRotationPoint(-3.5F, 8.0F, 0.0F);
        legRightBack.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        setRotateAngle(legRightBack, -1.5707963267948966F, 0.2617993877991494F, 0.0F);
        eyeLeft = new ModelRenderer(this, 0, 0);
        eyeLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        eyeLeft.addBox(2.5F, -1.0F, -3.0F, 1, 1, 1, 0.0F);
        wingRight = new ModelRenderer(this, 0, 13);
        wingRight.mirror = true;
        wingRight.setRotationPoint(-0.9F, 1.0F, 1.0F);
        wingRight.addBox(-3.0F, 0.0F, 0.0F, 4, 12, 1, 0.0F);
        setRotateAngle(wingRight, 0.0F, -0.17453292519943295F, 0.0F);
        head = new ModelRenderer(this, 0, 0);
        head.setRotationPoint(0.0F, 20.2F, -4.0F);
        head.addBox(-3.0F, -2.0F, -4.0F, 6, 4, 4, 0.0F);
        legLeftBack = new ModelRenderer(this, 0, 26);
        legLeftBack.setRotationPoint(3.5F, 8.0F, 0.0F);
        legLeftBack.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        setRotateAngle(legLeftBack, -1.5707963267948966F, -0.2617993877991494F, 0.0F);
        wingLeft = new ModelRenderer(this, 0, 13);
        wingLeft.setRotationPoint(0.9F, 1.0F, 1.0F);
        wingLeft.addBox(-1.0F, 0.0F, 0.0F, 4, 12, 1, 0.0F);
        setRotateAngle(wingLeft, 0.0F, 0.17453292519943295F, 0.0F);
        eyeRight = new ModelRenderer(this, 0, 0);
        eyeRight.mirror = true;
        eyeRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        eyeRight.addBox(-3.5F, -1.0F, -3.0F, 1, 1, 1, 0.0F);
        body.addChild(legLeftFront);
        body.addChild(legRightFront);
        body.addChild(legRightBack);
        head.addChild(eyeLeft);
        body.addChild(wingRight);
        body.addChild(legLeftBack);
        body.addChild(wingLeft);
        head.addChild(eyeRight);
    }

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        head.rotateAngleX = headPitch * 0.017453292F;
        head.rotateAngleY = netHeadYaw * 0.017453292F;
        
        if (!entityIn.onGround && !entityIn.isInWater() && !((MobEntity)entityIn).isAIDisabled()) {
        	//In the air, deploy wings
            body.rotateAngleX = PI_THIRD;
            legRightBack.rotateAngleX = -PI_THIRD;
            legLeftBack.rotateAngleX = -PI_THIRD;
            legRightFront.rotateAngleX = -PI_THIRD;
            legLeftFront.rotateAngleX = -PI_THIRD;
            
            wingLeft.rotateAngleX = PI_THIRD;
            wingRight.rotateAngleX = PI_THIRD;
            //TODO: make more noticeable
            wingLeft.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * PI_TWELVETH * limbSwingAmount + PI_NINTH;
            wingRight.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * PI_TWELVETH * limbSwingAmount * (-1) - PI_NINTH;
        }
        else {
        	//On the ground, do as normal
            body.rotateAngleX = PI_HALF;
            legRightBack.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - PI_HALF;
            legLeftBack.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount - PI_HALF;
            legRightFront.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount - PI_HALF;
            legLeftFront.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - PI_HALF;
            
            wingLeft.rotateAngleX = 0.0F;
            wingRight.rotateAngleX = 0.0F;
            wingLeft.rotateAngleY = WING_BASE;
            wingRight.rotateAngleY = -WING_BASE;
        }
        
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        //setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

        if (isChild) {
            matrixStackIn.push();
            matrixStackIn.scale(0.5F, 0.5F, 0.5F);
            matrixStackIn.translate(0.0F, 1.5F, 0.0F);
            ImmutableList.of(this.head, this.body).forEach((p_228292_8_) -> {
                p_228292_8_.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            });
            //ImmutableList.of(this.head, this.legLeftBack, this.legLeftFront, this.legRightBack, this.legRightFront, this.body, this.eyeLeft, this.eyeRight, this.wingLeft, this.wingRight).forEach((p_228292_8_) -> {
            //                p_228292_8_.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            //            });
            /*matrixStackIn.pop();
            matrixStackIn.push();
            matrixStackIn.scale(0.5F, 0.5F, 0.5F);
            matrixStackIn.translate(0.0D, 2.25D, 0.0D);
            ImmutableList.of(this.head, this.legLeftBack, this.legLeftFront, this.legRightBack, this.legRightFront, this.body, this.eyeLeft, this.eyeRight, this.wingLeft, this.wingRight).forEach((p_228291_8_) -> {
                p_228291_8_.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            });*/
            matrixStackIn.pop();
        } else {
            matrixStackIn.push();
            matrixStackIn.scale(0.6F, 0.4F, 0.6F);
            matrixStackIn.translate(0.0F, 2.0F, 0.0F);
            ImmutableList.of(this.head, this.body).forEach((p_228292_8_) -> {
                p_228292_8_.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            });;
            matrixStackIn.pop();
        }
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer RendererModel, float x, float y, float z) {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
    }
}
