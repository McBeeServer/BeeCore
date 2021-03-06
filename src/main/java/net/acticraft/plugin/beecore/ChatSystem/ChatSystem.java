package net.acticraft.plugin.beecore.ChatSystem;

import me.clip.placeholderapi.PlaceholderAPI;
import net.acticraft.plugin.beecore.BeeCore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatSystem implements Listener {


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerPlaceholderChat(AsyncPlayerChatEvent event){
        String format = ChatColorUtils.toHex(ChatColorUtils.color(PlaceholderAPI.setPlaceholders(event.getPlayer(), BeeCore.getInstance().getConf().getString("format", "%luckperms_prefix%{display_name} %luckperms_suffix% &#1883C4» &#7D878C{message}").replace("{name}", event.getPlayer().getName()).replace("{display_name}" ,event.getPlayer().getDisplayName()))));
        event.setFormat(format.replace("{message}", event.getMessage().replace("%", "‰")));
    }
}
