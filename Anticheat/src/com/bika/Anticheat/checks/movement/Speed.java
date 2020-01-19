package com.bika.Anticheat.checks.movement;

import com.bika.Anticheat.checks.CheckResult;
import com.bika.Anticheat.checks.CheckType;
import com.bika.Anticheat.checks.Level;
import com.bika.Anticheat.util.Distance;
import com.bika.Anticheat.util.Settings;
import com.bika.Anticheat.util.User;

public class Speed {
	

	private static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.SPEED);
	
	public static CheckResult runCheck(Distance d, User u) {
		Double xz_speed = (d.getxDiff() > d.getzDiff() ? d.getxDiff() : d.getzDiff());
		if (xz_speed > Settings.MAX_XZ_SPEED)
			return new CheckResult(Level.FAILED, "speed =(" + xz_speed.toString() + "), MAX =(" + Settings.MAX_XZ_SPEED, CheckType.SPEED);
		return PASS;
	} 
}
