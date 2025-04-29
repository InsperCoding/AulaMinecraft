package net.peng1104;

import lombok.Getter;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.peng1104.commands.CommandGameMode;
import net.peng1104.commands.CommandManager;
import net.peng1104.listener.EntryListener;
import net.peng1104.profiles.ProfileManager;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

@Getter
public class InsperCodePlugin extends JavaPlugin {
    
    @Getter
    private static InsperCodePlugin instance;
    
    private ProfileManager profileManager;
    
    private CommandManager commandManager;
    
    private BukkitAudiences adventureManager;
    
    @Override
    public void onLoad() {
        instance = this;
        
        adventureManager = BukkitAudiences.create(instance);
        profileManager = new ProfileManager();
        commandManager = new CommandManager();
    }
    
    @Override
    public void onDisable() {
        commandManager.disable();
    }
    
    @Override
    public void onEnable() {
        registerListeners();
        createCommands();
    }
    
    private void registerListeners() {
        registerListener(profileManager);
        registerListener(commandManager);
        registerListener(new EntryListener(this));
    }
    
    private void createCommands() {
        new CommandGameMode().register();
    }
    
    public void registerListener(@NotNull Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }
}