package thevoid.joinutils.utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import thevoid.joinutils.DataManager;

import java.util.Arrays;
import java.util.List;

public class CreateInventory {

    public static Inventory inventory(Player p){
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "Выбор Звука");
        List<Integer> blackPane = Arrays.asList(0,1,2,3,4,5,6,7,8,9,17,18,26,27,36,45,46,47,48,49,50,51,52,45,35);
        for(int i : blackPane){
            inv.setItem(i, CreateItem.item(Material.BLACK_STAINED_GLASS_PANE,  "§", null));
        }
        List<String> Lore = Arrays.asList(
                " ",
                ChatColor.of("#bf8e80") + "ПКМ " + ChatColor.of("#9a9c9a") + "- проиграть звук",
                "",
                ChatColor.of("#bf8e80") + "ЛКМ " + ChatColor.of("#9a9c9a") + "- установить звук"," ");

        inv.setItem(10, CreateItem.createCustomHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTYzYmYzMTM3YjM3ZmYxNWRjYTkyNGY2ODFkZDc4YTQ5NWQ4YTMwYTg2MTQwZmVjNjZkNGZhZGRlNTc3ZTQzYiJ9fX0=",ChatColor.of("#9a9c9a") + "Крипер", Lore ));
        inv.setItem(12, CreateItem.createCustomHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzQzMzMyMmUyY2NiZDljNTVlZjQxZDk2ZjM4ZGJjNjY2YzgwMzA0NWIyNDM5MWFjOTM5MWRjY2FkN2NkIn19fQ==",ChatColor.of("#9a9c9a") + "Wololo", Lore ));
        inv.setItem(14, CreateItem.createCustomHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzNmYjdjOTJmZTE2NDlkNzZjNGFkOTc5ZWZjZDJjNDYwYjJlOTBiMjMyMGEyMzNlZjg1MTMzZGQ1NmJlZDg2YSJ9fX0=",ChatColor.of("#9a9c9a") + "Аметист", Lore ));
        inv.setItem(16, CreateItem.createCustomHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTUwMjk0YTE3NDczMTBmMTA0MTI0YzYzNzNjYzYzOWI3MTJiYWE1N2I3ZDkyNjI5N2I2NDUxODhiN2JiOWFiOSJ9fX0=",ChatColor.of("#9a9c9a") + "Эллей", Lore ));
        inv.setItem(28, CreateItem.createCustomHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWUwMTFhYWM4MTcyNTlmMmI0OGRhM2U1ZWYyNjYwOTQ3MDM4NjY2MDhiM2Q3ZDE3NTQ0MzJiZjI0OWNkMjIzNCJ9fX0=",ChatColor.of("#9a9c9a") + "Странствующий торговец", Lore ));
        inv.setItem(30, CreateItem.createCustomHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGE5OWIwNWI5YTFkYjRkMjliNWU2NzNkNzdhZTU0YTc3ZWFiNjY4MTg1ODYwMzVjOGEyMDA1YWViODEwNjAyYSJ9fX0=",ChatColor.of("#9a9c9a") + "Скоро...", Lore ));
        inv.setItem(32, CreateItem.createCustomHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGE5OWIwNWI5YTFkYjRkMjliNWU2NzNkNzdhZTU0YTc3ZWFiNjY4MTg1ODYwMzVjOGEyMDA1YWViODEwNjAyYSJ9fX0=",ChatColor.of("#9a9c9a") + "Скоро...", Lore ));
        inv.setItem(34, CreateItem.createCustomHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGE5OWIwNWI5YTFkYjRkMjliNWU2NzNkNzdhZTU0YTc3ZWFiNjY4MTg1ODYwMzVjOGEyMDA1YWViODEwNjAyYSJ9fX0=",ChatColor.of("#9a9c9a") + "Скоро...", Lore ));


        List<String> bookLore = Arrays.asList(" ", ChatColor.of("#9a9c9a") + "Если Вы хотите поставить себе звук, которого нету в данном списке,", ChatColor.of("#9a9c9a") + "то откройте "+ChatColor.BOLD + "тикет " + ChatColor.of("#9a9c9a") + "в канале " + ChatColor.of("#c7737f") + "поддержка.");

        inv.setItem(53, CreateItem.item(Material.LEGACY_BOOK_AND_QUILL, ChatColor.of("#9a9c9a") + "Свой звук", bookLore));

        inv.setItem(48, CreateItem.item(Material.BARRIER, ChatColor.of("#ad283c") + "Закрыть меню", null));

        List<String> bellLore = Arrays.asList(" ",ChatColor.of("#bf8e80") + "ПКМ "+ ChatColor.of("#9a9c9a") + "- изменить громкость", " ");

        inv.setItem(50, CreateItem.item(Material.BELL, ChatColor.of("#9a9c9a") + "Громкость звука", bellLore));

        ItemStack item = DataManager.get().getItemStack("sound." + p.getName() + ".item");
        if(item == null){item = CreateItem.item(Material.STRUCTURE_VOID, ChatColor.of("#9a9c9a") + "Ваш выбор", Arrays.asList(" ", ChatColor.of("#9a9c9a") + "Громкость: "+ ChatColor.of("#bf8e80") +String.format("%.1f",DataManager.get().get("sound." + p.getName() + ".volume ",1.0))));}else{
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.of("#9a9c9a") + "Ваш выбор");
            meta.setLore(Arrays.asList(" ", ChatColor.of("#9a9c9a") + "Громкость: " + ChatColor.of("#bf8e80") +String.format("%.1f", DataManager.get().get("sound." + p.getName()+".volume"),1.0), " ",  ChatColor.of("#bf8e80") + "ПКМ " + ChatColor.of("#9a9c9a") + "- проиграть звук",
                    "",
                    ChatColor.of("#bf8e80") + "Шифт + ЛКМ " + ChatColor.of("#9a9c9a") + "- убрать звук"," "));
            item.setItemMeta(meta);
        }
        inv.setItem(49, item);

            for(int i = 0; i<inv.getSize(); i++){
                if(inv.getItem(i) == null){inv.setItem(i, CreateItem.item(Material.GRAY_STAINED_GLASS_PANE, "§", null));}
            }
        return inv;
    }
    public static Inventory changeVolumeInventor(Player p){
        Inventory inv = Bukkit.createInventory(null, 27, ChatColor.BLACK + "Изменить громкость");

        inv.setItem(16, CreateItem.item(Material.LIME_TERRACOTTA, ChatColor.of("#55e046") + "+0.1", null));
        inv.setItem(15, CreateItem.item(Material.GREEN_TERRACOTTA, ChatColor.of("#40ad34") + "+0.5", null));

        inv.setItem(10, CreateItem.item(Material.PINK_TERRACOTTA, ChatColor.of("#db4655") + "-0.1", null));
        inv.setItem(11, CreateItem.item(Material.RED_TERRACOTTA, ChatColor.of("#a82c38") + "-0.5", null));
        double volume= (double) DataManager.get().get("sound." + p.getDisplayName() + ".volume", 1.0);
        String result = String.format("%.1f", volume);

        List<String> Lore = Arrays.asList(" ", ChatColor.of("#9a9c9a") + "Значение должно быть между" + ChatColor.of("#9a9c9a") + ChatColor.BOLD + " 0" + ChatColor.of("#9a9c9a") +" и " + ChatColor.of("#9a9c9a") + ChatColor.BOLD + "1");

        inv.setItem(13,CreateItem.item(
                Material.BELL,
                ChatColor.of("#9a9c9a") + "Текущая громкость: "+ ChatColor.of("#bf8e80") + result,
                Lore));
        inv.setItem(21, CreateItem.item(Material.ARROW, ChatColor.of("#9a9c9a") + "Назад", null));
        inv.setItem(23, CreateItem.item(Material.BARRIER, ChatColor.of("#ad283c") + "Закрыть меню", null));

        for(int i = 0; i<inv.getSize(); i ++){
            if(inv.getItem(i) == null) inv.setItem(i, CreateItem.item(Material.GRAY_STAINED_GLASS_PANE, "§", null));
        }
        return inv;
    }
}
