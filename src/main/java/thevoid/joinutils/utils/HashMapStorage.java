package thevoid.joinutils.utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HashMapStorage {

    public static HashSet<Player> setJoinMes = new HashSet<>();
    public static HashSet<Player> setQuitMes = new HashSet<>();
    public static String colorize(String message) {
        message = processHexColors(message);
        message = ChatColor.translateAlternateColorCodes('&', message);
        return message;
    }

    private static String processHexColors(String message) {
        Pattern hexPattern = Pattern.compile("&#([a-fA-F0-9]{6})");
        Matcher matcher = hexPattern.matcher(message);

        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            String hex = matcher.group(1);
            try {
                ChatColor color = ChatColor.of("#" + hex);
                matcher.appendReplacement(buffer, color.toString());
            } catch (IllegalArgumentException e) {
                matcher.appendReplacement(buffer, "&#" + hex);
            }
        }

        return matcher.appendTail(buffer).toString();
    }
}
