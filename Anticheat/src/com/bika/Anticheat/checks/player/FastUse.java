package com.bika.Anticheat.checks.player;

import com.bika.Anticheat.checks.CheckResult;
import com.bika.Anticheat.checks.CheckType;
import com.bika.Anticheat.checks.Level;
import com.bika.Anticheat.util.Settings;
import com.bika.Anticheat.util.User;

public class FastUse {

private static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.FASTUSE);
	
	public static CheckResult runBow(User u) {
		long now = System.currentTimeMillis();
		if (u.getBowStart() != null && now - u.getBowStart() < Settings.BOW_MIN)
			return new CheckResult(Level.FAILED, "tried to shoot too fast, time =(" + (now - u.getBowStart()) + "), min =(" + Settings.BOW_MIN + ")", CheckType.FASTUSE);
		return PASS;
	}
	
	public static CheckResult runFood(User u) {
		long now = System.currentTimeMillis();
		if (u.getFoodStarting() != null && now - u.getFoodStarting() < Settings.FOOD_MIN)
			return new CheckResult(Level.FAILED, "tried to eat too fast, time =(" + (now - u.getFoodStarting()) + "), min =(" + Settings.FOOD_MIN + ")", CheckType.FASTUSE);
		return PASS;
	}
}
