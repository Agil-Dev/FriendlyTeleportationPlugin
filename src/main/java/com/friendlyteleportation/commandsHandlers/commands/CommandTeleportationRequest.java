package com.friendlyteleportation.commandsHandlers.commands;

import com.friendlyteleportation.commandsHandlers.CommandData;
import com.friendlyteleportation.commandsHandlers.CommandRunner;

public class CommandTeleportationRequest extends CommandRunner {

    public CommandTeleportationRequest(CommandData data) {
        super(data);
    }

    @Override
    public boolean run() {
        return false;
    }
}
