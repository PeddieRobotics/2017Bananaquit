package org.usfirst.frc.team5895.robot;

import org.usfirst.frc.team5895.robot.framework.Waiter;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DigitalInput;

public class GearReceiver {

	private Solenoid gearSolenoid;
	private Talon gearMotor;
	private DigitalInput gearSensor;
	private boolean haveGear;
	private boolean autoUp;


	public GearReceiver() {
		gearSolenoid = new Solenoid(ElectricalLayout.GEAR_SOLENOID);
		gearMotor = new Talon(ElectricalLayout.GEAR_MOTOR);
		gearSensor = new DigitalInput(ElectricalLayout.GEAR_SENSOR);
	}

	public void haveGear() {
		if(gearSensor.get() == true) {
			haveGear = true;
			gearMotor.set(0.1);
		}
		else {
			haveGear = false;
			gearMotor.set(1);
		}
	}
	
	public void reverseGear() {
		if(haveGear == true) {
			gearMotor.set(-1);
		}
	}
	
	public void placeGear() {
		autoUp = false; 
		gearSolenoid.set(true);
		Waiter.waitFor(100);
		gearMotor.set(-1);
		Waiter.waitFor(100);
	}
	
	public void gearUp() {
		autoUp = false;
		gearSolenoid.set(false);
	}
	
	public void gearDown() {
		autoUp = false;
		gearSolenoid.set(true);
	}
	
	public void autoUp() {
		autoUp = true;
	}
	
	public void stopMotor() {
		gearMotor.set(0);
	}
	
	public void update() {
		haveGear();
		if(autoUp == true) {
			
		}
	}

}
