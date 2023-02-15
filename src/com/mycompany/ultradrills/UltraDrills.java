package com.mycompany.ultradrills;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author asier
 */
public class UltraDrills extends JavaPlugin {

    public static UltraDrills instance;
    public static final String TAG = ChatColor.WHITE + "[" + ChatColor.BLUE + "Ultra" + ChatColor.DARK_AQUA + "Drills" + ChatColor.WHITE + "]: ";

    @Override
    public void onLoad() {
        sendPluginMessage(ChatColor.GOLD, "El plugin se activado!");
    }

    @Override
    public void onDisable() {
        instance = this;
        sendPluginMessage(ChatColor.RED, "El plugin se ha deshabilitado!");
    }

    @Override
    public void onEnable() {
        instance = this;

        File config = new File(getDataFolder() + File.separator + "config.yml");
        if (!config.exists()) {
            getConfig().options().copyDefaults(true);
            saveConfig();
        }
        
        // getServer().getPluginManager().registerEvents(new OnPlayerJoin(this), this);
        // getServer().getPluginManager().registerEvents(new OnInventoryClick(this), this);
        // getServer().getPluginManager().registerEvents(new OnPlayerChat(this), this);

        this.getCommand("drill").setExecutor(new Comandos(this));

        sendPluginMessage(ChatColor.AQUA, "El plugin se ha habilitado!");
        sendPluginMessage(ChatColor.GOLD, "PLUGIN DESARROLLADO POR BIGSMALL_8");
        sendPluginMessage(ChatColor.DARK_AQUA, "Familia de plugins de UltraMineLands");
    }

    public void sendPluginMessage(ChatColor color, String texto) {
        Bukkit.getConsoleSender().sendMessage(TAG + color + texto);
    }
    
    public static UltraDrills getInstance(){
        return instance;
    }
    
}
