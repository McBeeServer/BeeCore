package net.acticraft.plugin.beecore.StaffCommands;

import fun.mcbee.api.honeyapi.BungeeSendPlayer.Bungee;
import fun.mcbee.api.honeyapi.HoneyAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class PluginsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (sender.hasPermission("bee.dev")) {
                sender.sendMessage(ChatColor.of("#FFBF00") + "Plugins:");
                for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
                    sender.sendMessage(ChatColor.of("#FAD5A5") + plugin.getName() + " " + ChatColor.GRAY + plugin.getDescription().getVersion());
                }
                return true;
            } else {
                sender.sendMessage(ChatColor.of("#2255DF") + "You don't have permission to use this command!");
                return true;
            }
        }
}
