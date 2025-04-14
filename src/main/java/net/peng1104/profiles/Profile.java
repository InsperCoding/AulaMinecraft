package net.peng1104.profiles;

import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class Profile {
    
    private final UUID uuid;
    
    private int coins = 0;
    
    public Profile(@NotNull UUID uuid) {
        this.uuid = uuid;
    }
    
    @NotNull
    public UUID getID() {
        return uuid;
    }
    
    @Nullable
    public Player getPlayer() {
        return org.bukkit.Bukkit.getPlayer(getID());
    }
    
    @Nullable
    public OfflinePlayer getOfflinePlayer() {
        return org.bukkit.Bukkit.getOfflinePlayer(getID());
    }
    
    @NotNull
    public String getName() {
        OfflinePlayer player = getOfflinePlayer();
        
        if (player != null) {
            String playerName = player.getName();
            
            if (playerName != null) {
                return playerName;
            }
        }
        return "Unknown";
    }
    
    public void sendMessage(@NotNull String message) {
        Player player = getPlayer();
        
        if (player != null) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
        }
    }
    
    public void sendTitle(@NotNull String title) {
        sendTitle(title, "");
    }
    
    public void sendTitle(@NotNull String title, @NotNull String subtitle) {
        sendTitle(title, subtitle, 10, 70, 20);
    }
    
    public void sendTitle(@NotNull String title, @NotNull String subtitle, int fadeIn, int stay, int fadeOut) {
        Player player = getPlayer();
        
        if (player == null) {
            return;
        }
        player.sendTitle(
                ChatColor.translateAlternateColorCodes('&', title),
                ChatColor.translateAlternateColorCodes('&', subtitle),
                fadeIn,
                stay,
                fadeOut
        );
    }
}