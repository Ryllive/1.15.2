package com.bluewater737.firstmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bluewater737.firstmod.init.Iteminit;
import com.bluewater737.firstmod.world.gen.FirstOreGen;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("firstmod")
@Mod.EventBusSubscriber(modid = FirstMod.MOD_ID, bus = Bus.MOD)
public class FirstMod
{
        private static final Logger LOGGER = LogManager.getLogger();
        public static final String MOD_ID = "firstmod";
        public static FirstMod instance;

    public FirstMod() 
    {
           FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
           FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
           
           instance = this;
              MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        
    }

    private void doClientStuff(final FMLClientSetupEvent event) 
    {
    	
    } 
    
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event)
    {
    	
    }
    
    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event)
    {
    	FirstOreGen.generateOre();
    }
   
    public static class TutorialItemGroup extends ItemGroup
    {
    	public static final TutorialItemGroup instance = new TutorialItemGroup(ItemGroup.GROUPS.length, "exampletab");
    			
    	private TutorialItemGroup(int index, String label)
    	{
    		super(index, label);
    	}
    	
    	@Override 
    	public ItemStack createIcon()
    	{
    		return new ItemStack(Iteminit.example_item);
    	}
    }
}

