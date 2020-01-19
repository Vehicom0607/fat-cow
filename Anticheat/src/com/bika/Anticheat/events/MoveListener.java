package com.bika.Anticheat.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.bika.Anticheat.Main;
import com.bika.Anticheat.checks.CheckResult;
import com.bika.Anticheat.checks.movement.NoSlowdown;
import com.bika.Anticheat.checks.movement.NormalMovements;
import com.bika.Anticheat.checks.movement.Speed;
import com.bika.Anticheat.util.Distance;
import com.bika.Anticheat.util.User;

public class MoveListener implements Listener{
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		User u = Main.USERS.get(e.getPlayer().getUniqueId());
		Distance d = new Distance(e);
		CheckResult speed = Speed.runCheck(d, u);
		CheckResult noSlow = NoSlowdown.runCheck(d, u);
		NoSlowdown.registerMove(d, u);
		if (speed.failed()) { 
			//e.setTo(e.getFrom()); //Lag-back
			Main.log(speed, u);	
		}
		if (noSlow.failed()) { 
			//e.setTo(e.getFrom()); //Lag-back
			Main.log(noSlow, u);	
		}
		CheckResult normalMovements = NormalMovements.runCheck(u, d);
		if (normalMovements.failed()) {
			e.setTo(e.getFrom());
			Main.log(normalMovements, u);
			u.jump = 0;
		}
	}
}
