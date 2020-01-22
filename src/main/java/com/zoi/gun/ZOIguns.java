package com.zoi.gun;

import java.io.IOException;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import defeatedcrow.flamethrower.common.CommonProxyF;

@Mod(modid = "ZOIguns", name = "ZOIguns", version = "1.7.10_0.0.1", dependencies = "required*after:Forge@[10.13.4.1558,)")

public class ZOIguns {
    @SidedProxy(clientSide = "com.zoi.gun.client.ClientProxyF", serverSide = "com.zoi.gun.common.CommonProxyF")
    public static CommonProxyF proxy;
    @Instance("ZOIguns")
    public static FlameCore instance;
    public static Logger logger = LogManager.getLogger("ZOIguns");
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
        try {
            cfg.load();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cfg.save();
        }
    }
    @EventHandler
    public void init(FMLInitializationEvent event) throws IOException {
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
}
