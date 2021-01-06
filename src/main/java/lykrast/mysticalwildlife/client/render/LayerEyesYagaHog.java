package lykrast.mysticalwildlife.client.render;

import lykrast.mysticalwildlife.common.entity.EntityYagaHog;
import lykrast.mysticalwildlife.common.util.ResourceUtil;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

public class LayerEyesYagaHog<T extends EntityYagaHog, M extends EntityModel<T>> extends LayerEyesAbstract<T, M> {
	private static final ResourceLocation NORMAL = ResourceUtil.getEntityTexture("yaga_hog_eyes"),
			DIRTY = ResourceUtil.getEntityTexture("yaga_hog_dirt_eyes");
	//private  ResourceLocation EYES = getEyeTexture(this);

    public LayerEyesYagaHog(IEntityRenderer<T, M> render) {
    	super(render);
    }

	@Override
	public RenderType getRenderType(T in) {
		RenderType RENDER_TYPE = RenderType.getEyes(getEyeTexture(in));
		return RENDER_TYPE;
	}

	@Override
	protected ResourceLocation getEyeTexture(T entity) {
		return entity.isDirty() ? DIRTY : NORMAL;
	}
}
