package me.tvhee.chatradius.listeners;

import me.tvhee.api.bukkit.chat.ChatUtils;
import me.tvhee.chatradius.ChatRadiusPlugin;
import me.tvhee.chatradius.updater.Updater;
import me.tvhee.chatradius.util.HashMaps;
import me.tvhee.chatradius.util.Messages;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class PlayerJoin implements Listener
{
    private static ChatRadiusPlugin plugin = ChatRadiusPlugin.getInstance();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e)
    {
        plugin.reloadConfig();

        Player player = e.getPlayer();
        String uuid = player.getUniqueId().toString();

        if(plugin.getConfig().getStringList("savespymode").contains(uuid))
        {
            final List<String> list = plugin.getConfig().getStringList("savespymode");
            list.remove(uuid);
            HashMaps.spyMode.add(uuid);

            if(!list.isEmpty())
            {
                plugin.getConfig().set("savespymode", list);
            }
            else
            {
                plugin.getConfig().set("savespymode", null);
            }
            plugin.saveConfig();
        }

        if(plugin.getConfig().getStringList("savebroadcastmode").contains(uuid))
        {
            final List<String> list = plugin.getConfig().getStringList("savebroadcastmode");
            list.remove(uuid);
            HashMaps.broadcastMode.add(uuid);

            if(!list.isEmpty())
            {
                plugin.getConfig().set("savebroadcastmode", list);
            }
            else
            {
                plugin.getConfig().set("savebroadcastmode", null);
            }
            plugin.saveConfig();
        }

        if(player.hasPermission("chatradius.updates"))
        {
            if(ChatRadiusPlugin.getInstance().getConfig().getBoolean("plugin.update-check"))
            {
                if(Updater.getInstance().updateAvailable())
                {
                    player.sendMessage(ChatUtils.format(Messages.igprefix + Messages.updateAvailable).replaceAll("%version%", String.valueOf(Updater.getInstance().getCurrentVersion())).replaceAll("%new-version%", String.valueOf(Updater.getInstance().getNewestVersion())));
                    player.sendMessage(ChatUtils.format(Messages.igprefix + Messages.updateAvailable2));
                    return;
                }
                else
                {
                    if(ChatRadiusPlugin.getInstance().getConfig().getBoolean("plugin.no-update-available-message-on-join"))
                    {
                        player.sendMessage(ChatUtils.format(Messages.igprefix + Messages.noUpdateAvailable));
                    }
                    return;
                }
            }
            else
            {
                player.sendMessage(ChatUtils.format(Messages.igprefix + Messages.updateCheckDeactivated));
                return;
            }
        }
    }
}
