package me.tvhee.chatradius.util;

import me.tvhee.chatradius.ChatRadiusPlugin;

public class Messages
{
    public static String igprefix = ChatRadiusPlugin.getInstance().getConfig().getString("plugin.prefix");

    public static String pluginMenu1 = ConfigFiles.getMessagesConfig().getString("messages.pluginmenu.line1");
    public static String pluginMenu2 = ConfigFiles.getMessagesConfig().getString("messages.pluginmenu.line2");
    public static String pluginMenu3 = ConfigFiles.getMessagesConfig().getString("messages.pluginmenu.line3");
    public static String pluginMenu4 = ConfigFiles.getMessagesConfig().getString("messages.pluginmenu.line4");
    public static String pluginMenu5 = ConfigFiles.getMessagesConfig().getString("messages.pluginmenu.line5");

    public static String helpMenu1 = ConfigFiles.getMessagesConfig().getString("messages.helpmenu.line1");
    public static String helpMenu2 = ConfigFiles.getMessagesConfig().getString("messages.helpmenu.line2");
    public static String helpMenu3 = ConfigFiles.getMessagesConfig().getString("messages.helpmenu.line3");
    public static String helpMenu4 = ConfigFiles.getMessagesConfig().getString("messages.helpmenu.line4");
    public static String helpMenu5 = ConfigFiles.getMessagesConfig().getString("messages.helpmenu.line5");
    public static String helpMenu6 = ConfigFiles.getMessagesConfig().getString("messages.helpmenu.line6");
    public static String helpMenu7 = ConfigFiles.getMessagesConfig().getString("messages.helpmenu.line7");

    public static String commandNotFound = ConfigFiles.getMessagesConfig().getString("messages.command.not-found");
    public static String senderNoPlayer = ConfigFiles.getMessagesConfig().getString("messages.command.no-player");
    public static String targetPlayerNotFound = ConfigFiles.getMessagesConfig().getString("messages.command.no-player-found");
    public static String noPermission = ConfigFiles.getMessagesConfig().getString("messages.command.no-permission");
    public static String reload = ConfigFiles.getMessagesConfig().getString("messages.command.reload");

    public static String menuSpyModeTrue = ConfigFiles.getMessagesConfig().getString("messages.menu.spymode.enabled");
    public static String menuSpyModeTruePlayer = ConfigFiles.getMessagesConfig().getString("messages.menu.spymode.enabled-player");
    public static String menuSpyModeFalsePlayer = ConfigFiles.getMessagesConfig().getString("messages.menu.spymode.disabled-player");
    public static String menuSpyModeFalse = ConfigFiles.getMessagesConfig().getString("messages.menu.spymode.disabled");

    public static String menuBroadcastModeTrue = ConfigFiles.getMessagesConfig().getString("messages.menu.broadcastmode.enabled");
    public static String menuBroadcastModeTruePlayer = ConfigFiles.getMessagesConfig().getString("messages.menu.broadcastmode.enabled-player");
    public static String menuBroadcastModeFalsePlayer = ConfigFiles.getMessagesConfig().getString("messages.menu.broadcastmode.disabled-player");
    public static String menuBroadcastModeFalse = ConfigFiles.getMessagesConfig().getString("messages.menu.broadcastmode.disabled");

    public static String newSetRadius = ConfigFiles.getMessagesConfig().getString("messages.menu.setradius");
    public static String noNumberUsed = ConfigFiles.getMessagesConfig().getString("messages.command.no-number-used");

    public static String typeInRadius = ConfigFiles.getMessagesConfig().getString("messages.menu.type-in.new-radius");
    public static String typeInSpy = ConfigFiles.getMessagesConfig().getString("messages.menu.type-in.new-player-spy");
    public static String typeInBroadcast = ConfigFiles.getMessagesConfig().getString("messages.menu.type-in.new-player-broadcast");

    public static String updateAvailable = ConfigFiles.getMessagesConfig().getString("messages.update.available");
    public static String updateAvailable2 = ConfigFiles.getMessagesConfig().getString("messages.update.available_2");
    public static String noUpdateAvailable = ConfigFiles.getMessagesConfig().getString("messages.update.not-available");
    public static String updateCheckDeactivated = ConfigFiles.getMessagesConfig().getString("messages.update.deactivated");
}
