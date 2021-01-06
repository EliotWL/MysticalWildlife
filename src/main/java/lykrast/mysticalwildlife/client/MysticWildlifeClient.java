package lykrast.mysticalwildlife.client;

import lykrast.mysticalwildlife.client.renderer.CicapteraEntityRendering;
import lykrast.mysticalwildlife.client.renderer.DuskLurkerEntityRendering;
import lykrast.mysticalwildlife.client.renderer.KrillEntityRendering;
import lykrast.mysticalwildlife.client.renderer.PlumperEntityRendering;
import lykrast.mysticalwildlife.client.renderer.VrontausaurusEntityRendering;
import lykrast.mysticalwildlife.client.renderer.YagaHogEntityRendering;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class MysticWildlifeClient
{
    public static void init(FMLClientSetupEvent event)
    {
        CicapteraEntityRendering.CicapteraInit();
        DuskLurkerEntityRendering.DuskLurkerInit();
        KrillEntityRendering.KrillInit();
        PlumperEntityRendering.PlumperInit();
        VrontausaurusEntityRendering.VrontausaurusInit();
        YagaHogEntityRendering.YagaHogInit();
    }

}
