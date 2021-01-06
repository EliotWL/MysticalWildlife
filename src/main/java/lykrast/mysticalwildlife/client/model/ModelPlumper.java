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
 * plumper - Lykrast
 * Created using Tabula 7.0.0
 */
public class ModelPlumper<T extends Entity> extends EntityModel<T> {
    protected float childYOffset = 0.0F;
    protected float childZOffset = 4.0F;
    
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer tail;
    public ModelRenderer finLeft;
    public ModelRenderer finRight;

    public ModelPlumper() {
        textureWidth = 64;
        textureHeight = 48;
        tail = new ModelRenderer(this, 32, 16);
        tail.setRotationPoint(0.0F, 22.0F, 6.0F);
        tail.addBox(-6.0F, 0.0F, -2.0F, 12, 8, 4, 0.0F);
        setRotateAngle(tail, 1.5707963267948966F, 0.0F, 0.0F);
        finRight = new ModelRenderer(this, 0, 38);
        finRight.mirror = true;
        finRight.setRotationPoint(-5.0F, 21.0F, 0.0F);
        finRight.addBox(-1.0F, 0.0F, -2.0F, 1, 6, 4, 0.0F);
        setRotateAngle(finRight, 0.0F, 0.0F, 1.0471975511965976F);
        body = new ModelRenderer(this, 28, 28);
        body.setRotationPoint(0.0F, 20.0F, 0.0F);
        body.addBox(-5.0F, -6.0F, -4.0F, 10, 12, 8, 0.0F);
        setRotateAngle(body, 1.5707963267948966F, 0.0F, 0.0F);
        head = new ModelRenderer(this, 0, 0);
        head.setRotationPoint(0.0F, 19.0F, -5.0F);
        head.addBox(-4.0F, -4.0F, -8.0F, 8, 8, 8, 0.0F);
        finLeft = new ModelRenderer(this, 0, 38);
        finLeft.setRotationPoint(5.0F, 21.0F, 0.0F);
        finLeft.addBox(0.0F, 0.0F, -2.0F, 1, 6, 4, 0.0F);
        setRotateAngle(finLeft, 0.0F, 0.0F, -1.0471975511965976F);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        //setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        if (isChild) {
            matrixStackIn.push();
            matrixStackIn.scale(0.56666666F, 0.56666666F, 0.56666666F);
            matrixStackIn.translate(0.0D, 1.375D, 0.125D);
            ImmutableList.of(this.head, this.body, this.tail, this.finLeft, this.finRight).forEach((p_228292_8_) -> {
                p_228292_8_.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            });
            matrixStackIn.pop();
            matrixStackIn.push();
            matrixStackIn.scale(0.4F, 0.4F, 0.4F);
            matrixStackIn.translate(0.0D, 2.25D, 0.0D);
            ImmutableList.of(this.head, this.body, this.tail, this.finLeft, this.finRight).forEach((p_228291_8_) -> {
                p_228291_8_.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            });
            matrixStackIn.pop();
        } else {
            matrixStackIn.push();
            matrixStackIn.scale(0.6F, 0.6F, 0.6F);
            matrixStackIn.translate(0.0D, 1.0D, 0.0D);
            ImmutableList.of(this.head, this.body, this.tail, this.finLeft, this.finRight).forEach((p_228290_8_) -> {
                p_228290_8_.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            });
            matrixStackIn.pop();
        }
    }
    
    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        head.rotateAngleX = headPitch * 0.017453292F;
        head.rotateAngleY = netHeadYaw * 0.017453292F;
//        body.rotateAngleX = ((float)Math.PI / 2F);
        finLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.8F * limbSwingAmount;
        finRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.8F * limbSwingAmount;
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer ModelRenderer, float x, float y, float z) {
        ModelRenderer.rotateAngleX = x;
        ModelRenderer.rotateAngleY = y;
        ModelRenderer.rotateAngleZ = z;
    }
}
