package org.usfirst.frc.team5895.robot;

import org.usfirst.frc.team5895.robot.auto.*;
import org.usfirst.frc.team5895.robot.framework.*;
import org.usfirst.frc.team5895.robot.lib.BetterJoystick;
import org.usfirst.frc.team5895.robot.framework.LookupTable;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class Robot extends IterativeRobot {

	Looper loop, loopVision;
	BetterJoystick Jleft, Jright, Jsecond;
	DriveTrain drivetrain;
	GearReceiver gear;
	Climber climber;
	Recorder recorder;
	
	public void robotInit() {

		Jleft = new BetterJoystick(0);
		Jright = new BetterJoystick(1);
		Jsecond = new BetterJoystick(2);
		drivetrain = new DriveTrain();
		gear = new GearReceiver();
		climber = new Climber();
		recorder = new Recorder(drivetrain);
		
		
		loop = new Looper(10);
		loop.add(drivetrain::update);
		loop.add(gear::update);
		loop.add(climber::update);
		loop.add(recorder::record);
		loop.start();
		
	}

	public void autonomousInit() {
	//	recorder.startRecording("Auto.csv");
		
		String routine = SmartDashboard.getString("DB/String 0", "nothing");
		String gameplan = SmartDashboard.getString("DB/String 1", "nothing");
		String distance = SmartDashboard.getString("DB/String 2", "nothing");
		
		if(routine.contains("blue")) {
			 if(gameplan.contains("gear")){
				if(distance.contains("center")) {
					BlueCenterGear.run(drivetrain, gear);
				} else {
				BlueGear.run(drivetrain, gear);
				}	
			}	
			else{
				DoNothing.run();
			}
		}
		
		if(routine.contains("red")) {
			if(gameplan.contains("gear")){
				if(distance.contains("center")) {
					RedCenterGear.run(drivetrain, gear);
				}
				else {
				RedGear.run(drivetrain, gear);
			}
			}
		
			else if(routine.contains("center")) {
			if(gameplan.contains("gear")) {
				CenterGear.run(drivetrain, gear);
			}
		}
		else {
			DoNothing.run();
		}
		}
	}

	public void teleopPeriodic() {		
		//normal teleop drive
		drivetrain.arcadeDrive(Jleft.getRawAxis(1), -Jright.getRawAxis(0));
		
		//From here on this is the joysticks controls of the main driver
		
		//Open or close the gear intake
		if(Jleft.getRisingEdge(1)){
			gear.pushGear();
		}
		else if(Jleft.getFallingEdge(1)) {
			
		}
		
		//auto raise and lower gear
		if(Jleft.getRisingEdge(2)) {
			gear.autoUp();
		}
		//manual raise and lower gear
		if(Jleft.getRisingEdge(3)) {
			gear.gearUp();
		}
		if(Jleft.getRisingEdge(4)) {
			gear.gearDown();
		}
		
		
		//Climber State
		if(Jsecond.getRisingEdge(3)){
			climber.climb();
		}else if (Jsecond.getRisingEdge(4)){
			climber.standing();
		}
	}

	public void teleopInit() {
	
		drivetrain.arcadeDrive(0, 0);
		climber.stopClimbing();
		gear.closeFlap();
		gear.closeGear();
	}
	
	public void disabledInit() {
		recorder.stopRecording();
		drivetrain.arcadeDrive(0, 0);
		climber.stopClimbing();
		gear.closeFlap();
		gear.closeGear();
	}
	
}
