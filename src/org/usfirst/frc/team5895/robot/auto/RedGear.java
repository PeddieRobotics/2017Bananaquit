package org.usfirst.frc.team5895.robot.auto;

import org.usfirst.frc.team5895.robot.DriveTrain;
import org.usfirst.frc.team5895.robot.GearReceiver;
import org.usfirst.frc.team5895.robot.framework.Waiter;

public class RedGear {
	
	/**
	 * red side gear auto
	 * @param drivetrain
	 * @param gear
	 */
	public static void run(DriveTrain drivetrain, GearReceiver gear) {

		drivetrain.auto_red_gearDrive();
		Waiter.waitFor(drivetrain::isFinished, 4000);
		drivetrain.arcadeDrive(0, 0);
		gear.placeGear();
		drivetrain.arcadeDrive(0.25, 0);
		Waiter.waitFor(2000);
		drivetrain.arcadeDrive(0, 0);
		}
	}
