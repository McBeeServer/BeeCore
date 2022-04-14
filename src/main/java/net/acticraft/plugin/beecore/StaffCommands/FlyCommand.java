package net.acticraft.plugin.beecore.StaffCommands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("acs_staff_fly")) {
                if(p.isFlying()){
                    p.setAllowFlight(false);
                    p.sendMessage(ChatColor.of("#94A8E2") + "You can no longer " + ChatColor.of("#2255DF") + "FLY");
                }else if(p.isFlying() == false){
                    p.sendMessage(ChatColor.of("#94A8E2") + "You can now " + ChatColor.of("#2255DF") + "FLY");
                    p.setAllowFlight(true);
                }
            }else{
                sender.sendMessage(ChatColor.of("#2255DF") + "You do not have permission to execute this command!");
            }
        }
        return true;}
}
