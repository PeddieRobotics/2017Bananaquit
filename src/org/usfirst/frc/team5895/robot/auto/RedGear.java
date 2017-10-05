package org.usfirst.frc.team5895.robot.auto;

import org.usfirst.frc.team5895.robot.DriveTrain;
import org.usfirst.frc.team5895.robot.GearReceiver;
import org.usfirst.frc.team5895.robot.framework.Waiter;

public class RedGear {
		
	public static void run(DriveTrain drivetrain, GearReceiver gear) {

		drivetrain.auto_red_gearDrive();
		Waiter.waitFor(4000);
		drivetrain.arcadeDrive(0, 0);
		gear.openGear();
		Waiter.waitFor(500);
		gear.pushGear();
		Waiter.waitFor(1000);
		drivetrain.driveStraight(5);
		Waiter.waitFor(2000);
		drivetrain.arcadeDrive(0, 0);
		}
	}
