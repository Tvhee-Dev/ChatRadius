package me.tvhee.chatradius.util;

import me.tvhee.api.bukkit.files.ConfigFile;
import me.tvhee.chatradius.ChatRadiusPlugin;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigFiles
{
    private static ChatRadiusPlugin plugin = ChatRadiusPlugin.getInstance();
    private static ConfigFile messagesConfig = new ConfigFile(plugin, "messages");

    public static FileConfiguration getMessagesConfig()
    {
        return messagesConfig.getConfig();
    }

    public static void saveMessagesConfig()
    {
        messagesConfig.saveConfig();
    }

    public static void saveDefaultMessagesConfig()
    {
        messagesConfig.saveDefaultConfig();
    }

    public static void reloadMessagesConfig()
    {
        messagesConfig.reloadConfig();
    }
}
