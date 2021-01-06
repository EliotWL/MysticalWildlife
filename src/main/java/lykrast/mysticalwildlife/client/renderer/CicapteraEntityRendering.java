package lykrast.mysticalwildlife.client.renderer;

import lykrast.mysticalwildlife.client.render.RenderCicaptera;
import lykrast.mysticalwildlife.common.entity.EntityCicaptera;

import lykrast.mysticalwildlife.core.MysticalWildlife;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import net.minecraft.entity.EntityClassification;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(MysticalWildlife.MODID)
public class CicapteraEntityRendering
{
    public static void CicapteraInit()
    {
        EntityType<EntityCicaptera.Azure> cA = buildEntity("Cicaptera.Azure", EntityType.Builder.create(EntityCicaptera.Azure::new, EntityClassification.CREATURE));
        EntityType<EntityCicaptera.Verdant> cV = buildEntity("Cicaptera.Verdant", EntityType.Builder.create(EntityCicaptera.Verdant::new, EntityClassification.CREATURE));
        EntityType<EntityCicaptera.Crimson> cC = buildEntity("Cicaptera.Crimson", EntityType.Builder.create(EntityCicaptera.Crimson::new, EntityClassification.CREATURE));
        EntityType<EntityCicaptera.Sandy> cS = buildEntity("Cicaptera.Sandy", EntityType.Builder.create(EntityCicaptera.Sandy::new, EntityClassification.CREATURE));
        EntityType<EntityCicaptera.Wintry> cW = buildEntity("Cicaptera.Wintry", EntityType.Builder.create(EntityCicaptera.Wintry::new, EntityClassification.CREATURE));
        EntityType<EntityCicaptera.Lovely> cL = buildEntity("Cicaptera.Lovely", EntityType.Builder.create(EntityCicaptera.Lovely::new, EntityClassification.CREATURE));

        register(cA, RenderCicaptera.Azure::new);
        register(cV, RenderCicaptera.Verdant::new);
        register(cC, RenderCicaptera.Crimson::new);
        register(cS, RenderCicaptera.Sandy::new);
        register(cW, RenderCicaptera.Wintry::new);
        register(cL, RenderCicaptera.Lovely::new);
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
