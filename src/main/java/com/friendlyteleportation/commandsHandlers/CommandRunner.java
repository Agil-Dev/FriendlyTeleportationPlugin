package com.friendlyteleportation.commandsHandlers;

public abstract class CommandRunner {

    public CommandRunner(CommandData data){
        this.data = data;
    }

    protected CommandData data;
    public abstract boolean run();
}
