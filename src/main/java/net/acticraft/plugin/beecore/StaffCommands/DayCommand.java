package net.acticraft.plugin.beecore.StaffCommands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DayCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("acs_staff_fly")) {
                p.getWorld().setTime(500);
                p.sendMessage(ChatColor.of("#94A8E2") + "World time has been changed to " + ChatColor.of("#2255DF") + "DAY");
            }
        }else{
            sender.sendMessage(ChatColor.of("#2255DF") + "You do not have permission to execute this command!");
        }
        return false;
    }
}
