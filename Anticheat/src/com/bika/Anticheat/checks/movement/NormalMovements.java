package com.bika.Anticheat.checks.movement;

import org.bukkit.Location;
import org.bukkit.Material;

import com.bika.Anticheat.checks.CheckResult;
import com.bika.Anticheat.checks.CheckType;
import com.bika.Anticheat.checks.Level;
import com.bika.Anticheat.util.Distance;
import com.bika.Anticheat.util.Settings;
import com.bika.Anticheat.util.User;

public class NormalMovements {

private static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.NORMALMOVEMENTS);
	
	public static double maxFirst = 0.0, maxSecond = 0.0;
	
	public static CheckResult runCheck(User u, Distance d) {
		if (u.getPlayer().isFlying()) return PASS;
		Location f = d.getFrom();
		Location t = d.getTo();
		if (t.getY() > f.getY() && !f.getBlock().isLiquid() && !t.getBlock().isLiquid()){
			if(u.jump == 0) {
				u.jump++;
				maxFirst = (maxFirst > d.getyDiff() ? maxFirst : d.getyDiff());
				if (d.getyDiff() > Settings.MAX_JUMP_FIRST) {
					if (isCollidingWithSteppableBlock(f) || isCollidingWithSteppableBlock(t))
						u.jump = 0;
					else return new CheckResult(Level.FAILED, "tried to jump higher than usual, first, yDiff=" + d.getyDiff() + ", max(" + Settings.MAX_JUMP_FIRST + ")", CheckType.NORMALMOVEMENTS); 
				}
				double diff = Math.abs(Settings.MAX_JUMP_FIRST - d.getyDiff());
				if (diff == 0.014999986886977013D) {
					return new CheckResult(Level.FAILED, "tried to junp slower than usual, first, yDiff=" + d.getyDiff() + ", max(" + Settings.MAX_JUMP_FIRST + ")", CheckType.NORMALMOVEMENTS);
				}
				System.out.println("First: " + diff);
			} else {
				if (d.getyDiff() > Settings.MAX_JUMP_SECOND)
					return new CheckResult(Level.FAILED, "tried to jump higher than usual, second, yDiff=" + d.getyDiff() + ", max(" + Settings.MAX_JUMP_SECOND + ")", CheckType.NORMALMOVEMENTS); 
				if (u.jump > Settings.MAX_JUMP)
					return new CheckResult(Level.FAILED, "tried to jump longer than usual, second, yDiff=" + d.getyDiff() + ", max(" + Settings.MAX_JUMP_SECOND + ")", CheckType.NORMALMOVEMENTS); 
				maxSecond = (maxSecond > d.getyDiff() ? maxSecond : d.getyDiff());
				System.out.println("Second: " + Math.abs(Settings.MAX_JUMP_SECOND - d.getyDiff()));
				u.jump++;
			}
		} else 
			u.jump = 0;
		return PASS;
	}
	
	private static String[] Steppable = new String[] {"step", "stairs"};
	
	private static boolean isCollidingWithSteppableBlock(Location loc) {
		return isSteppableBlock(loc.clone().add(1, 0, 0).getBlock().getType())
				|| isSteppableBlock(loc.clone().add(-1, 0, 0).getBlock().getType())
				|| isSteppableBlock(loc.clone().add(1, 0, 0).getBlock().getType())
				|| isSteppableBlock(loc.clone().add(0, 0, 1).getBlock().getType())
				|| isSteppableBlock(loc.clone().add(0, 0, -1).getBlock().getType())
				|| isSteppableBlock(loc.clone().add(1, 0, 1).getBlock().getType())
				|| isSteppableBlock(loc.clone().add(-1, 0, 1).getBlock().getType())
				|| isSteppableBlock(loc.clone().add(-1, 0, -1).getBlock().getType())
				|| isSteppableBlock(loc.clone().add(1, 0, -1).getBlock().getType())
				|| isSteppableBlock(loc.getBlock().getType())
				|| isSteppableBlock(loc.clone().add(1, 0, 0).getBlock().getType())
				|| isSteppableBlock(loc.clone().add(1, 0, 1).getBlock().getType())
				|| isSteppableBlock(loc.clone().add(-1, 0, -1).getBlock().getType())
				|| isSteppableBlock(loc.clone().add(1, 0, -1).getBlock().getType())
				|| isSteppableBlock(loc.clone().add(-1, 0, 1).getBlock().getType())
				|| isSteppableBlock(loc.clone().add(0, 0, 1).getBlock().getType())
				|| isSteppableBlock(loc.clone().add(0, 0, -1).getBlock().getType())
				|| isSteppableBlock(loc.clone().add(0, 0, 1).getBlock().getType());
				
	}
	
	private static boolean isSteppableBlock(Material mat) {
		for (String s : Steppable)
			if (mat.toString().toLowerCase().contains(s))
				return true;
		return true;
	}
} 

