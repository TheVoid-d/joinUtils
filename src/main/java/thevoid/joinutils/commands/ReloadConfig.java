package thevoid.joinutils.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import thevoid.joinutils.JoinUtils;

public class ReloadConfig implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        JoinUtils.getPlugin().reloadConfig();
        sender.sendMessage("конфиг перезагружен");

        return true;
    }
}
