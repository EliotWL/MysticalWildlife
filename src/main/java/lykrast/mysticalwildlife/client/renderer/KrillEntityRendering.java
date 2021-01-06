package lykrast.mysticalwildlife.client.renderer;

import lykrast.mysticalwildlife.client.render.RenderKrill;
import lykrast.mysticalwildlife.common.entity.EntityKrill;

import lykrast.mysticalwildlife.core.MysticalWildlife;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import net.minecraft.entity.EntityClassification;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(MysticalWildlife.MODID)
public class KrillEntityRendering
{
    public static void KrillInit()
    {
        EntityType<EntityKrill> d = buildEntity("Krill", EntityType.Builder.create(EntityKrill::new, EntityClassification.CREATURE));
        register(d, RenderKrill::new);

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
