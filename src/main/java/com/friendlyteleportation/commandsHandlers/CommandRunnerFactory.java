package com.friendlyteleportation.commandsHandlers;

import com.friendlyteleportation.commandsHandlers.commands.*;

public class CommandRunnerFactory {

    public static CommandRunner create(CommandData data) throws ClassNotFoundException {

        String command = data.label.toLowerCase();

        switch (command) {
            case "tpr":
                return new CommandTeleportationRequest(data);
            case "tpa":
                return new CommandTeleportationAccept(data);
            default:
                throw new ClassNotFoundException();
        }
    }
}