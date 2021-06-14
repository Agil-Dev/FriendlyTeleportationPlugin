package com.friendlyteleportation.commandsHandlers;

import com.friendlyteleportation.commandsHandlers.commands.*;

public class CommandRunnerFactory {

    public static CommandRunner create(CommandData data) throws ClassNotFoundException {

        String command = data.label.toLowerCase();

        switch (command) {
            // commands will be run here
            default:
                throw new ClassNotFoundException();
        }
    }
}