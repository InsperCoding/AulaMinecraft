package net.peng1104.listener;

import net.peng1104.profiles.Profile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class PengListener implements Listener {
    
    private final Map<UUID, Profile> onlineProfiles = new ConcurrentHashMap<>();
    
    @EventHandler
    private void onPlayerJoin(@NotNull PlayerJoinEvent event) {
        Profile profile = new Profile(event.getPlayer().getUniqueId());
        
        onlineProfiles.put(profile.getID(), profile);
        
        profile.sendMessage("&aWelcome to the server, &6" + profile.getName() + "&a!");
    }
    
    @EventHandler
    private void onPlayerQuit(@NotNull PlayerJoinEvent event) {
        Profile profile = onlineProfiles.remove(event.getPlayer().getUniqueId());
        
        if (profile != null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&f" + profile.getName() + " &chas left the server!"));
        }
    }
}