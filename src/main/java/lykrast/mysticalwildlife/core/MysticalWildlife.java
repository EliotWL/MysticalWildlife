package lykrast.mysticalwildlife.core;

import lykrast.mysticalwildlife.client.MysticWildlifeClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lykrast.mysticalwildlife.common.init.ModEntities;
import lykrast.mysticalwildlife.common.util.ConfigHandler;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(MysticalWildlife.MODID)
public class MysticalWildlife {
    public static final String MODID = "mysticalwildlife";
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	public MysticalWildlife() {
		//DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> FMLJavaModLoadingContext.get().getModEventBus().addListener(MysticWildlifeClient::init));
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::doClientStuff);
//		bus.addListener(ConfigHandler::configChanged);
		
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigHandler.CONFIG_SPEC);
		ConfigHandler.loadConfig(ConfigHandler.CONFIG_SPEC, FMLPaths.CONFIGDIR.get().resolve(MODID + "-common.toml"));
	}

    private void doClientStuff(final FMLClientSetupEvent event) {
    	ModEntities.initModels();
    }

	public static String find(String name)
	{
		return MODID + ":" + name;
	}

}
