package lykrast.mysticalwildlife.client.renderer;

import lykrast.mysticalwildlife.client.render.RenderYagaHog;
import lykrast.mysticalwildlife.common.entity.EntityYagaHog;

import lykrast.mysticalwildlife.core.MysticalWildlife;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import net.minecraft.entity.EntityClassification;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(MysticalWildlife.MODID)
public class YagaHogEntityRendering
{
    public static void YagaHogInit()
    {
        EntityType<EntityYagaHog> d = buildEntity("YagaHog", EntityType.Builder.create(EntityYagaHog::new, EntityClassification.CREATURE));
        register(d, RenderYagaHog::new);

    }

    private static <T extends Entity> void register(EntityType<T> entityClass, IRenderFactory<? super T> renderFactory)
    {
        RenderingRegistry.registerEntityRenderingHandler(entityClass, renderFactory);
    }

    private static <T extends Entity> EntityType<T> buildEntity(String key, EntityType.Builder<T> builder)
    {
        return builder.build(MysticalWildlife.find(key));
    }

}
