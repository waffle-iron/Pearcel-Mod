package com.miningmark48.pearcelmod;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.init.Recipes;
import com.miningmark48.pearcelmod.init.WorldGen;
import com.miningmark48.pearcelmod.proxy.ClientProxy;
import com.miningmark48.pearcelmod.proxy.IProxy;
import com.miningmark48.pearcelmod.reference.Reference;
import com.miningmark48.pearcelmod.utility.LogHelper;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class PearcelMod {
	
	@Mod.Instance(Reference.MOD_ID)
	public static PearcelMod instance;
	
	@SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS, serverSide=Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		
		ModItems.init();
		ModBlocks.init();
		Recipes.init();

        GameRegistry.registerWorldGenerator(new WorldGen(), 0);
		
		LogHelper.info("Pre-Init Complete!");
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		LogHelper.info("Init Complete!");
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event){
		LogHelper.info("Post-Init Complete!");
	}
}
