package net.acticraft.plugin.beecore.Netowk;

import net.acticraft.plugin.beecore.BeeCore;
import org.bukkit.Bukkit;
import org.bukkit.entity.Bee;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PluginMessaging implements PluginMessageListener {

    private BeeCore instance;

    public PluginMessaging(BeeCore plugin) {
        this.instance = plugin;
    }

    public static void sendToBungeeCord(BeeCore instance, Player p, String channel, String sub) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF(channel);
            out.writeUTF(sub);
        } catch (IOException e) {
            e.printStackTrace();
        }
        p.sendPluginMessage(instance, "BungeeCord", b.toByteArray());
    }

    @Override
    public synchronized void onPluginMessageReceived(String channel, Player player, byte[] message) {
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));
        try {
            String subchannel = in.readUTF();
            if(subchannel.equals("open_ban_menu")) {
                String input = in.readUTF();
                String data[] = input.split(":");
                UUID uuid = UUID.fromString(data[0]);
                Player playerR = Bukkit.getPlayer(uuid);
                if(playerR != null) {//player.getUniqueId().toString() + ":" + uuid + ":" + name + ":" + ip
                    String uuidB = data[1];
                    String nameB = data[2];
                    String ipB = "";
                    if(data.length > 3) {
                        ipB = data[3];
                    }
                    instance.OpenBanInventory(playerR, uuidB, nameB, ipB);
                }
                notifyAll();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
