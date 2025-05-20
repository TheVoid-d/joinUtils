package thevoid.joinutils.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CreateItem {

    public static ItemStack item(Material material, String name, List<String> lore){

        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);
        if(lore != null) {
            List<String> newLore = new ArrayList<>();
         for(String line : lore){
            newLore.add(line);
         }
            meta.setLore(newLore);
        }
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack createCustomHead(String id, String name, List<String> lore) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), "CustomHead");
        profile.getProperties().put("textures", new Property("textures", id));

        try {
            Field profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);

            try {
                Class<?> resolvableProfileClass = Class.forName("net.minecraft.world.item.component.ResolvableProfile");
                Object resolvableProfile = resolvableProfileClass.getConstructor(GameProfile.class).newInstance(profile);
                profileField.set(meta, resolvableProfile);
            } catch (Exception e) {
                profileField.set(meta, profile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(lore != null) {
            List<String> newLore = new ArrayList<>();
            for(String line : lore){
                newLore.add(line);
            }
            meta.setLore(newLore);
        }
        meta.setDisplayName(name);
        head.setItemMeta(meta);
        return head;
    }
}
