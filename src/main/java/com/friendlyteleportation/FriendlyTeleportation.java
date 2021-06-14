package com.friendlyteleportation;

import com.friendlyteleportation.commandsHandlers.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.UUID;

public final class FriendlyTeleportation extends JavaPlugin {

    public static JavaPlugin plugin;
    public static HashMap<UUID, UUID> teleportationRequests = new HashMap<>();
    public static HashMap<UUID, LocalTime> teleportationRequestsTime = new HashMap<>();

    @Override
    public void onEnable() {
        getLogger().info("Enebled");
        plugin = this;
    }

    @Override
    public void onDisable() {
        getLogger().info("Disebled");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        CommandData data = new CommandData(sender, cmd, label, args);
        try {
            return CommandRunnerFactory.create(data).run();
        } catch (ClassNotFoundException ex) {
            return false;
        }
    }
}
