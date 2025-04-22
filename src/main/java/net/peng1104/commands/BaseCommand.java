package net.peng1104.commands;

import lombok.Getter;
import net.kyori.adventure.text.Component;
import net.peng1104.InsperCodePlugin;
import net.peng1104.profiles.Profile;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Getter
public abstract class BaseCommand extends Command {
    
    protected final InsperCodePlugin plugin;
    
    private final String permission;
    
    protected BaseCommand(@NotNull InsperCodePlugin plugin, @NotNull String name,
            String... aliases) {
        super(name, "", "/", Arrays.asList(aliases));
        
        this.plugin = plugin;
        
        permission = "code.command." + name.toLowerCase().replace(" ", "_");
    }
    
    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String label,
            @NotNull String[] args) {
        
        Profile profile = InsperCodePlugin.getInstance().getProfileManager().getProfile(sender);
        
        if (!profile.hasPermission(permission)) {
            profile.sendMessage(
                    Component.text("&cYou do not have permission to use this command."));
            return false;
        }
        execute(InsperCodePlugin.getInstance().getProfileManager().getProfile(sender), label, args);
        return false;
    }
    
    @Override
    public @NotNull List<String> tabComplete(@NotNull CommandSender sender, @NotNull String label,
            @NotNull String[] args) {
        
        Profile profile = InsperCodePlugin.getInstance().getProfileManager().getProfile(sender);
        
        if (!profile.hasPermission(permission)) {
            return List.of();
        }
        Collection<String> suggestions = tabComplete(profile, label, args);
        
        return suggestions == null ? List.of() : List.copyOf(suggestions);
    }
    
    @NotNull
    public String getPermissionOthers() {
        return permission + ".others";
    }
    
    protected Profile getProfile(@NotNull String profileName) {
        return plugin.getProfileManager().getProfile(profileName);
    }
    
    public abstract void execute(@NotNull Profile sender, @NotNull String label,
            @NotNull String[] args);
    
    @Nullable
    public abstract Collection<String> tabComplete(@NotNull Profile sender, @NotNull String label,
            @NotNull String[] args);
}
