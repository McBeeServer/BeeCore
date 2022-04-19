package net.acticraft.plugin.beecore.StaffCommands;

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
            if (sender.hasPermission("acs_staff_plugins")) {
                sender.sendMessage(ChatColor.of("#2255DF") + "Plugins:");
                for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
                    sender.sendMessage(ChatColor.of("#94A8E2") + plugin.getName() + " " + ChatColor.GRAY + plugin.getDescription().getVersion());
                }
                return true;
            } else {
                sender.sendMessage(ChatColor.of("#2255DF") + "You don't have permission to use this command!");
                return true;
            }
        }
}
