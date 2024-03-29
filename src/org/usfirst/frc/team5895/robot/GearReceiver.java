package org.usfirst.frc.team5895.robot;

import org.usfirst.frc.team5895.robot.framework.Waiter;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DigitalInput;

public class GearReceiver {

	private Solenoid gearSolenoid;
	private Talon gearMotor;
	private DigitalInput gearSensor;
	private boolean upDown;
	private double gearSpeed;
	private boolean ejecting;

	public GearReceiver() {
		gearSolenoid = new Solenoid(ElectricalLayout.GEAR_SOLENOID);
		gearMotor = new Talon(ElectricalLayout.GEAR_MOTOR);
		gearSensor = new DigitalInput(ElectricalLayout.GEAR_SENSOR);
	}

	public void haveGear() {
		if(!gearSensor.get()) {
			gearSpeed = -0.1;
		}
		else {
			gearSpeed = -1;
		}
	}
	
	public void placeGear() {
		ejecting = true;
		upDown = true;
		gearSpeed = 0.25;
	}
	
	public void gearUp() {
		ejecting = false;
		upDown = true;
	}
	
	public void gearDown() {
		ejecting = false;
		upDown = false;
	}
	
	public void stopMotor() {
		gearSpeed = 0;
	}
	
	public void update() {
		if(!ejecting) {
		haveGear();
		}
		gearSolenoid.set(upDown);
		gearMotor.set(gearSpeed);
	}

}
