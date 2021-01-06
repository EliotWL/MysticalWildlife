package lykrast.mysticalwildlife.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GLX;
//import com.mojang.blaze3d.platform.GlStateManager;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class LayerEyesAbstract<T extends Entity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
    public LayerEyesAbstract(IEntityRenderer<T, M> p_i226039_1_) {
    	super(p_i226039_1_);
    }
    
    protected abstract ResourceLocation getEyeTexture(T entity);

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch)
    {
		/*this.bindTexture(getEyeTexture(entityIn));
		//GlStateManager.enableBlend();
		//GlStateManager.disableAlphaTest();
		//GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
		if (entityIn.isInvisible()) GlStateManager.depthMask(false);
		else GlStateManager.depthMask(true);

		int i = 61680;
		int j = i % 65536;
		int k = i / 65536;
		GLX.glMultiTexCoord2f(GLX.GL_TEXTURE1, (float) j, (float) k);
		//GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		GameRenderer gamerenderer = Minecraft.getInstance().gameRenderer;
		gamerenderer.setupFogColor(true);
		getEntityModel().render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		gamerenderer.setupFogColor(false);
		i = entityIn.getBrightnessForRender();
		j = i % 65536;
		k = i / 65536;
		GLX.glMultiTexCoord2f(GLX.GL_TEXTURE1, (float) j, (float) k);
		this.func_215334_a(entityIn);
		//GlStateManager.depthMask(true);
		//GlStateManager.disableBlend();
		//GlStateManager.enableAlphaTest();

		 */

		IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.getRenderType(entitylivingbaseIn));
		this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

	}

   /* @Override
    public boolean shouldCombineTextures() {
        return false;
    }*/

	public abstract RenderType getRenderType(T in);
}
