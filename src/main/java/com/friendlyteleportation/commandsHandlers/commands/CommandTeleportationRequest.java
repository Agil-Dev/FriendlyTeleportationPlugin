package com.friendlyteleportation.commandsHandlers.commands;

import com.friendlyteleportation.FriendlyTeleportation;
import com.friendlyteleportation.commandsHandlers.*;
import org.bukkit.entity.Player;

import java.util.Date;

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

        Long lt = FriendlyTeleportation.teleportationRequestsTime.get(aim.getUniqueId());
        if (lt != null)
            if (new Date().getTime() - lt < 15000){
                requester.sendMessage("someone already send request... you must wait ~15 sec");
                return false;
            }

        FriendlyTeleportation.teleportationRequests.put(aim.getUniqueId(),requester.getUniqueId());
        FriendlyTeleportation.teleportationRequestsTime.put(aim.getUniqueId(), new Date().getTime());
        aim.sendMessage("§e>>> Send tp request from §f" + requester.getName());

        return true;
    }
}
