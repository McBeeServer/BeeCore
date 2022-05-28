package net.acticraft.plugin.beecore.StaffCommands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreativeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("bee.staff.admin")) {
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(ChatColor.of("#FFBF00") + "You changed your gamemode to: " + ChatColor.of("#F28C28") + "Creative");
            }else{
                sender.sendMessage(ChatColor.of("#2255DF") + "You do not have permission to execute this command!");
            }
        }
        return true;}

}
