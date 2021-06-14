package com.friendlyteleportation.commandsHandlers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandData {

    public final CommandSender sender;
    public final Command cmd;
    public final String label;
    public final String[] args;

    public CommandData(CommandSender sender, Command cmd, String label, String[] args) {

        this.sender = sender;
        this.cmd = cmd;
        this.label = label;
        this.args = args;
    }
}