package net.peng1104;

import net.peng1104.listener.PengListener;
import org.bukkit.plugin.java.JavaPlugin;

public class AulasInsperCode extends JavaPlugin {
    
    @Override
    public void onLoad() {
        getServer().getConsoleSender().sendMessage("Loading InsperCodingPlugin...");
    }
    
    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("Plugin is now enabled!");
        
        getServer().getPluginManager().registerEvents(new PengListener(), this);
    }
    
    @Override
    public void onDisable() {
       getServer().getConsoleSender().sendMessage("Plugin is now disabled!");
    }
}