package me.tvhee.chatradius.listeners;

import me.tvhee.chatradius.ChatRadiusPlugin;
import me.tvhee.chatradius.util.HashMaps;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.List;

public class PlayerQuit implements Listener
{
    private static ChatRadiusPlugin plugin = ChatRadiusPlugin.getInstance();

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e)
    {
        Player player = e.getPlayer();
        String uuid = player.getUniqueId().toString();

        if(plugin.getConfig().getString("storage.spy").equals("true"))
        {
            if(HashMaps.spyMode.contains(uuid))
            {
                final List<String> list = plugin.getConfig().getStringList("savespymode");
                list.add(uuid);
                plugin.getConfig().set("savespymode", list);
                plugin.saveConfig();
            }
        }
        if(plugin.getConfig().getString("storage.broadcast").equals("true"))
        {
            if(HashMaps.broadcastMode.contains(uuid))
            {
                final List<String> list = plugin.getConfig().getStringList("savebroadcastmode");
                list.add(uuid);
                plugin.getConfig().set("savebroadcastmode", list);
                plugin.saveConfig();
            }
        }
    }
}
