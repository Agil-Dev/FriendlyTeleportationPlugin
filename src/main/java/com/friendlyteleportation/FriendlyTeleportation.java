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
}
