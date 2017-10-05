package org.usfirst.frc.team5895.robot.auto;

import org.usfirst.frc.team5895.robot.DriveTrain;
import org.usfirst.frc.team5895.robot.GearReceiver;
import org.usfirst.frc.team5895.robot.Shooter;
import org.usfirst.frc.team5895.robot.Turret;
import org.usfirst.frc.team5895.robot.Vision;
import org.usfirst.frc.team5895.robot.framework.Waiter;

public class BlueGear {
		
	/**
	 * blue side gear auto
	 * @param drivetrain
	 * @param gear
	 */
	public static void run(DriveTrain drivetrain, GearReceiver gear) {

		drivetrain.auto_blue_gearDrive();
		Waiter.waitFor(drivetrain::isFinished, 4000);
		drivetrain.arcadeDrive(0, 0);
		gear.openGear();
		Waiter.waitFor(200);
		drivetrain.driveStraight(2);
		Waiter.waitFor(drivetrain::atDistance, 2000);
		drivetrain.arcadeDrive(0, 0);
		Waiter.waitFor(200);
		}
	}