package net.kochma123.machinemagic;

import net.kochma123.machinemagic.client.CreativeTab;
import net.kochma123.machinemagic.handler.BlockHandler;
import net.kochma123.machinemagic.handler.DimensionHandler;
import net.kochma123.machinemagic.handler.ItemHandler;
import net.kochma123.machinemagic.handler.RecipeHandler;
import net.kochma123.machinemagic.proxy.CommonProxy;
import net.kochma123.machinemagic.world.WorldGen;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main {

	public static final String MODID = "machinemagic";
	public static final String MODNAME = "Machine Magic";
	public static final String VERSION = "0.0.0";
	
	public static final int DimID = 3;

	@Mod.Instance(MODID)
	public static Main INSTANCE;
	@SidedProxy(serverSide = "net.kochma123.machinemagic.proxy.CommonProxy", clientSide = "net.kochma123.machinemagic.proxy.ClientProxy")
	public static CommonProxy proxy;
	public static final CreativeTab creativeTab = new CreativeTab();
	
	public static final Item.ToolMaterial emeraldToolMaterial = EnumHelper.addToolMaterial("EMERALD", 3, 1000, 6, 2, 14);
	public static final Item.ToolMaterial copperToolMaterial = EnumHelper.addToolMaterial("COPPER", 2, 500, 6, 2, 14);
	public static final ItemArmor.ArmorMaterial copperArmorMaterial = EnumHelper.addArmorMaterial("COPPER", MODID + ":copper", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(MODNAME + " is loading!");
		BlockHandler.init();
		DimensionHandler.init();
		ItemHandler.init();
		GameRegistry.registerWorldGenerator(new WorldGen(), 3);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println(MODNAME + " is loading reciepes!");
		RecipeHandler.init();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println(MODNAME + " is interacting!");
	}

}
