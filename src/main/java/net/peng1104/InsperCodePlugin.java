package net.peng1104;

import lombok.Getter;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.peng1104.listener.EntryListener;
import net.peng1104.profiles.ProfileManager;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class InsperCodePlugin extends JavaPlugin {
    
    @Getter
    private static InsperCodePlugin instance;
    
    private ProfileManager profileManager;
    
    private BukkitAudiences adventureManager;
    
    @Override
    public void onLoad() {
        adventureManager = BukkitAudiences.create(instance = this);
    }
    
    @Override
    public void onDisable() {
        //pass
    }
    
    @Override
    public void onEnable() {
        getServer().getPluginManager()
                .registerEvents(profileManager = new ProfileManager(this), this);
        
        getServer().getPluginManager().registerEvents(new EntryListener(this), this);
    }
}