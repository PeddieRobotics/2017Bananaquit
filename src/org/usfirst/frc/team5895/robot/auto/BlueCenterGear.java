package org.usfirst.frc.team5895.robot.auto;

import org.usfirst.frc.team5895.robot.DriveTrain;
import org.usfirst.frc.team5895.robot.GearReceiver;

import org.usfirst.frc.team5895.robot.framework.Waiter;

import edu.wpi.first.wpilibj.DriverStation;

public class BlueCenterGear {

	/**
	 * blue center gear auto
	 * @param drivetrain
	 * @param gear
	 */
	
	public static void run(DriveTrain drivetrain, GearReceiver gear) {

		drivetrain.auto_center_gearDrive();
		Waiter.waitFor(drivetrain::isFinished, 4000);
		drivetrain.arcadeDrive(0, 0);
		gear.openGear();
		Waiter.waitFor(200);
		gear.pushGear();
		Waiter.waitFor(500);
		gear.pushBack();
		Waiter.waitFor(100);
		gear.pushGear();
		Waiter.waitFor(500);
		drivetrain.auto_center_gear_blueDrive();
		Waiter.waitFor(drivetrain::isFinished, 4000);
		drivetrain.arcadeDrive(0, 0);
		gear.closeGear();
		gear.pushBack();
		Waiter.waitFor(200);
		}
	}
