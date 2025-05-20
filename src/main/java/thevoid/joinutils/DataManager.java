package thevoid.joinutils;


import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class DataManager {

    private static File file;
    private static FileConfiguration customFile;


    // Создание или находжение файла
    public static void setup(){

       file = new File(Bukkit.getServer().getPluginManager().getPlugin("joinUtils").getDataFolder(), "data.yml");

       if(!file.exists()){
        try {
            file.createNewFile();
        }catch(IOException e) {
            System.out.println("Error! code: 1");}
            return;
        }
        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get(){
        return customFile;
    }

    public static void saveData(){
        try {
            customFile.save(file);
        }catch(IOException e){
            System.out.println("Error! Code: 2");}
    }

    public static void reload(){
    customFile = YamlConfiguration.loadConfiguration(file);
    }
    public static File getFile(){
        return file;
    }
}
