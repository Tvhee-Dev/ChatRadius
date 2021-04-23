package me.tvhee.chatradius.util;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMaps
{
    public static List<String> spyMode = new ArrayList<>();
    public static List<String> broadcastMode = new ArrayList<>();
    public static HashMap<Player, String> inInventory = new HashMap<>();
    public static HashMap<Player, Integer> clickedInvSlot = new HashMap<>();
}
