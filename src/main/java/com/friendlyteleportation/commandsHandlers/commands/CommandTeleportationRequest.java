package com.friendlyteleportation.commandsHandlers.commands;

import com.friendlyteleportation.FriendlyTeleportation;
import com.friendlyteleportation.commandsHandlers.CommandData;
import com.friendlyteleportation.commandsHandlers.CommandRunner;
import org.bukkit.entity.Player;

import java.time.LocalTime;

public class CommandTeleportationRequest extends CommandRunner {

    public CommandTeleportationRequest(CommandData data) {
        super(data);
    }

    @Override
    public boolean run() {//§
        if(!(data.sender instanceof Player))
            return false;

        Player requester = (Player) data.sender;

        if(data.args.length < 1){
            requester.sendMessage("aim not given.");
            return false;
        }

        Player aim = data.sender.getServer().getPlayer(data.args[0]);

        if (aim == null)
            return false;

        if (aim.getUniqueId() == requester.getUniqueId()){
            requester.sendMessage("You can't tp yourself.");
            return false;
        }

        LocalTime lt = FriendlyTeleportation.teleportationRequestsTime.get(aim.getUniqueId());
        if (lt != null)
            if (LocalTime.now().getSecond() - lt.getSecond() < 15){
                requester.sendMessage("someone already send request... you must wait ~15 sec");
                return false;
            }

        FriendlyTeleportation.teleportationRequests.put(aim.getUniqueId(),requester.getUniqueId());
        FriendlyTeleportation.teleportationRequestsTime.put(aim.getUniqueId(), LocalTime.now());
        aim.sendMessage("tp request from " + requester.getName());

        return true;
    }
}
