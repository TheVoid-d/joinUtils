package thevoid.joinutils.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import thevoid.joinutils.utils.CreateInventory;

public class SetJoinSound implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;
            p.openInventory(CreateInventory.inventory(p));


        }else sender.sendMessage("Петух консольный");
        return true;
    }
}
