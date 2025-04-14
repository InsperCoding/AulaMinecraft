package net.peng1104.listener;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.peng1104.AulasInsperCode;
import net.peng1104.profiles.Profile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.jetbrains.annotations.NotNull;

@RequiredArgsConstructor
public class EntryListener implements Listener {
    
    @NonNull
    @NotNull
    private final AulasInsperCode pl;
    
    @EventHandler(priority = EventPriority.LOWEST)
    private void onEntry(@NotNull PlayerJoinEvent event) {
        event.setJoinMessage(null);
        
        Profile profile = pl.getProfileManager().getProfile(event.getPlayer().getUniqueId());
        
        if (profile.hasPermission("insper.code.mensagem.entrada")) {
            profile.sendMessage("&c&lSeja bem-vindo(a) ao Insper Code!");
        }
        else {
            profile.sendMessage("&c&lQue pena, você não pode ver a mensagem de entrada.");
        }
    }
    
    @EventHandler
    private void onPlayerDie(PlayerDeathEvent event) {
    
    }
    
    @EventHandler
    private void onPlayerMove(@NotNull PlayerMoveEvent event) {
        Profile profile = pl.getProfileManager().getProfile(event.getPlayer().getUniqueId());
        
        if (profile.hasPermission("insper.code.congelar")) {
            event.getPlayer().sendMessage("Você não pode se mover!");
            event.setCancelled(true); // Congela o jogador no lugar
        }
    }
}