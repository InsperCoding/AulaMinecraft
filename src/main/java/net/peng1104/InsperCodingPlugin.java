package net.peng1104;

import org.bukkit.plugin.java.JavaPlugin;

public class InsperCodingPlugin extends JavaPlugin {
    
    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("Hello, World!");
    }
    
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("Goodbye, World!");
    }
}