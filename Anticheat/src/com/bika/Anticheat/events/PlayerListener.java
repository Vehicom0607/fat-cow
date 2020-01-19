package com.bika.Anticheat.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;

import com.bika.Anticheat.Main;
import com.bika.Anticheat.checks.CheckResult;
import com.bika.Anticheat.checks.CheckType;
import com.bika.Anticheat.checks.Level;
import com.bika.Anticheat.checks.player.FastUse;
import com.bika.Anticheat.util.Settings;
import com.bika.Anticheat.util.User;

public class PlayerListener implements Listener{

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		User u = Main.getUser(e.getPlayer());
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getPlayer().getItemInHand() != null && Settings.FOODS.contains(e.getPlayer().getItemInHand().getType())) {
				u.setFoodStarting();
		}
			if (e.getPlayer().getItemInHand().getType() == Material.BOW && e.getPlayer().getInventory().contains(Material.ARROW)) {
				u.setBowStart(System.currentTimeMillis());
				u.setBow(true);
			}
		}		
		
	
	@EventHandler
	public void onFoodLevelChange(FoodLevelChangeEvent e) {
		User u = Main.USERS.get(e.getEntity().getUniqueId());
		if (u.getPlayer().getItemInHand() != null && Settings.FOODS.contains(u.getPlayer().getItemInHand().getType())) {
			if (u.getInvalidFoodEatableCount() != 0) {
				e.setCancelled(true);
				//u.getPlayer().teleport(u.getFoodStartLocation()); //Lag-back
				Main.log(new CheckResult(Level.FAILED, "", CheckType.NOSLOW), u);
			}
		}
		CheckResult result = FastUse.runFood(u);
		if (result.failed()) {
			e.setCancelled(true);
			Main.log(result, u);
		}
	}
	
	@EventHandler
	public void onShoot(ProjectileLaunchEvent e) {
		User u = Main.USERS.get(e.getEntity().getUniqueId());
		CheckResult result = FastUse.runBow(u);
		if (result.failed()) {
			e.setCancelled(true);
			Main.log(result, u);
		}
	}
	
	@EventHandler
	public void onItemSwitch(PlayerItemHeldEvent e) {
		Main.getUser(e.getPlayer()).setBow(false);
		}
}
