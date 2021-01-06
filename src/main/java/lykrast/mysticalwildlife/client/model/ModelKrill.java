package lykrast.mysticalwildlife.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import lykrast.mysticalwildlife.common.entity.EntityKrill;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

/**
 * Krill - Lykrast
 * Created using Tabula 7.0.0
 */
public class ModelKrill<T extends EntityKrill> extends EntityModel<T> {
	protected static final float LEG_ANGLE = 2.356194490192345F; //From Tabula
	protected static final float FOOT_ANGLE = 2.1816615649929116F; //From Tabula
	protected static final float HEAD_ANGLE = 0.2617993877991494F; //From Tabula
	protected static final float FORAGE_ANGLE = (float)Math.PI / 3; //60�
	
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer legFL;
    public ModelRenderer legML;
    public ModelRenderer legBL;
    public ModelRenderer legFR;
    public ModelRenderer legMR;
    public ModelRenderer legBR;
    public ModelRenderer tentacle;
    public ModelRenderer footFL;
    public ModelRenderer footML;
    public ModelRenderer footBL;
    public ModelRenderer footFR;
    public ModelRenderer footMR;
    public ModelRenderer footBR;

    public ModelKrill() {
        textureWidth = 32;
        textureHeight = 32;
        footML = new ModelRenderer(this, 0, 23);
        footML.setRotationPoint(0.0F, 4.0F, 0.0F);
        footML.addBox(-0.5F, 0.0F, -0.5F, 1, 8, 1, 0.0F);
        setRotateAngle(footML, 0.0F, 0.0F, FOOT_ANGLE);
        footMR = new ModelRenderer(this, 0, 23);
        footMR.mirror = true;
        footMR.setRotationPoint(0.0F, 4.0F, 0.0F);
        footMR.addBox(-0.5F, 0.0F, -0.5F, 1, 8, 1, 0.0F);
        setRotateAngle(footMR, 0.0F, 0.0F, -FOOT_ANGLE);
        legBR = new ModelRenderer(this, 0, 18);
        legBR.mirror = true;
        legBR.setRotationPoint(-1.5F, 19.0F, 6.0F);
        legBR.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, -0.1F);
        setRotateAngle(legBR, 0.0F, 0.0F, LEG_ANGLE);
        legBL = new ModelRenderer(this, 0, 18);
        legBL.setRotationPoint(1.5F, 19.0F, 6.0F);
        legBL.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, -0.1F);
        setRotateAngle(legBL, 0.0F, 0.0F, -LEG_ANGLE);
        footFR = new ModelRenderer(this, 0, 23);
        footFR.mirror = true;
        footFR.setRotationPoint(0.0F, 4.0F, 0.0F);
        footFR.addBox(-0.5F, 0.0F, -0.5F, 1, 8, 1, 0.0F);
        setRotateAngle(footFR, 0.0F, 0.0F, -FOOT_ANGLE);
        legFR = new ModelRenderer(this, 0, 18);
        legFR.mirror = true;
        legFR.setRotationPoint(-1.5F, 19.0F, 0.0F);
        legFR.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, -0.1F);
        setRotateAngle(legFR, 0.0F, 0.0F, LEG_ANGLE);
        tentacle = new ModelRenderer(this, 0, 9);
        tentacle.setRotationPoint(-0.75F, -0.75F, -4.5F);
        tentacle.addBox(-0.25F, -0.75F, -3.0F, 2, 2, 3, 0.0F);
        setRotateAngle(tentacle, 0.6981317007977318F, 0.0F, 0.0F);
        footFL = new ModelRenderer(this, 0, 23);
        footFL.setRotationPoint(0.0F, 4.0F, 0.0F);
        footFL.addBox(-0.5F, 0.0F, -0.5F, 1, 8, 1, 0.0F);
        setRotateAngle(footFL, 0.0F, 0.0F, FOOT_ANGLE);
        footBL = new ModelRenderer(this, 0, 23);
        footBL.setRotationPoint(0.0F, 4.0F, 0.0F);
        footBL.addBox(-0.5F, 0.0F, -0.5F, 1, 8, 1, 0.0F);
        setRotateAngle(footBL, 0.0F, 0.0F, FOOT_ANGLE);
        legMR = new ModelRenderer(this, 0, 18);
        legMR.mirror = true;
        legMR.setRotationPoint(-1.5F, 19.0F, 3.0F);
        legMR.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, -0.1F);
        setRotateAngle(legMR, 0.0F, 0.0F, LEG_ANGLE);
        body = new ModelRenderer(this, 16, 20);
        body.setRotationPoint(0.0F, 19.0F, 0.0F);
        body.addBox(-2.0F, -1.0F, -2.0F, 4, 8, 4, 0.0F);
        setRotateAngle(body, 1.5707963267948966F, 0.0F, 0.0F);
        head = new ModelRenderer(this, 0, 0);
        head.setRotationPoint(0.0F, 19.0F, -1.0F);
        head.addBox(-1.5F, -1.5F, -5.0F, 3, 3, 6, 0.0F);
        setRotateAngle(head, HEAD_ANGLE, 0.0F, 0.0F);
        legFL = new ModelRenderer(this, 0, 18);
        legFL.setRotationPoint(1.5F, 19.0F, 0.0F);
        legFL.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, -0.1F);
        setRotateAngle(legFL, 0.0F, 0.0F, -LEG_ANGLE);
        legML = new ModelRenderer(this, 0, 18);
        legML.setRotationPoint(1.5F, 19.0F, 3.0F);
        legML.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, -0.1F);
        setRotateAngle(legML, 0.0F, 0.0F, -LEG_ANGLE);
        footBR = new ModelRenderer(this, 0, 23);
        footBR.mirror = true;
        footBR.setRotationPoint(0.0F, 4.0F, 0.0F);
        footBR.addBox(-0.5F, 0.0F, -0.5F, 1, 8, 1, 0.0F);
        setRotateAngle(footBR, 0.0F, 0.0F, -FOOT_ANGLE);
        legML.addChild(footML);
        legMR.addChild(footMR);
        legFR.addChild(footFR);
        head.addChild(tentacle);
        legFL.addChild(footFL);
        legBL.addChild(footBL);
        legBR.addChild(footBR);
    }
    
    private float headRotateX = -1;


    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        head.rotateAngleX = headRotateX <= 0 ? headPitch * 0.017453292F + HEAD_ANGLE : headRotateX;
        head.rotateAngleY = netHeadYaw * 0.017453292F;
        
        float forwards = MathHelper.cos(limbSwing) * 0.523599F * limbSwingAmount;
        float backwards = -forwards;
        
        legFL.rotateAngleX = forwards;
        legFL.rotateAngleY = backwards;
        legML.rotateAngleX = backwards;
        legML.rotateAngleY = forwards;
        legBL.rotateAngleX = forwards;
        legBL.rotateAngleY = backwards;
        
        legFR.rotateAngleX = backwards;
        legFR.rotateAngleY = forwards;
        legMR.rotateAngleX = forwards;
        legMR.rotateAngleY = backwards;
        legBR.rotateAngleX = backwards;
        legBR.rotateAngleY = forwards;
    }
    
    @Override
    public void setLivingAnimations(T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
        super.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTickTime);

    	int timer = ((EntityKrill)entitylivingbaseIn).forageProgress;
    	if (timer > 0)
    	{
    		if (timer <= 4)
    			headRotateX = (float)MathHelper.clampedLerp(HEAD_ANGLE, FORAGE_ANGLE, (timer - partialTickTime)/4);
    		else if (timer > 36)
    			headRotateX = (float)MathHelper.clampedLerp(HEAD_ANGLE, FORAGE_ANGLE, (40 - timer + partialTickTime)/4);
    		else
    			headRotateX = FORAGE_ANGLE;
    	}
    	else headRotateX = -1;
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        //setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);

        if (isChild)
        {
            /*GlStateManager.pushMatrix();
            GlStateManager.scalef(0.5F, 0.5F, 0.5F);
            GlStateManager.translatef(0.0F, 24.0F * scale, 0.0F);
            legBR.render(scale);
            legBL.render(scale);
            legFR.render(scale);
            legMR.render(scale);
            body.render(scale);
            head.render(scale);
            legFL.render(scale);
            legML.render(scale);
            GlStateManager.popMatrix();
             */
            matrixStackIn.push();
            matrixStackIn.scale(0.56666666F, 0.56666666F, 0.56666666F);
            matrixStackIn.translate(0.0D, 1.375D, 0.125D);
            ImmutableList.of(this.head, this.legBR, this.legBL, this.legFR, this.legMR, this.body, this.legFL, this.legML).forEach((p_228292_8_) -> {
                p_228292_8_.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            });
            matrixStackIn.pop();
            matrixStackIn.push();
            matrixStackIn.scale(0.4F, 0.4F, 0.4F);
            matrixStackIn.translate(0.0D, 2.25D, 0.0D);
            ImmutableList.of(this.head, this.legBR, this.legBL, this.legFR, this.legMR, this.body, this.legFL, this.legML).forEach((p_228291_8_) -> {
                p_228291_8_.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            });
            matrixStackIn.pop();
        }
        else
        {
            matrixStackIn.push();
            matrixStackIn.scale(0.6F, 0.6F, 0.6F);
            matrixStackIn.translate(0.0D, 1.0D, 0.0D);
            ImmutableList.of(this.head, this.legBR, this.legBL, this.legFR, this.legMR, this.body, this.legFL, this.legML).forEach((p_228290_8_) -> {
                p_228290_8_.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            });
            matrixStackIn.pop();
        }
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
