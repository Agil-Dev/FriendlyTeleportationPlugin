package com.friendlyteleportation;

import org.bukkit.plugin.java.JavaPlugin;

public final class FriendlyTeleportation extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Enebled");

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
