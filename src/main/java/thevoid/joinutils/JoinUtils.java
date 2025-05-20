package thevoid.joinutils;
import org.bukkit.plugin.java.JavaPlugin;
import thevoid.joinutils.Listeners.CliclListeners;
import thevoid.joinutils.Listeners.PlayerChatListener;
import thevoid.joinutils.Listeners.PlayerJoinListener;
import thevoid.joinutils.commands.ReloadConfig;
import thevoid.joinutils.commands.SetJoinSound;
import thevoid.joinutils.commands.SetMessage;
import thevoid.joinutils.commands.SetMessageTabCompleter;

public final class JoinUtils extends JavaPlugin {


    private static JoinUtils plugin;
    @Override
    public void onEnable() {
        //data
        DataManager.setup();


        //plugin getter
        plugin = this;
        saveDefaultConfig();


        //commands
        getCommand("joinutilsreloadconfig").setExecutor(new ReloadConfig());
        getCommand("setsound").setExecutor(new SetJoinSound());
        getCommand("setmessage").setExecutor(new SetMessage());

        getCommand("setmessage").setTabCompleter(new SetMessageTabCompleter());
        //Listeners
        getServer().getPluginManager().registerEvents(new CliclListeners(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerChatListener(), this);
    }
    public static JoinUtils getPlugin() {
        return plugin;
    }
}
