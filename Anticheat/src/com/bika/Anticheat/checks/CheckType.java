package com.bika.Anticheat.checks;

import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;

public enum CheckType {

	SPEED("Speed", new Permission("main.bypass.speed")),
	NOSLOW("NoSlowdown", new Permission("main.bypass.noslow")), 
	FASTUSE("FastUse", new Permission("main.bypass.fastuse")),
	FASTHEAL("Regen", new Permission("main.bypass.fastheal")),
	NORMALMOVEMENTS("NormalMovements", new Permission("main.bypass.normalmovements"));
	
	private String name;
	private Permission perm;

	private CheckType(String name, Permission perm) {
		this.name = name;
		this.perm = perm;
		Bukkit.getPluginManager().addPermission(perm);
	}

	public String getName() {
		return name;
	}

	public Permission getPerm() {
		return perm;
	}
	
}
