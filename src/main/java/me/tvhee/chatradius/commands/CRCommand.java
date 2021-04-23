package me.tvhee.chatradius.commands;

import me.tvhee.api.bukkit.chat.ChatUtils;
import me.tvhee.chatradius.ChatRadiusPlugin;
import me.tvhee.chatradius.iconmenus.MainMenu;
import me.tvhee.chatradius.updater.Updater;
import me.tvhee.chatradius.util.ConfigFiles;
import me.tvhee.chatradius.util.Messages;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class CRCommand implements CommandExecutor
{
	private static final ChatRadiusPlugin plugin = ChatRadiusPlugin.getInstance();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
	{
		if(args.length == 0)
		{
			sender.sendMessage(ChatUtils.format(Messages.igprefix + Messages.pluginMenu1));
			sender.sendMessage(ChatUtils.format(Messages.igprefix + Messages.pluginMenu2).replaceAll("%version%", plugin.getDescription().getVersion()));
			sender.sendMessage(ChatUtils.format(Messages.igprefix + Messages.pluginMenu3));
			sender.sendMessage(ChatUtils.format(Messages.igprefix + Messages.pluginMenu4) + " tvhee");
			sender.sendMessage(ChatUtils.format(Messages.igprefix + Messages.pluginMenu5));
			return true;
		}
		else
		{
			if(args[0].equalsIgnoreCase("help"))
			{
				sender.sendMessage(ChatUtils.format(Messages.igprefix + Messages.helpMenu1));
				sender.sendMessage(ChatUtils.format(Messages.igprefix + Messages.helpMenu2));
				sender.sendMessage(ChatUtils.format(Messages.igprefix + Messages.helpMenu3));
				sender.sendMessage(ChatUtils.format(Messages.igprefix + Messages.helpMenu4));
				sender.sendMessage(ChatUtils.format(Messages.igprefix + Messages.helpMenu5));
				sender.sendMessage(ChatUtils.format(Messages.igprefix + Messages.helpMenu6));
				sender.sendMessage(ChatUtils.format(Messages.igprefix + Messages.helpMenu7));
				return true;
			}
			else if(args[0].equalsIgnoreCase("menu"))
			{
				if(sender.hasPermission("chatradius.menu"))
				{
					if(sender instanceof Player)
					{
						Player player = (Player) sender;
						MainMenu.getMenu().open(player);
					}
					else
					{
						sender.sendMessage(ChatUtils.format(Messages.igprefix + Messages.senderNoPlayer));
						return true;
					}
				}
				else
				{
					sender.sendMessage(ChatUtils.format(Messages.igprefix + Messages.noPermission));
					return true;
				}
			}
			else if(args[0].equalsIgnoreCase("update"))
			{
				if(sender.hasPermission("chatradius.updates"))
				{
					if(ChatRadiusPlugin.getInstance().getConfig().getBoolean("plugin.update-check"))
					{
						if(Updater.getInstance().updateAvailable())
						{
							sender.sendMessage(ChatUtils.format(Messages.igprefix + Messages.updateAvailable).replaceAll("%version%", String.valueOf(Updater.getInstance().getCurrentVersion())).replaceAll("%new-version%", String.valueOf(Updater.getInstance().getNewestVersion())));
							sender.sendMessage(ChatUtils.format(Messages.igprefix + Messages.updateAvailable2));
							return true;
						}
						else
						{
							sender.sendMessage(ChatUtils.format(Messages.igprefix + Messages.noUpdateAvailable));
							return true;
						}
					}
					else
					{
						sender.sendMessage(ChatUtils.format(Messages.igprefix + Messages.updateCheckDeactivated));
						return true;
					}
				}
				else
				{
					sender.sendMessage(ChatUtils.format(Messages.igprefix + Messages.noPermission));
					return true;
				}
			}
			else if(args[0].equalsIgnoreCase("reload"))
			{
				plugin.reloadConfig();
				ConfigFiles.reloadMessagesConfig();
				plugin.current_chat_radius = plugin.getConfig().getInt("plugin.chatradius");
				final PluginManager plg = Bukkit.getPluginManager();
				final Plugin plgname = plg.getPlugin(plugin.getName());
				plg.disablePlugin(plgname);
				plg.enablePlugin(plgname);

				sender.sendMessage(ChatUtils.format(Messages.igprefix + Messages.reload));

				if(ChatRadiusPlugin.getInstance().getConfig().getBoolean("plugin.update-check"))
				{
					if(Updater.getInstance().updateAvailable())
					{
						sender.sendMessage(ChatUtils.format(Messages.igprefix + Messages.updateAvailable).replaceAll("%version%", String.valueOf(Updater.getInstance().getCurrentVersion())).replaceAll("%new-version%", String.valueOf(Updater.getInstance().getNewestVersion())));
						sender.sendMessage(ChatUtils.format(Messages.igprefix + Messages.updateAvailable2));
						return true;
					}
					else
					{
						sender.sendMessage(ChatUtils.format(Messages.igprefix + Messages.noUpdateAvailable));
						return true;
					}
				}
				else
				{
					sender.sendMessage(ChatUtils.format(Messages.igprefix + Messages.updateCheckDeactivated));
					return true;
				}
			}
			else
			{
				sender.sendMessage(ChatUtils.format(Messages.igprefix + Messages.commandNotFound));
				return true;
			}
		}
		return true;
	}
}