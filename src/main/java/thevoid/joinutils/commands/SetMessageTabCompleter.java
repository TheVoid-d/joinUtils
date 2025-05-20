package thevoid.joinutils.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Arrays;
import java.util.List;

public class SetMessageTabCompleter implements TabCompleter {


    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {

        if(args.length == 1){
            return Arrays.asList("quit", "join","back");
        }else if(args.length == 2){return Arrays.asList("disable", "enable", "set"); }

        return List.of();
    }
}
