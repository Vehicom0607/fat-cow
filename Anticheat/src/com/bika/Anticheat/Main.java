package com.bika.Anticheat;

import static org.bukkit.ChatColor.BOLD;
import static org.bukkit.ChatColor.DARK_PURPLE;
import static org.bukkit.ChatColor.GRAY;
import static org.bukkit.ChatColor.RED;
import static org.bukkit.ChatColor.RESET;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.bika.Anticheat.checks.CheckResult;
import com.bika.Anticheat.events.JoinLeaveListener;
import com.bika.Anticheat.events.MoveListener;
import com.bika.Anticheat.events.PlayerListener;
import com.bika.Anticheat.util.Settings;
import com.bika.Anticheat.util.User;

public class Main extends JavaPlugin{

	public static HashMap<UUID, User> USERS = new HashMap<>();
	@Override
	public void onEnable() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new JoinLeaveListener(), this);
		pm.registerEvents(new MoveListener(), this);
		pm.registerEvents(new PlayerListener(), this);
		
		for (Player p : Bukkit.getOnlinePlayers()) 
			USERS.put(p.getUniqueId(), new User(p));
	}
	
	public static void log(CheckResult cr, User u) {  
		u.addWarning(cr.getType());
		String message = DARK_PURPLE.toString() + BOLD + "[PAC] " + RESET.toString() + RED + u.getPlayer().getName() + GRAY + " " + cr.getLevel().toString().toLowerCase() + " " + DARK_PURPLE + cr.getType().getName() + RESET.toString() + GRAY + " [VL " + u.getWarnings(cr.getType()) + "]";
		for(Player p : Bukkit.getOnlinePlayers()) 
			if (p.hasPermission(Settings.NOTIFY)) 
				Bukkit.getServer().broadcastMessage(message);
			//Bukkit.getConsoleSender().sendMessage(message); //Send to console
			if (u.getWarnings(cr.getType()) > Settings.MAX_WARNINGS) {
				u.getPlayer().kickPlayer(RED.toString() + BOLD + "[PAC CHEAT DETECTION]" + RESET.toString() + GRAY + "\n" + DARK_PURPLE + "Modification: " + GRAY + "hax");
			}
		}
	
	public static User getUser(Player p) {
		return USERS.get(p.getUniqueId());
	}
}


