package me.tvhee.chatradius;

import me.tvhee.chatradius.commands.CRCommand;
import me.tvhee.chatradius.listeners.PlayerChat;
import me.tvhee.chatradius.listeners.PlayerJoin;
import me.tvhee.chatradius.listeners.PlayerQuit;
import me.tvhee.chatradius.util.ChatUtil;
import me.tvhee.chatradius.util.ConfigFiles;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatRadiusPlugin extends JavaPlugin
{
    public int current_chat_radius = 0;

    public static ChatRadiusPlugin instance;

    @Override
    public void onEnable()
    {
        if(Bukkit.getServer().getPluginManager().getPlugin("tvheeAPI") == null)
        {
            getLogger().warning("Error: Could not find API, disabling...");
            Bukkit.getServer().getPluginManager().disablePlugin(this);
            return;
        }

        setInstance(this);

        ConfigFiles.saveDefaultMessagesConfig();

        Bukkit.getServer().getPluginManager().registerEvents(new PlayerChat(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerQuit(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getServer().getPluginCommand("cr").setExecutor(new CRCommand());
        
        saveDefaultConfig();

        ChatUtil.startUp();

        getLogger().info("has been enabled!");
        getLogger().info("made by " + getDescription().getAuthors());
    }

    public static void setInstance(ChatRadiusPlugin instance)
    {
        ChatRadiusPlugin.instance = instance;
    }

    public static ChatRadiusPlugin getInstance()
    {
        return ChatRadiusPlugin.instance;
    }
    
    @Override
    public void onDisable()
    {
        ChatUtil.shutDown();

        getLogger().info("made by " + getDescription().getAuthors());
        getLogger().info("has been disabled!");
    }
}