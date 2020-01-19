package com.bika.Anticheat.util;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.bika.Anticheat.checks.CheckType;

public class User {

	private Player player;
	private Long foodStart, bowStart;
	private Location foodStartLocation;
	private int invalidFoodEatableCount = 0;
	private HashMap<CheckType, Integer> warnings = new HashMap<>();
	private boolean bow = false;
	private int kicks = 0;
	
	public int jump = 0;
	
	public User(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setFoodStarting() {
		this.foodStart = System.currentTimeMillis();
		this.foodStartLocation = player.getLocation();
	}
	
	public Long getFoodStarting() {
		return foodStart;
	}
	
	public boolean isFoodStarting() {
		return foodStart != null;
	}
	
	public boolean isFoodStarted() {
		return foodStart != null;
	}
	
	public void addInvalidFoodEatableCount() {
		this.invalidFoodEatableCount++;
	}
	
	public int getInvalidFoodEatableCount() {
		return this.invalidFoodEatableCount;
	}

	public Location getFoodStartLocation() {
		return foodStartLocation;
	}

	public void resetInvalidFoodEatableCount() {
		this.invalidFoodEatableCount = 0;
	}
	
	public int getWarnings(CheckType type) {
		warnings.putIfAbsent(type, 0);
		return warnings.get(type);
	}
	
	public HashMap<CheckType, Integer> getAllWarnings(){
		return warnings;
	}
	
	public void addWarning(CheckType type) {
		getWarnings(type);
		warnings.put(type, warnings.get(type) + 1);
	}
	
	public boolean isBow() {
		return bow;
	}
	
	public void setBow(boolean bow) {
		this.bow = bow;
	}
	
	public boolean isBlockAboveSolid(boolean x, Location loc) {
		return x;
	}
	
	public boolean isBlockAboveSolid(Location loc) {
		return isBlockAboveSolid(true, loc) || isBlockAboveSolid(false, loc);
	}
	
	public Long getBowStart() {
		return bowStart;
	}
		
	public void setBowStart(Long bowStart) {
		this.bowStart = bowStart;
	}

	public int getKicks() {
		return kicks;
	}
	
	public void setKicks() {
		this.kicks = kicks;
	}
	@SuppressWarnings("unchecked")
	public void setWarnings(HashMap<CheckType, Integer> warnings) {
		this.warnings = (HashMap<CheckType, Integer>) warnings.clone();
	}
	
	public void addKick() {
		kicks++;
	}
	
}
