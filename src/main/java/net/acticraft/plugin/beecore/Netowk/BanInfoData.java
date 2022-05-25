package net.acticraft.plugin.beecore.Netowk;

import net.acticraft.plugin.beecore.BeeCore;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BanInfoData {

    private String uuid;
    private String name;
    private String ip;
    private String reason = "";

    private int years = 0;
    private int months = 0;
    private int days = 0;
    private int hours = 0;
    private int minutes = 0;
    private int seconds = 0;
    private boolean perma = false;

    private boolean isSettingReason;

    private Inventory inv;

    public BanInfoData(String uuid, String name, String ip) {
        this.uuid = uuid;
        this.name = name;
        this.ip = ip;
    }

    public void OpenInventory(Player player) {

        if(inv == null) {
            inv = Bukkit.createInventory(null, 9 * 3, "Ban Menu");
        }
        // / / / / T / / / /
        // P / Y M D h m s /
        // / R / S / U / C /
        String[] loreData = CreateDataLore();
        inv.setItem(4, CreateItem(Material.CLOCK, ChatColor.of(new Color(255, 0, 47)) + "Ban Data", loreData, 1));

        inv.setItem(9, CreateItem(Material.RED_CONCRETE, ChatColor.of(new Color(140, 32, 32)) + "Permanent: " + perma, new String[] {ChatColor.WHITE + "Click to toggle."}, 1));

        String[] lore = new String[] {ChatColor.WHITE + "Left click to increase.", ChatColor.WHITE + "Right click to decrease."};
        inv.setItem(11, CreateItem(Material.ORANGE_CONCRETE, ChatColor.of(new Color(222, 97, 1)) + "Years: " + years, lore, 1));
        inv.setItem(12, CreateItem(Material.YELLOW_CONCRETE, ChatColor.of(new Color(238, 173, 21)) + "Months: " + months, lore, 1));
        inv.setItem(13, CreateItem(Material.LIME_CONCRETE, ChatColor.of(new Color(92, 166, 24)) + "Days: " + days, lore, 1));
        inv.setItem(14, CreateItem(Material.LIGHT_BLUE_CONCRETE, ChatColor.of(new Color(34, 135, 196)) + "Hours: " + hours, lore, 1));
        inv.setItem(15, CreateItem(Material.PURPLE_CONCRETE, ChatColor.of(new Color(99, 31, 154)) + "Minutes: " + minutes, lore, 1));
        inv.setItem(16, CreateItem(Material.MAGENTA_CONCRETE, ChatColor.of(new Color(167, 47, 157)) + "Seconds: " + seconds, lore, 1));

        inv.setItem(19, CreateItem(Material.RED_STAINED_GLASS_PANE, ChatColor.of(new Color(255, 0, 47)) + "Reset", new String[] {ChatColor.WHITE + "Click to reset."}, 1));
        inv.setItem(21, CreateItem(Material.NAME_TAG, ChatColor.of(new Color(255, 0, 47)) + "Set reason", new String[] {ChatColor.WHITE + "Click to set reason."}, 1));
        inv.setItem(23, CreateItem(Material.LIME_DYE, ChatColor.of(new Color(255, 0, 47)) + "Save", new String[] {ChatColor.WHITE + "Click to save."}, 1));
        inv.setItem(25, CreateItem(Material.BARRIER, ChatColor.of(new Color(255, 0, 47)) + "Cancel", new String[] {ChatColor.WHITE + "Click to cancel."}, 1));

        if(player.getOpenInventory() == null || !player.getOpenInventory().getTitle().equals("Ban Menu")) {
            player.openInventory(inv);
        }

    }

    private String[] CreateDataLore() {
        List<String> lines = new ArrayList<String>();
        String[] reasonWords = this.reason.split(" ");
        int maxLineLength = 40;
        String line = "";
        for(String word : reasonWords) {
            if(word.length() >= maxLineLength) {
                if(!line.isEmpty()) {
                    lines.add(line);
                    line = "";
                }
                lines.add(word);
            } else {
                if(line.length() + word.length() > maxLineLength) {
                    lines.add(line);
                    line = word;
                } else {
                    if(line.length() != 0) {
                        line += " ";
                    }
                    line += word;
                }
            }
        }
        if(!line.isEmpty()) {
            lines.add(line);
        }

        String[] data = new String[5 + lines.size()];
        data[0] = ChatColor.WHITE + "Name: " + name;
        data[1] = ChatColor.WHITE + "UUID: " + uuid;
        data[2] = ChatColor.WHITE + "IP: " + ip;
        data[3] = ChatColor.WHITE + "Time: " + GetDisplayTime();
        data[4] = ChatColor.WHITE + "Reason: ";

        for(int i = 0; i < lines.size(); i++) {
            data[5 + i] = ChatColor.WHITE + lines.get(i);
        }

        return data;
    }

    public boolean IsSettingReason() {
        return this.isSettingReason;
    }

    public void OpenReasonEditor(Player player) {
        this.isSettingReason = true;
        player.closeInventory();
        player.sendMessage(ChatColor.of(new Color(255, 0, 47)) + "Type the reason in chat!");
    }

    public void SetReason(String reason) {
        this.isSettingReason = false;
        this.reason = reason;
    }

    public void Reset() {
        this.years = 0;
        this.months = 0;
        this.days = 0;
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
        this.perma = false;
    }

    public void AddToYears(int num) {
        this.years += num;
        if(this.years < 0) {
            this.years = 0;
        }
    }

    public void AddToMonths(int num) {
        this.months += num;
        if(this.months < 0) {
            this.months = 0;
        }
    }

    public void AddToDays(int num) {
        this.days += num;
        if(this.days < 0) {
            this.days = 0;
        }
    }

    public void AddToHours(int num) {
        this.hours += num;
        if(this.hours < 0) {
            this.hours = 0;
        }
    }

    public void AddToMinutes(int num) {
        this.minutes += num;
        if(this.minutes < 0) {
            this.minutes = 0;
        }
    }

    public void AddToSeconds(int num) {
        this.seconds += num;
        if(this.seconds < 0) {
            this.seconds = 0;
        }
    }

    public void TogglePerma() {
        this.perma = !perma;
    }

    public long GetTime() {
        if(perma) {
            return -1;
        }
        return 31556926000l * years + 2629743830l * months + 86400000 * days + 3600000 * hours + 60000 * minutes + 1000 * seconds;
    }

    public String GetDisplayTime() {
        long time = GetTime();
        if(time < 0) {
            return "permanent";
        }
        if(time == 0) {
            return "not set";
        }
        return GetTextTime(time/1000);
    }

    public void Apply(Player player) {
        PluginMessaging.sendToBungeeCord(BeeCore.getInstance(), player, "ban_information",
                player.getUniqueId().toString() + ":" + uuid + ":" + GetTime() + ":" + reason + ":" + ip);
        this.isSettingReason = false;
        player.closeInventory();
    }

    private ItemStack CreateItem(Material material, String name, String[] lore, int count) {
        ItemStack item = new ItemStack(material, count);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        if(lore != null) {
            meta.setLore(Arrays.asList(lore));
        }
        item.setItemMeta(meta);
        return item;
    }

    private String GetTextTime(Long t) {
        List<Integer> times = new ArrayList<Integer>();
        int years = (int)(t/31556926d);
        times.add(years);
        t = t - (long)(years * 31556926d);
        int days = (int)(t/86400d);
        times.add(days);
        t = t - (long)(days * 86400d);
        int hours = (int)(t/3600d);
        times.add(hours);
        t = t - (long)(hours * 3600d);
        int minutes = (int)(t/60d);
        times.add(minutes);
        int seconds = t.intValue() - (int)(minutes * 60d);
        times.add(seconds);
        String timeDispaly = "";
        String[] suffS = {"year", "day", "hour", "minute", "second"};
        for(int i = 0; i < times.size(); i++) {
            int time = times.get(i);
            if(time != 0) {
                String suffix = suffS[i];
                if(!timeDispaly.isEmpty()) {
                    timeDispaly += ", ";
                }
                if(time == 1) {
                    timeDispaly += time + " " + suffix;
                } else if(time > 1) {
                    timeDispaly += time + " " + suffix + "s";
                }
            }
        }
        if(timeDispaly.isEmpty()) {
            timeDispaly = "0 seconds";
        }
        return timeDispaly;
    }

}
