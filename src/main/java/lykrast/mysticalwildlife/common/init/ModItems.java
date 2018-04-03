package lykrast.mysticalwildlife.common.init;

import java.util.ArrayList;
import java.util.List;

import lykrast.mysticalwildlife.common.util.CreativeTabsMysticalWildlife;
import lykrast.mysticalwildlife.core.MysticalWildlife;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class ModItems {
	public static Item vrontausaurusFur, vrontausaurusRaw, vrontausaurusCooked,
		yagaHogRaw, yagaHogCooked;
	private static List<Item> itemList = new ArrayList<>();
	//static List<Item> itemBlockList = new ArrayList<>();
	
	static
	{
		vrontausaurusFur = initItem(new Item(), "vrontausaurus_fur");
		vrontausaurusRaw = initItem(new ItemFood(3, 0.4F, true).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 600, 0), 0.6F), "vrontausaurus_meat_raw");
		vrontausaurusCooked = initItem(new ItemFood(9, 0.9F, true), "vrontausaurus_meat_cooked");
		
		yagaHogRaw = initItem(new ItemFood(2, 0.3F, true), "yaga_hog_meat_raw");
		yagaHogCooked = initItem(new ItemFood(6, 0.7F, true), "yaga_hog_meat_cooked");
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		//Just making sure item blocks get registered before items
		//for (Item i : itemBlockList) event.getRegistry().register(i);
		for (Item i : itemList) event.getRegistry().register(i);
		ModRecipes.initOreDict();
	}
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void registerModels(ModelRegistryEvent evt)
	{
		//for (Item i : itemBlockList) initModel(i);
		for (Item i : itemList) initModel(i);
	}
	
	public static Item initItem(Item item, String name)
	{
		return initItem(item, name, CreativeTabsMysticalWildlife.instance);
	}
	
	public static Item initItem(Item item, String name, CreativeTabs tab)
	{
		item.setRegistryName(name);
		item.setUnlocalizedName(MysticalWildlife.MODID + "." + name);
		if (tab != null) item.setCreativeTab(tab);
		
		itemList.add(item);
		
		return item;
	}

	@SideOnly(Side.CLIENT)
	private static void initModel(Item i)
	{
//		if (i instanceof IItemCustomModel) ((IItemCustomModel)i).initModel();
//		else ModelLoader.setCustomModelResourceLocation(i, 0, new ModelResourceLocation(i.getRegistryName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(i, 0, new ModelResourceLocation(i.getRegistryName(), "inventory"));
	}
}
