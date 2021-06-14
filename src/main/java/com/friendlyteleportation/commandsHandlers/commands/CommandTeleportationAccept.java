package com.friendlyteleportation.commandsHandlers.commands;

import com.friendlyteleportation.FriendlyTeleportation;
import com.friendlyteleportation.commandsHandlers.*;
import org.bukkit.entity.Player;

import java.time.LocalTime;
import java.util.UUID;

public class CommandTeleportationAccept extends CommandRunner {
    public CommandTeleportationAccept(CommandData data) {
        super(data);
    }

    @Override
    public boolean run() {
        if(!(data.sender instanceof Player))
            return false;
        Player p = (Player) data.sender;

        UUID requesterUUID = FriendlyTeleportation.teleportationRequests.get(p.getUniqueId());
        if (requesterUUID == null) {
            p.sendMessage("still no requests");
            return false;
        }

        LocalTime lt = FriendlyTeleportation.teleportationRequestsTime.get(p.getUniqueId());
        if (lt != null)
            if (LocalTime.now().getSecond() - lt.getSecond() < 15){
                p.sendMessage("still no requests");
                return false;
            }

        Player requester = p.getServer().getPlayer(requesterUUID);

        requester.teleport(p);

        FriendlyTeleportation.teleportationRequests.remove(p.getUniqueId());
        FriendlyTeleportation.teleportationRequestsTime.remove(p.getUniqueId());

        return true;
    }
}
