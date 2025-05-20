package thevoid.joinutils.Listeners;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import thevoid.joinutils.DataManager;
import thevoid.joinutils.utils.CreateInventory;
import thevoid.joinutils.utils.CreateItem;

import java.util.Arrays;
import java.util.List;


public class CliclListeners implements Listener {

    @EventHandler

    public void onInvClickEvent(InventoryClickEvent e) {

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.BLACK + "Выбор Звука")) {
            e.setCancelled(true);
            if(e.getCurrentItem() == null) return;
            setSound((Player) e.getWhoClicked(), e.getCurrentItem().clone(), e.getClick());
        }else if(e.getView().getTitle().equalsIgnoreCase(ChatColor.BLACK + "Изменить громкость")){
            e.setCancelled(true);
            if(e.getCurrentItem() == null) return;
            ItemStack item = e.getCurrentItem().clone();
            Player p = (Player) e.getWhoClicked();
            ChangeVolume(p, item);
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        if(e.getPlayer().hasPermission("joinutils.setjoinsound")) {
            Player p = e.getPlayer();
            String soundName = DataManager.get().getString("sound." + p.getName() + ".sound", null);
            if(soundName==null) return;
            Sound sound = Sound.valueOf(soundName.toUpperCase());
            double volume = (double)DataManager.get().get("sound." + p.getName() + ".volume", 1.0);

            for (Player player : Bukkit.getOnlinePlayers()) {
                player.playSound(player, sound, (float) volume, 1.0f);
            }
        }
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){
        if(e.getPlayer().hasPermission("joinutils.setjoinsound")) {
            Player p = e.getPlayer();
            String soundName = DataManager.get().getString("sound." + p.getName() + ".sound", null);
            if(soundName==null) return;
            Sound sound = Sound.valueOf(soundName.toUpperCase());
            double volume = (double)DataManager.get().get("sound." + p.getName() + ".volume", 1.0);

            for (Player player : Bukkit.getOnlinePlayers()) {
                player.playSound(player, sound, (float) volume, 1.0f);
            }
        }
    }


    private static void ChangeVolume(Player p, ItemStack item){
        if(!item.hasItemMeta()) return;
        double volume = (double) DataManager.get().get("sound." + p.getName() + ".volume", 1.0);
        List<Material> whiteList = Arrays.asList(Material.LIME_TERRACOTTA,Material.GREEN_TERRACOTTA,Material.PINK_TERRACOTTA,Material.RED_TERRACOTTA, Material.BARRIER, Material.ARROW);
        if(!whiteList.contains(item.getType())) return;
        p.playSound(p, Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
        String name = ChatColor.stripColor(item.getItemMeta().getDisplayName());
        switch (name){
            case "+0.1":
                volume += 0.1;
            break;
            case "+0.5":
                volume += 0.5;
                break;
            case "-0.1":
                volume -= 0.1;
                break;
            case "-0.5":
                volume -= 0.5;
                break;
            case "Назад":
                p.openInventory(CreateInventory.inventory(p));
                return;
            case "Закрыть меню":
                p.closeInventory();
                return;
        }

        if(volume > 1){volume = 1; }else if(volume < 0){volume = 0;}
        String result = String.format("%.1f", volume);
        Inventory inv = p.getOpenInventory().getTopInventory();
        List<String> Lore = Arrays.asList(" ", ChatColor.of("#9a9c9a") + "Значение должно быть между" + ChatColor.of("#9a9c9a") + ChatColor.BOLD + " 0" + ChatColor.of("#9a9c9a") +" и " + ChatColor.of("#9a9c9a") + ChatColor.BOLD + "1");
        inv.setItem(13,CreateItem.item(
                Material.BELL,
                ChatColor.of("#9a9c9a") + "Текущая громкость: " + ChatColor.of("#bf8e80") + result,
                Lore));
        DataManager.get().set("sound." + p.getName() + ".volume", volume);
        DataManager.saveData();
    }

    private static void setSound(Player p, ItemStack item, ClickType clickType) {


        if(item == null) return;

        if(!item.hasItemMeta()) return;
        String itemName = ChatColor.stripColor(item.getItemMeta().getDisplayName());
        List<String> whiteList = Arrays.asList("Крипер","Wololo", "Ваш выбор", "Громкость звука", "Закрыть меню", "Аметист", "Эллей", "Странствующий торговец");

        if(!whiteList.contains(itemName)) return;
        String action;
        if(clickType == ClickType.LEFT){action = "LMB";}
        else if(clickType == ClickType.RIGHT){action = "RMB"; }else if(clickType == ClickType.SHIFT_LEFT){ action = "Shift";}else{return;}
        Inventory inv = p.getOpenInventory().getTopInventory();
        Boolean toclear = false;
        switch (itemName){
            case"Крипер":
                if(action.equalsIgnoreCase("RMB")){
                    p.playSound(p, Sound.ENTITY_CREEPER_PRIMED, 1.0f,1.0f);
                    return;
                }else if(action.equalsIgnoreCase("LMB")) {
                    DataManager.get().set("sound." + p.getName() + ".sound", Sound.ENTITY_CREEPER_PRIMED.toString());
                    DataManager.saveData();
                }
                break;
            case "Wololo":
                if(action.equalsIgnoreCase("RMB")){
                    p.playSound(p, Sound.ENTITY_EVOKER_PREPARE_WOLOLO, 1.0f,1.0f);
                    return;
                }else if(action.equalsIgnoreCase("LMB")) {
                    DataManager.get().set("sound." + p.getName() + ".sound", Sound.ENTITY_EVOKER_PREPARE_WOLOLO.toString());
                    DataManager.saveData();
                    break;
                }
            case "Аметист":
                if(action.equalsIgnoreCase("RMB")){
                    p.playSound(p, Sound.BLOCK_AMETHYST_BLOCK_BREAK, 1.0f,1.0f);
                    return;
                }else if(action.equalsIgnoreCase("LMB")) {
                    DataManager.get().set("sound." + p.getName() + ".sound", Sound.BLOCK_AMETHYST_BLOCK_BREAK.toString());
                    DataManager.saveData();
                    break;
                }
            case "Эллей":
                if(action.equalsIgnoreCase("RMB")){
                    p.playSound(p, Sound.ENTITY_ALLAY_AMBIENT_WITHOUT_ITEM, 1.0f,1.0f);
                    return;
                }else if(action.equalsIgnoreCase("LMB")) {
                    DataManager.get().set("sound." + p.getName() + ".sound", Sound.ENTITY_ALLAY_AMBIENT_WITHOUT_ITEM.toString());
                    DataManager.saveData();
                    break;
                }
            case  "Ваш выбор":
                if(action.equalsIgnoreCase("RMB")){
                    String soundName = DataManager.get().getString("sound." + p.getName() + ".sound", null);
                    if(soundName==null) return;
                    Sound sound = Sound.valueOf(soundName.toUpperCase());
                    double volume = (double)DataManager.get().get("sound." + p.getName() + ".volume", 1.0);
                    p.playSound(p ,sound, (float) volume, 1.0f);
                    return;
                }else if(action.equalsIgnoreCase("Shift")){
                    DataManager.get().set("sound." + p.getName() + ".sound", null);
                    toclear = true;
                }
                break;
            case "Закрыть меню":
                p.closeInventory();
                p.playSound(p, Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
                return;
            case "Громкость звука":
                p.openInventory(CreateInventory.changeVolumeInventor(p));
                p.playSound(p, Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
                return;
            case "Странствующий торговец":
                if(action.equalsIgnoreCase("RMB")){
                    p.playSound(p, Sound.ENTITY_WANDERING_TRADER_AMBIENT, 1.0f,1.0f);
                    return;
                }else if(action.equalsIgnoreCase("LMB")) {
                    DataManager.get().set("sound." + p.getName() + ".sound", Sound.ENTITY_WANDERING_TRADER_AMBIENT.toString());
                    DataManager.saveData();
                    break;
                }
        }

        p.playSound(p, Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
        double vol = (double) DataManager.get().get("sound." + p.getDisplayName() + ".volume",1.0);

        if(toclear) item = CreateItem.item(Material.STRUCTURE_VOID, null, null);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.of("#9a9c9a") + "Ваш выбор");

            meta.setLore(Arrays.asList(" ", ChatColor.of("#9a9c9a") + "Громкость: " + ChatColor.of("#bf8e80") + String.format("%.1f", vol), " ", ChatColor.of("#bf8e80") + "ПКМ " + ChatColor.of("#9a9c9a") + "- проиграть звук",
                    "",
                    ChatColor.of("#bf8e80") + "Шифт + ЛКМ " + ChatColor.of("#9a9c9a") + "- убрать звук",
                    " "));
            item.setItemMeta(meta);

            inv.setItem(49, item);

           DataManager.get().set("sound." + p.getName() + ".item", item);
           DataManager.saveData();

    }
}
