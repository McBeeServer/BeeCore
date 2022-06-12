package net.acticraft.plugin.beecore;

import net.acticraft.plugin.beecore.ChatSystem.ChatSystem;
import net.acticraft.plugin.beecore.StaffCommands.*;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class BeeCore extends JavaPlugin implements Listener {

    private static BeeCore instance;

    private final YamlConfiguration conf = new YamlConfiguration();

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "[]=================[" + ChatColor.of("#44eeff") + ChatColor.BOLD + "BeeCore" + ChatColor.GRAY + "]=================[]");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|" + ChatColor.of("#406266") + "       Made by:" + ChatColor.of("#1da7b6") + " PxLib");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|" + ChatColor.of("#406266") + "       Discord:" + ChatColor.of("#1da7b6") + " discord.gg/acticraft");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "[]==================================================[]");

        // Load Commands
        getCommand("gmc").setExecutor(new CreativeCommand());
        getCommand("gms").setExecutor(new SurvivalCommand());
        getCommand("gmsp").setExecutor(new SpectatorCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("day").setExecutor(new DayCommand());
        getCommand("night").setExecutor(new NightCommand());
        getCommand("pl").setExecutor(new PluginsCommand());


        // Load Listeners
        getServer().getPluginManager().registerEvents(new ChatSystem(), this);
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        Bukkit.getPluginManager().registerEvents(this, this);




        // Load yml files
        File co = new File(getDataFolder(), "config.yml");
        if(!co.exists()) saveResource("config.yml", false);


        try{
            this.conf.load(co);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onDisable() {
    }
    public static BeeCore getInstance() {
        return instance;
    }
    public YamlConfiguration getConf() { return this.conf; }

}
