package me.tvhee.chatradius.listeners;

import me.tvhee.api.bukkit.chat.ChatUtils;
import me.tvhee.chatradius.ChatRadiusPlugin;
import me.tvhee.chatradius.iconmenus.MainMenu;
import me.tvhee.chatradius.util.ChatUtil;
import me.tvhee.chatradius.util.HashMaps;
import me.tvhee.chatradius.util.Messages;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener
{
	private static ChatRadiusPlugin plugin = ChatRadiusPlugin.getInstance();

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e)
	{
		Player player = e.getPlayer();
		String message = e.getMessage();

		if(!HashMaps.inInventory.containsKey(player))
		{
			int blockDistance = plugin.current_chat_radius;
			Location playerLoc = player.getLocation();
			String uuid = player.getUniqueId().toString();

			if(!HashMaps.broadcastMode.contains(uuid))
			{
				e.getRecipients().removeIf(target -> !HashMaps.spyMode.contains(target.getUniqueId().toString()) && target.getLocation().distance(playerLoc) > blockDistance);
			}
			return;
		}

		e.getRecipients().clear();

		if(e.getMessage().equalsIgnoreCase("exit"))
		{
			MainMenu.getMenu().open(player);
			return;
		}

		int slot = HashMaps.clickedInvSlot.get(player);
		if(slot == 1)
		{
			int radius;
			try
			{
				radius = Integer.parseInt(message);
			}
			catch(NumberFormatException ignored)
			{
				player.sendMessage(ChatUtils.format(Messages.igprefix + Messages.noNumberUsed).replaceAll("%args%", message));
				return;
			}

			plugin.getConfig().set("Messages.chatradius", radius);
			plugin.saveConfig();
			ChatUtil.removeInventory(player);
			Bukkit.broadcastMessage(ChatUtils.format(Messages.igprefix + Messages.newSetRadius).replaceAll("%setradius%", String.valueOf(radius)));
		}
		else if(slot == 3)
		{
			Player target = Bukkit.getPlayer(message);
			if(target != null)
			{
				String uuid = target.getUniqueId().toString();

				if(!HashMaps.spyMode.contains(uuid))
				{
					HashMaps.spyMode.add(uuid);
					player.sendMessage(ChatUtils.format(Messages.igprefix + Messages.menuSpyModeTrue).replaceAll("%target%", target.getName()));
					target.sendMessage(ChatUtils.format(Messages.igprefix + Messages.menuSpyModeTruePlayer));
				}
				else
				{
					HashMaps.spyMode.remove(uuid);
					player.sendMessage(ChatUtils.format(Messages.igprefix + Messages.menuSpyModeFalse).replaceAll("%target%", target.getName()));
					target.sendMessage(ChatUtils.format(Messages.igprefix + Messages.menuSpyModeFalsePlayer));
				}

				ChatUtil.removeInventory(player);
			}
			else
			{
				player.sendMessage(ChatUtils.format(Messages.igprefix + Messages.targetPlayerNotFound).replaceAll("%player%", message));
				return;
			}
		}
		else if(slot == 5)
		{
			Player target = Bukkit.getPlayer(message);
			if(target != null)
			{
				String uuid = target.getUniqueId().toString();

				if(!HashMaps.broadcastMode.contains(uuid))
				{
					HashMaps.broadcastMode.add(uuid);
					player.sendMessage(ChatUtils.format(Messages.igprefix + Messages.menuBroadcastModeTrue).replaceAll("%target%", target.getName()));
					target.sendMessage(ChatUtils.format(Messages.igprefix + Messages.menuBroadcastModeTruePlayer));
				}
				else
				{
					HashMaps.broadcastMode.remove(uuid);
					player.sendMessage(ChatUtils.format(Messages.igprefix + Messages.menuBroadcastModeFalse).replaceAll("%target%", target.getName()));
					target.sendMessage(ChatUtils.format(Messages.igprefix + Messages.menuBroadcastModeFalsePlayer));
				}
				ChatUtil.removeInventory(player);
			}
			else
			{
				Bukkit.broadcastMessage(ChatUtils.format(Messages.igprefix + Messages.targetPlayerNotFound).replaceAll("%player%", message));
				return;
			}
		}
		MainMenu.getMenu().open(player);
	}
}
