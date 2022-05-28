package net.acticraft.plugin.beecore.StaffCommands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SurvivalCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("bee.staff.admin")) {
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(ChatColor.of("#FFBF00") + "You changed your gamemode to: " + ChatColor.of("#F28C28") + "Survival");
            }else{
                sender.sendMessage(ChatColor.of("#2255dF") + "You do not have permission to execute this command!");
            }
        }
        return true;}

}
