package net.acticraft.plugin.beecore.PunishSystem;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class PunishGUI implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if(sender.hasPermission("bee.staff.punish")){


        Bukkit.createInventory(null, 44, "Punish Menu");

            ItemStack ban = new ItemStack(Material.RED_CONCRETE);
            ItemStack mute = new ItemStack(Material.YELLOW_CONCRETE);
            ItemStack kick = new ItemStack(Material.GREEN_CONCRETE);
            ItemStack banip = new ItemStack(Material.PLAYER_HEAD);
            ItemStack banuuid = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
            ItemStack banipuuid = new ItemStack(Material.ORANGE_CONCRETE);
        }


    return false;
}
}
