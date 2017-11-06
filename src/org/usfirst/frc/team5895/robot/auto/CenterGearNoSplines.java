package org.usfirst.frc.team5895.robot.auto;

import org.usfirst.frc.team5895.robot.DriveTrain;
import org.usfirst.frc.team5895.robot.GearReceiver;
import org.usfirst.frc.team5895.robot.framework.Waiter;

public class CenterGearNoSplines {
	
	/**
	 * center gear auto no shooting
	 * @param drivetrain
	 * @param gear
	 */
	public static void run(DriveTrain drivetrain, GearReceiver gear) {

		drivetrain.driveStraight(8);
		Waiter.waitFor(10000);
		drivetrain.arcadeDrive(0, 0);
		gear.placeGear();
		Waiter.waitFor(1000);
		drivetrain.arcadeDrive(0.5, 0.5);
		Waiter.waitFor(2000);
		drivetrain.arcadeDrive(0, 0);
	}
}