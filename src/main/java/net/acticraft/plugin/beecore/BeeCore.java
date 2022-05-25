package net.acticraft.plugin.beecore;

import net.acticraft.plugin.beecore.ChatSystem.ChatSystem;
import net.acticraft.plugin.beecore.Netowk.BanInfoData;
import net.acticraft.plugin.beecore.Netowk.PluginMessaging;
import net.acticraft.plugin.beecore.StaffCommands.*;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
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

    Map<UUID, BanInfoData> listBanInfoData = new HashMap<UUID, BanInfoData>();
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
        Bukkit.getMessenger().registerIncomingPluginChannel(this, "nm:channel", new PluginMessaging(this));
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

    public void OpenBanInventory(Player player, String uuid, String name, String ip) {
        BanInfoData data = new BanInfoData(uuid, name, ip);
        listBanInfoData.put(player.getUniqueId(), data);
        data.OpenInventory(player);
    }

    @EventHandler
    public void OnInventoryCloseEvent(InventoryCloseEvent e) {
        BanInfoData bi = listBanInfoData.get(e.getPlayer().getUniqueId());
        if(bi != null && !bi.IsSettingReason()) {
            listBanInfoData.remove(e.getPlayer().getUniqueId());
        }
    }

    @EventHandler
    public void OnPlayerQuitEvent(PlayerQuitEvent e) {
        listBanInfoData.remove(e.getPlayer().getUniqueId());
    }

    @EventHandler
    public void OnInventoryClickEvent(InventoryClickEvent e) {
        if(e.getClickedInventory() != null && e.getClickedInventory().getType().equals(InventoryType.CHEST)) {
            if(listBanInfoData.containsKey(e.getWhoClicked().getUniqueId())) {
                e.setCancelled(true);
                int slot = e.getSlot();
                int add = (e.isLeftClick()) ? 1 : -1;
                if(slot == 9) {
                    BanInfoData bi = listBanInfoData.get(e.getWhoClicked().getUniqueId());
                    bi.TogglePerma();
                    bi.OpenInventory((Player) e.getWhoClicked());
                } else if(slot == 11) {
                    BanInfoData bi = listBanInfoData.get(e.getWhoClicked().getUniqueId());
                    bi.AddToYears(add);
                    bi.OpenInventory((Player) e.getWhoClicked());
                } else if(slot == 12) {
                    BanInfoData bi = listBanInfoData.get(e.getWhoClicked().getUniqueId());
                    bi.AddToMonths(add);
                    bi.OpenInventory((Player) e.getWhoClicked());
                } else if(slot == 13) {
                    BanInfoData bi = listBanInfoData.get(e.getWhoClicked().getUniqueId());
                    bi.AddToDays(add);
                    bi.OpenInventory((Player) e.getWhoClicked());
                } else if(slot == 14) {
                    BanInfoData bi = listBanInfoData.get(e.getWhoClicked().getUniqueId());
                    bi.AddToHours(add);
                    bi.OpenInventory((Player) e.getWhoClicked());
                } else if(slot == 15) {
                    BanInfoData bi = listBanInfoData.get(e.getWhoClicked().getUniqueId());
                    bi.AddToMinutes(add);
                    bi.OpenInventory((Player) e.getWhoClicked());
                } else if(slot == 16) {
                    BanInfoData bi = listBanInfoData.get(e.getWhoClicked().getUniqueId());
                    bi.AddToSeconds(add);
                    bi.OpenInventory((Player) e.getWhoClicked());
                } else if(slot == 19) {
                    BanInfoData bi = listBanInfoData.get(e.getWhoClicked().getUniqueId());
                    bi.Reset();
                    bi.OpenInventory((Player) e.getWhoClicked());
                } else if(slot == 21) {
                    BanInfoData bi = listBanInfoData.get(e.getWhoClicked().getUniqueId());
                    bi.OpenReasonEditor((Player) e.getWhoClicked());
                } else if(slot == 23) {
                    BanInfoData bi = listBanInfoData.get(e.getWhoClicked().getUniqueId());
                    bi.Apply((Player) e.getWhoClicked());
                } else if(slot == 25) {
                    e.getWhoClicked().closeInventory();
                }
            }
        }
    }

    @EventHandler
    public void OnAsyncPlayerChatEvent(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        BanInfoData bi = listBanInfoData.get(player.getUniqueId());
        if(bi != null) {
            if(bi.IsSettingReason()) {
                bi.SetReason(e.getMessage());
                Bukkit.getScheduler().runTask(this, new Runnable() {
                    @Override
                    public void run() {
                        bi.OpenInventory(player);
                    }
                });
                e.setCancelled(true);
            } else {
                listBanInfoData.remove(player.getUniqueId());
            }
        }
    }
}
