package lykrast.mysticalwildlife.client.render;

import lykrast.mysticalwildlife.common.util.ResourceUtil;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class LayerEyes<T extends Entity, M extends EntityModel<T>> extends LayerEyesAbstract<T, M> {
	private static final ResourceLocation EYES = ResourceUtil.getEntityTexture("dusk_lurker_eyes");
	private static final RenderType RENDER_TYPE = RenderType.getEyes(EYES);

    public LayerEyes(IEntityRenderer<T, M> render) {
    	super(render);
    }

	@Override
	public RenderType getRenderType(T in) {
		return RENDER_TYPE;
	}

	@Override
	protected ResourceLocation getEyeTexture(T entity) {
		return EYES;
	}
}
