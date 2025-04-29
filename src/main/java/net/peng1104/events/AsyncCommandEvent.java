package net.peng1104.events;

import lombok.*;
import net.peng1104.commands.Command;
import net.peng1104.profiles.Profile;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class AsyncCommandEvent extends CodeCommandEvent {
    
    @Getter
    private static final HandlerList HANDLERS = new HandlerList();
    
    public AsyncCommandEvent(@NotNull Profile sender, @NotNull Command command, boolean async) {
        super(sender, command, async);
    }
    
    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }
}