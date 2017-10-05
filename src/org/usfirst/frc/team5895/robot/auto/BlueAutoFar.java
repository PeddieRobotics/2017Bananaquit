package org.usfirst.frc.team5895.robot.auto;

import org.usfirst.frc.team5895.robot.DriveTrain;
import org.usfirst.frc.team5895.robot.Intake;
import org.usfirst.frc.team5895.robot.Shooter;
import org.usfirst.frc.team5895.robot.Turret;
import org.usfirst.frc.team5895.robot.Vision;
import org.usfirst.frc.team5895.robot.framework.LookupTable;
import org.usfirst.frc.team5895.robot.framework.Waiter;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BlueAutoFar {

	/**
	 * blue far hopper auto, doesn't hit touchpad
	 * @param drivetrain
	 * @param shooter
	 * @param turret
	 * @param table
	 * @param vision
	 * @param intake
	 */
	public static void run(DriveTrain drivetrain, Shooter shooter, Turret turret, LookupTable table, Vision vision, Intake intake) {
		
		turret.turnTo(-80);
		intake.open();
		drivetrain.auto_blue_farDrive();
		shooter.setSpeed(3415);
		Waiter.waitFor(drivetrain::isFinished, 4000);
		drivetrain.arcadeDrive(0, 0);
		Waiter.waitFor(200);
		turret.turnTo(turret.getAngle()+vision.getX()-1);
		Waiter.waitFor(shooter::atSpeed, 2000);
		if(shooter.getSpeed() > 10) {
			shooter.shoot();
		}
	}
	
}