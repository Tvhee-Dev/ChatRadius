package me.tvhee.chatradius.iconmenus;

import me.tvhee.api.bukkit.chat.ChatUtils;
import me.tvhee.api.bukkit.gui.IconMenu;
import me.tvhee.chatradius.ChatRadiusPlugin;
import me.tvhee.chatradius.util.ChatUtil;
import me.tvhee.chatradius.util.Messages;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MainMenu
{
    public static IconMenu getMenu()
    {
        IconMenu menu = new IconMenu(ChatColor.GOLD + "ChatRadiusMenu", 9, new IconMenu.OptionClickEventHandler() {
            @Override
            public void onOptionClick(IconMenu.OptionClickEvent e)
            {
                Player player = e.getPlayer();
                if(e.getPosition() == 1)
                {
                    player.sendMessage(ChatUtils.format(Messages.igprefix + Messages.typeInRadius));
                    ChatUtil.putInventory(e.getPlayer(), e.getPosition(), "ChatRadiusMainMenu");
                    e.setWillClose(true);
                    e.setWillDestroy(true);
                }
                else if(e.getPosition() == 3)
                {
                    player.sendMessage(ChatUtils.format(Messages.igprefix + Messages.typeInSpy));
                    ChatUtil.putInventory(e.getPlayer(), e.getPosition(), "ChatRadiusMainMenu");
                    e.setWillClose(true);
                    e.setWillDestroy(true);
                }
                else if(e.getPosition() == 5)
                {
                    player.sendMessage(ChatUtils.format(Messages.igprefix + Messages.typeInBroadcast));
                    ChatUtil.putInventory(e.getPlayer(), e.getPosition(), "ChatRadiusMainMenu");
                    e.setWillClose(true);
                    e.setWillDestroy(true);
                }
                else if(e.getPosition() == 8)
                {
                    ChatUtil.removeInventory(e.getPlayer());
                    e.setWillClose(true);
                    e.setWillDestroy(true);
                }
            }
        }, ChatRadiusPlugin.getInstance());

        menu.setOption(0, new ItemStack(Material.YELLOW_STAINED_GLASS_PANE), null, null);
        menu.setOption(1, new ItemStack(Material.COMPASS), ChatColor.DARK_RED + "Radius: " + ChatColor.WHITE + ChatRadiusPlugin.getInstance().getConfig().getInt("plugin.chatradius"), null);
        menu.setOption(2, new ItemStack(Material.YELLOW_STAINED_GLASS_PANE), null, null);
        menu.setOption(3, new ItemStack(Material.POTION), ChatColor.DARK_GREEN + "Change spymode from somebody", null);
        menu.setOption(4, new ItemStack(Material.YELLOW_STAINED_GLASS_PANE), null, null);
        menu.setOption(5, new ItemStack(Material.PAPER), ChatColor.DARK_AQUA + "Change broadcastmode from somebody", null);
        menu.setOption(6, new ItemStack(Material.YELLOW_STAINED_GLASS_PANE), null, null);
        menu.setOption(7, new ItemStack(Material.YELLOW_STAINED_GLASS_PANE), null, null);
        menu.setOption(8, new ItemStack(Material.BARRIER), ChatColor.RED + "Close menu", null);
        return menu;
    }
}
