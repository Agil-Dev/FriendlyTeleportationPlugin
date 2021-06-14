package com.friendlyteleportation.commandsHandlers.commands;

import com.friendlyteleportation.commandsHandlers.CommandData;
import com.friendlyteleportation.commandsHandlers.CommandRunner;

public class CommandTeleportationAccept extends CommandRunner {
    public CommandTeleportationAccept(CommandData data) {
        super(data);
    }

    @Override
    public boolean run() {
        return false;
    }
}
