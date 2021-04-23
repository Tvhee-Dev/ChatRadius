package me.tvhee.chatradius.util;

import me.tvhee.chatradius.ChatRadiusPlugin;

import org.bukkit.entity.Player;

public class ChatUtil
{
    private static ChatRadiusPlugin plugin = ChatRadiusPlugin.getInstance();

    public static void putInventory(Player player, int slot, String menu)
    {
        HashMaps.clickedInvSlot.put(player, slot);
        HashMaps.inInventory.put(player, menu);
    }
    public static void removeInventory(Player player)
    {
        HashMaps.inInventory.remove(player);
        HashMaps.clickedInvSlot.remove(player);
    }

    public static void startUp()
    {
        plugin.current_chat_radius = plugin.getConfig().getInt("plugin.chatradius");

        if(plugin.getConfig().contains("savespymode"))
        {
            HashMaps.spyMode = plugin.getConfig().getStringList("savespymode");
            plugin.getConfig().set("savespymode", null);
            plugin.saveConfig();
        }

        if(plugin.getConfig().contains("savebroadcastmode"))
        {
            HashMaps.broadcastMode = plugin.getConfig().getStringList("savebroadcastmode");
            plugin.getConfig().set("savebroadcastmode", null);
            plugin.saveConfig();
        }
    }

    public static void shutDown()
    {
        if(plugin.getConfig().getString("storage.spy").equals("true"))
        {
            if(!HashMaps.spyMode.isEmpty())
            {
                plugin.getConfig().set("savespymode", HashMaps.spyMode);
                plugin.saveConfig();
            }
        }

        if(plugin.getConfig().getString("storage.broadcast").equals("true"))
        {
            if(!HashMaps.broadcastMode.isEmpty())
            {
                plugin.getConfig().set("savebroadcastmode", HashMaps.broadcastMode);
                plugin.saveConfig();
            }
        }
    }
}
