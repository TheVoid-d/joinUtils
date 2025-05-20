package thevoid.joinutils.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import thevoid.joinutils.DataManager;
import thevoid.joinutils.utils.HashMapStorage;

public class SetMessage implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player p) {

            if (args.length == 2) {

                switch (args[0]) {
                    case "join":
                        switch (args[1]) {
                            case "set":
                                p.sendMessage(ChatColor.of("#bfbfbf") + "=============================");
                                p.sendMessage(ChatColor.of("#50665f") + "- " + ChatColor.of("#bfbfbf") + " сообщение не может быть пустым");
                                p.sendMessage(ChatColor.of("#50665f") + "- " + ChatColor.of("#bfbfbf") + " введите" + ChatColor.of("#86dbbf") + " [nick]" + ChatColor.of("#bfbfbf") + ", чтобы установить никнейм (обязательно)");
                                p.sendMessage(ChatColor.of("#50665f") + "- " + ChatColor.of("#bfbfbf") + " для изменения цвета, используйте" + ChatColor.of("#86dbbf") + " HEX" + ChatColor.of("#bfbfbf") + " формат (&#abcdef)");
                                p.sendMessage(ChatColor.of("#bfbfbf") + "=============================");
                                HashMapStorage.setJoinMes.add(p);
                                break;
                            case "enable":
                                p.sendMessage(ChatColor.of("#86dbbf") + "[joinMessage] " + ChatColor.of("#bfbfbf") + "Вы успешно" + ChatColor.of("#86dbbf") + " включили " + ChatColor.of("#bfbfbf") + "сообщение при входе");
                                DataManager.get().set("custom-message." + p.getName() + ".join." + "isActive", true);
                                DataManager.saveData();
                                break;

                            case "disable":
                                p.sendMessage(ChatColor.of("#86dbbf") + "[joinMessage] " + ChatColor.of("#bfbfbf") + "Вы успешно" + ChatColor.of("#86dbbf") + " выключили " + ChatColor.of("#bfbfbf") + "сообщение при входе");
                                DataManager.get().set("custom-message." + p.getName() + ".join." + "isActive", false);
                                DataManager.saveData();
                                break;
                        }
                        break;
                    case "quit":
                        switch (args[1]) {
                            case "set":

                                p.sendMessage(ChatColor.of("#bfbfbf") + "=============================");
                                p.sendMessage(ChatColor.of("#50665f") + "- " + ChatColor.of("#bfbfbf") + "сообщение не может быть пустым");
                                p.sendMessage(ChatColor.of("#50665f") + "- " + ChatColor.of("#bfbfbf") + " введите" + ChatColor.of("#86dbbf") + " [nick]" + ChatColor.of("#bfbfbf") + ", чтобы установить никнейм (обязательно)");
                                p.sendMessage(ChatColor.of("#50665f") + "- " + ChatColor.of("#bfbfbf") + " для изменения цвета, используйте" + ChatColor.of("#86dbbf") + " HEX" + ChatColor.of("#bfbfbf") + " формат (&#abcdef)");
                                p.sendMessage(ChatColor.of("#bfbfbf") + "=============================");
                                HashMapStorage.setQuitMes.add(p);
                                break;
                            case "enable":
                                p.sendMessage(ChatColor.of("#86dbbf") + "[joinUtils] " + ChatColor.of("#bfbfbf") + "Вы успешно" + ChatColor.of("#86dbbf") + " включили " + ChatColor.of("#bfbfbf") + "сообщение при выходе");
                                DataManager.get().set("custom-message." + p.getName() + ".quit." + "isActive", true);
                                DataManager.saveData();
                                break;

                            case "disable":
                                p.sendMessage(ChatColor.of("#86dbbf") + "[joinUtils] " + ChatColor.of("#bfbfbf") + "Вы успешно" + ChatColor.of("#86dbbf") + " выключили " + ChatColor.of("#bfbfbf") + "сообщение при выходе");
                                DataManager.get().set("custom-message." + p.getName() + ".quit." + "isActive", false);
                                DataManager.saveData();
                                break;
                        }
                        break;
                }
            } else if (args.length == 0) {
                p.sendMessage(ChatColor.of("#bfbfbf") + "=============================");
                p.sendMessage(ChatColor.of("#50665f") + "- " + ChatColor.of("#97c7af") + " /setmessage join" + ChatColor.of("#bfbfbf") + " - установить сообщение при входе");
                p.sendMessage(ChatColor.of("#50665f") + "- " + ChatColor.of("#97c7af") + " /setmessage quit" + ChatColor.of("#bfbfbf") + " - установить сообщение при выходе");
                p.sendMessage(ChatColor.of("#50665f") + "- " + ChatColor.of("#97c7af") + " /setmessage back" + ChatColor.of("#bfbfbf") + " - выйти из редактора");
                p.sendMessage(ChatColor.of("#bfbfbf") + "=============================");


            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("back")) {

                    HashMapStorage.setQuitMes.remove(p);
                    HashMapStorage.setJoinMes.remove(p);
                    p.sendMessage(ChatColor.of("#50665f") + "- " + ChatColor.of("#97c7af") + "Вы покинули редактор");
                    return true;
                }
            }

    }

        return true;
    }
}
