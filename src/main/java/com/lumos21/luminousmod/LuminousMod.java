package com.lumos21.luminousmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lumos21.luminousmod.init.BlockInit;
import com.lumos21.luminousmod.world.gen.ModOreGen;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("luminousmod")
public class LuminousMod
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "luminousmod";
    public static LuminousMod instance;
    
    
    public LuminousMod() {
        
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	// Register the setup method for modloading
    	//this is just a test for github
        modEventBus.addListener(this::setup);
        
        // Register the doClientStuff method for modloading
        modEventBus.addListener(this::doClientStuff);
        
        instance = this;
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        //LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        ModOreGen.generateOre();
    	LOGGER.info("Generated Nitrate Ores");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
    	
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    public static class LuminousItemGroup extends ItemGroup {
    	public static final LuminousItemGroup instance = new LuminousItemGroup(ItemGroup.GROUPS.length,"Luminous Tab");    	
    	
    	private LuminousItemGroup(int index, String label) {
    		super(index, label);
    	}
    	
    	@Override
    	public ItemStack createIcon()
    	{
    		return new ItemStack(BlockInit.example_block);
    	}
    }
    
   
}
