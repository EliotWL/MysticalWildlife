package lykrast.mysticalwildlife.client.renderer;

import lykrast.mysticalwildlife.client.render.RenderDuskLurker;
import lykrast.mysticalwildlife.common.entity.EntityDuskLurker;

import lykrast.mysticalwildlife.core.MysticalWildlife;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import net.minecraft.entity.EntityClassification;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(MysticalWildlife.MODID)
public class DuskLurkerEntityRendering
{
    public static void DuskLurkerInit()
    {
        EntityType<EntityDuskLurker> d = buildEntity("DuskLurker", EntityType.Builder.create(EntityDuskLurker::new, EntityClassification.CREATURE));
        register(d, RenderDuskLurker::new);

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
