package io.jonuuh.MODID;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = "MODID",
        version = "1.0.0",
        acceptedMinecraftVersions = "[1.8.9]"
)
public class MODNAME
{
    @Mod.EventHandler
    public void FMLPreInit(FMLPreInitializationEvent event)
    {
    }

    @Mod.EventHandler
    public void FMLInit(FMLInitializationEvent event)
    {
    }

    @Mod.EventHandler
    public void FMLPostInit(FMLPostInitializationEvent event)
    {
    }
}
