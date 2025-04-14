package net.peng1104;

import lombok.Getter;
import net.peng1104.listener.EntryListener;
import net.peng1104.profiles.ProfileManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

@Getter
public class AulasInsperCode extends JavaPlugin {
    
    private ProfileManager profileManager;
    
    @Override
    public void onLoad() {
        getServer().getPluginManager().registerEvents(profileManager = new ProfileManager(), this);
    }
    
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EntryListener(this), this);
    }
    
    @Override
    public void onDisable() {
        //pass
    }
    
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command,
            @NotNull String label, @NotNull String[] args) {
        
        return false;
    }
}