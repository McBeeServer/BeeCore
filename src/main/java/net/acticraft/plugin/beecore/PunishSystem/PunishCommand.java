package net.acticraft.plugin.beecore.PunishSystem;

import net.acticraft.plugin.api.beeapi.bungeesendplayer.Bungee;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class PunishCommand implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("acti.staff.punish")) {


                Inventory GameMenu = Bukkit.createInventory(null, 27, ChatColor.of("#FFBF00") + "Punishement Menu");

                // SetItems
                ItemStack user = new ItemStack(Material.PLAYER_HEAD, 1);
                ItemStack punishhistory = new ItemStack(Material.BOOK, 1);
                ItemStack ban = new ItemStack(Material.RED_CONCRETE, 1);
                ItemStack mute = new ItemStack(Material.ORANGE_CONCRETE, 1);
                ItemStack warn = new ItemStack(Material.YELLOW_CONCRETE, 1);





                ItemMeta user_meta = user.getItemMeta();
                user_meta.setDisplayName(ChatColor.of("#F1981E") + ""+ChatColor.BOLD + "MAIN LOBBY");
                user.setItemMeta(user_meta);

                ItemMeta punishhistory_meta = punishhistory.getItemMeta();
                punishhistory_meta.setDisplayName(ChatColor.of("#F1981E") +""+ChatColor.BOLD + "PUNISH HISTORY");
                punishhistory.setItemMeta(punishhistory_meta);

                ItemMeta ban_meta = ban.getItemMeta();
                ban_meta.setDisplayName(ChatColor.of("#F1981E") +""+ChatColor.BOLD + "SURVIVAL");
                ban.setItemMeta(ban_meta);

                ItemMeta mute_meta = mute.getItemMeta();
                mute_meta.setDisplayName(ChatColor.of("#F1981E") +""+ChatColor.BOLD + "SKYBLOCK");
                mute.setItemMeta(mute_meta);

                ItemMeta warn_meta = warn.getItemMeta();
                warn_meta.setDisplayName(ChatColor.of("#F1981E") +""+ChatColor.BOLD + "EGGWARS");
                warn.setItemMeta(warn_meta);



                //Design
                GameMenu.setItem(4, user);
                GameMenu.setItem(18, punishhistory);
                GameMenu.setItem(11, ban);
                GameMenu.setItem(13, mute);
                GameMenu.setItem(15, warn);




                player.openInventory(GameMenu);


            }else{
                player.sendMessage(ChatColor.of("#F23700") + "You do not have required permissions to use this command!");
            }}
        return false;}


    @EventHandler
    public void GamemodeSelector(InventoryClickEvent event) {
        if(event.getView().getTitle().equalsIgnoreCase(ChatColor.of("#FFBF00") + "Punishement Menu") && event.getCurrentItem() != null) {

            if (event.getCurrentItem().getType() == Material.BOOKSHELF) {
                if (event.getClick().equals(ClickType.RIGHT) || event.getClick().equals(ClickType.LEFT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    Bungee.sendPlayerToServer((Player) event.getWhoClicked(), "lobby");
                } else {
                    event.setCancelled(true);
                }
            }

            if (event.getCurrentItem().getType() == Material.WOODEN_SWORD) {
                if (event.getClick().equals(ClickType.RIGHT) || event.getClick().equals(ClickType.LEFT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    Bungee.sendPlayerToServer((Player) event.getWhoClicked(), "kitpvp");
                } else {
                    event.setCancelled(true);
                }
            }

            if (event.getCurrentItem().getType() == Material.MOSSY_COBBLESTONE) {
                if (event.getClick().equals(ClickType.RIGHT) || event.getClick().equals(ClickType.LEFT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    Bungee.sendPlayerToServer((Player) event.getWhoClicked(), "survival");
                    event.getWhoClicked().closeInventory();
                } else {
                    event.setCancelled(true);
                }
            }

            if (event.getCurrentItem().getType() == Material.GRASS_BLOCK) {
                if (event.getClick().equals(ClickType.RIGHT) || event.getClick().equals(ClickType.LEFT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    Bungee.sendPlayerToServer((Player) event.getWhoClicked(), "skyblock");
                    event.getWhoClicked().closeInventory();
                } else {
                    event.setCancelled(true);
                }
            }

            if (event.getCurrentItem().getType() == Material.DRAGON_EGG) {
                if (event.getClick().equals(ClickType.RIGHT) || event.getClick().equals(ClickType.LEFT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    Bungee.sendPlayerToServer((Player) event.getWhoClicked(), "eggwars");
                    event.getWhoClicked().closeInventory();
                } else {
                    event.setCancelled(true);
                }
            }

            if (event.getCurrentItem().getType() == Material.ENDER_EYE) {
                if (event.getClick().equals(ClickType.RIGHT) || event.getClick().equals(ClickType.LEFT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    Bungee.sendPlayerToServer((Player) event.getWhoClicked(), "skywars");
                    event.getWhoClicked().closeInventory();
                } else {
                    event.setCancelled(true);
                }
            }

            if (event.getCurrentItem().getType() == Material.BOW) {
                if (event.getClick().equals(ClickType.RIGHT) || event.getClick().equals(ClickType.LEFT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    Bungee.sendPlayerToServer((Player) event.getWhoClicked(), "murdermystery");
                    event.getWhoClicked().closeInventory();
                } else {
                    event.setCancelled(true);
                }
            }

            if (event.getCurrentItem().getType() == Material.YELLOW_CONCRETE) {
                if (event.getClick().equals(ClickType.RIGHT) || event.getClick().equals(ClickType.LEFT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    Bungee.sendPlayerToServer((Player) event.getWhoClicked(), "rplace");
                    event.getWhoClicked().closeInventory();
                } else {
                    event.setCancelled(true);
                }
            }

            if (event.getCurrentItem().getType() == Material.ANVIL) {
                if (event.getClick().equals(ClickType.RIGHT) || event.getClick().equals(ClickType.LEFT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    Bungee.sendPlayerToServer((Player) event.getWhoClicked(), "prototype");
                    event.getWhoClicked().closeInventory();
                } else {
                    event.setCancelled(true);
                }
            }

            if (event.getCurrentItem().getType() == Material.BRICKS) {
                if (event.getClick().equals(ClickType.RIGHT) || event.getClick().equals(ClickType.LEFT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    Bungee.sendPlayerToServer((Player) event.getWhoClicked(), "creative");
                    event.getWhoClicked().closeInventory();
                } else {
                    event.setCancelled(true);
                }
            }

            if (event.getCurrentItem().getType() == Material.CRAFTING_TABLE) {
                if (event.getClick().equals(ClickType.RIGHT) || event.getClick().equals(ClickType.LEFT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    Bungee.sendPlayerToServer((Player) event.getWhoClicked(), "buildbattle");
                    event.getWhoClicked().closeInventory();
                } else {
                    event.setCancelled(true);
                }
            }

            if (event.getCurrentItem().getType() == Material.JUKEBOX) {
                if (event.getClick().equals(ClickType.RIGHT) || event.getClick().equals(ClickType.LEFT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    Bungee.sendPlayerToServer((Player) event.getWhoClicked(), "classic");
                    event.getWhoClicked().closeInventory();
                } else {
                    event.setCancelled(true);
                }
            }

            if (event.getCurrentItem().getType() == Material.SOUL_SOIL) {
                if (event.getClick().equals(ClickType.RIGHT) || event.getClick().equals(ClickType.LEFT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    Bungee.sendPlayerToServer((Player) event.getWhoClicked(), "horror");
                    event.getWhoClicked().closeInventory();
                } else {
                    event.setCancelled(true);
                }
            }

            if (event.getCurrentItem().getType() == Material.RAW_GOLD_BLOCK) {
                if (event.getClick().equals(ClickType.RIGHT) || event.getClick().equals(ClickType.LEFT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    Bungee.sendPlayerToServer((Player) event.getWhoClicked(), "rpg");
                    event.getWhoClicked().closeInventory();
                } else {
                    event.setCancelled(true);
                }
            }

            if (event.getCurrentItem().getType() == Material.IRON_BARS) {
                if (event.getClick().equals(ClickType.RIGHT) || event.getClick().equals(ClickType.LEFT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    Bungee.sendPlayerToServer((Player) event.getWhoClicked(), "prison");
                    event.getWhoClicked().closeInventory();
                } else {
                    event.setCancelled(true);
                }
            }

            if (event.getCurrentItem().getType() == Material.IRON_SWORD) {
                if (event.getClick().equals(ClickType.RIGHT) || event.getClick().equals(ClickType.LEFT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    Bungee.sendPlayerToServer((Player) event.getWhoClicked(), "factions");
                    event.getWhoClicked().closeInventory();
                } else {
                    event.setCancelled(true);
                }
            }
            if (event.getCurrentItem().getType() == Material.BLAZE_POWDER) {
                if (event.getClick().equals(ClickType.RIGHT) || event.getClick().equals(ClickType.LEFT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    Bungee.sendPlayerToServer((Player) event.getWhoClicked(), "champions");
                    event.getWhoClicked().closeInventory();
                } else {
                    event.setCancelled(true);
                }
            }
            if (event.getCurrentItem().getType() == Material.BEACON) {
                if (event.getClick().equals(ClickType.RIGHT) || event.getClick().equals(ClickType.LEFT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    Bungee.sendPlayerToServer((Player) event.getWhoClicked(), "towny");
                    event.getWhoClicked().closeInventory();
                } else {
                    event.setCancelled(true);
                }
            }

            if (event.getCurrentItem().getType() == Material.SPONGE) {
                if (event.getClick().equals(ClickType.RIGHT) || event.getClick().equals(ClickType.LEFT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    Bungee.sendPlayerToServer((Player) event.getWhoClicked(), "lucky");
                    event.getWhoClicked().closeInventory();
                } else {
                    event.setCancelled(true);
                }}
            event.setCancelled(true);
        }

    }

}
