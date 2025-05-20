package thevoid.joinutils.Listeners;


import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import thevoid.joinutils.DataManager;
import thevoid.joinutils.JoinUtils;
import thevoid.joinutils.utils.HashMapStorage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerChatListener implements Listener {

    @EventHandler
    public void onChat(PlayerChatEvent e){

        Player p = e.getPlayer();
        if(HashMapStorage.setJoinMes.contains(p)){
            e.setCancelled(true);
            String mes = e.getMessage();
            if(!mes.contains("[nick]")){ p.sendMessage(ChatColor.of("#86dbbf") + "[joinMessage] " + ChatColor.of("#bfbfbf") + "Введи [nick] "); return;}
            String newMes  = mes.replace("[nick]", p.getName());
            DataManager.get().set("custom-message." + p.getName() + ".join." + "message", newMes);
            DataManager.get().set("custom-message." + p.getName() + ".join"+".isActive", true);
            DataManager.saveData();
            p.sendMessage(ChatColor.of("#86dbbf") + "[joinMessage] " + ChatColor.of("#bfbfbf") + "Успешно!");
            p.sendMessage(ChatColor.of("#86dbbf") + "[joinMessage] " + ChatColor.of("#bfbfbf") + "Предпоказ:");
            String prefix = JoinUtils.getPlugin().getConfig().getString("donator-join-prefix", "&e[+] ");
            p.sendMessage(ChatColor.of("#86dbbf") + "[joinMessage] " + ChatColor.translateAlternateColorCodes('&', prefix) +ChatColor.RESET+ HashMapStorage.colorize(newMes));
            HashMapStorage.setJoinMes.remove(p);

        }else if(HashMapStorage.setQuitMes.contains(p)) {

            e.setCancelled(true);
            String mes = e.getMessage();
            if(!mes.contains("[nick]")){ p.sendMessage(ChatColor.of("#86dbbf") + "[quitMessage] " + ChatColor.of("#bfbfbf") + "Введи [nick] "); return;}
            String newMes  = mes.replace("[nick]", p.getName());
            DataManager.get().set("custom-message." + p.getName() + ".quit." + "message", newMes);
            DataManager.get().set("custom-message." + p.getName() + ".quit" + ".isActive", true);
            DataManager.saveData();
            p.sendMessage(ChatColor.of("#86dbbf") + "[quitMessage] " + ChatColor.of("#bfbfbf") + "Успешно!");
            p.sendMessage(ChatColor.of("#86dbbf") + "[quitMessage] " + ChatColor.of("#bfbfbf") + "Предпоказ:");
            String prefix = JoinUtils.getPlugin().getConfig().getString("donator-quit-prefix", "&e[-] ");
            p.sendMessage(ChatColor.of("#86dbbf") + "[quitMessage] " + ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.RESET + HashMapStorage.colorize(newMes));
            HashMapStorage.setQuitMes.remove(p);

        }
    }


}
