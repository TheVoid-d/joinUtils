package thevoid.joinutils.Listeners;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import thevoid.joinutils.DataManager;
import thevoid.joinutils.JoinUtils;
import thevoid.joinutils.utils.HashMapStorage;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if(p.hasPermission("joinutils.setmessage")){
            if(DataManager.get().contains("custom-message." + p.getName() + ".join." + "message")){
                if(DataManager.get().getBoolean("custom-message." + p.getName()+ ".join" + ".isActive")) {
                    String mes = DataManager.get().getString("custom-message." + p.getName() + ".join." + "message");
                    String prefix = JoinUtils.getPlugin().getConfig().getString("donator-join-prefix", "&e[+]");
                    e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', prefix)+ ChatColor.RESET + HashMapStorage.colorize(mes));
                }else{e.setJoinMessage(setJoinMes(p));}
            }else{
            e.setJoinMessage(setJoinMes(p));
            }
        }else{
          e.setJoinMessage(setJoinMes(p));
        }
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();
        if(p.hasPermission("joinutils.setmessage")){

            if(DataManager.get().contains("custom-message." + p.getName() + ".quit" + ".message")){
                if(DataManager.get().getBoolean("custom-message." + p.getName()+ ".quit" + ".isActive")) {
                    String mes = DataManager.get().getString("custom-message." + p.getName() + ".quit." + "message");
                    String prefix = JoinUtils.getPlugin().getConfig().getString("donator-quit-prefix", "&e[-]");
                    e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', prefix)+ ChatColor.RESET + HashMapStorage.colorize(mes));
                } else{e.setQuitMessage(setQuitMes(p));}
            }else{
                e.setQuitMessage(setQuitMes(p));
            }
        }else{
            e.setQuitMessage(setQuitMes(p));}


    }
    private static String setJoinMes(Player p){

        String Mes = JoinUtils.getPlugin().getConfig().getString("default-join-message","&e[-] %player%" );
        String newMes = Mes.replace("%player%", p.getName());

        return ChatColor.translateAlternateColorCodes('&', newMes);
    }
    private static String setQuitMes(Player p){

        String Mes = JoinUtils.getPlugin().getConfig().getString("default-quit-message","&e[-] %player%" );
        String newMes = Mes.replace("%player%", p.getName());

        return  ChatColor.translateAlternateColorCodes('&', newMes);
    }
}
