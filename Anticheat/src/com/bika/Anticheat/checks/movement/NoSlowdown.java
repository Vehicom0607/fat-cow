package com.bika.Anticheat.checks.movement;

import com.bika.Anticheat.checks.CheckResult;
import com.bika.Anticheat.checks.CheckType;
import com.bika.Anticheat.checks.Level;
import com.bika.Anticheat.util.Distance;
import com.bika.Anticheat.util.Settings;
import com.bika.Anticheat.util.User;

public class NoSlowdown {

	private static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.NOSLOW);

	public static void registerMove(Distance d, User u) {
		double xzDist = (d.getxDiff() > d.getzDiff() ? d.getxDiff() : d.getzDiff());
		if (xzDist > Settings.MAX_XZ_EATING_SPEED && System.currentTimeMillis() - u.getFoodStarting() > 1200) 
			u.addInvalidFoodEatableCount();
	}

	public static CheckResult runCheck(Distance d, User u) {
		double xzDist = (d.getxDiff() > d.getzDiff() ? d.getxDiff() : d.getzDiff());
		
		if (u.getPlayer().isBlocking()) {
			if (xzDist > Settings.MAX_XZ_BLOCKING_SPEED) 
			return new CheckResult(Level.FAILED, "", CheckType.NOSLOW);
		}
		return PASS;
	}
	
}
