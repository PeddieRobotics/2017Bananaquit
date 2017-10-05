package org.usfirst.frc.team5895.robot;

import org.usfirst.frc.team5895.robot.framework.Waiter;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DigitalInput;

public class GearReceiver {

	private Solenoid solenoid;
	private Talon m1;
	private DigitalInput sensor;
	private boolean haveGear;
	private boolean autoUp;


	public GearReceiver() {
		solenoid = new Solenoid(ElectricalLayout.GEAR_SOLENOID);
		m1 = new Talon(ElectricalLayout.GEAR_MOTOR);
		sensor = new DigitalInput(ElectricalLayout.GEAR_SENSOR);
	}

	public void haveGear() {
		if(sensor.get()== true) {
			haveGear = true;
			m1.set(0.1);
		}
		else {
			haveGear = false;
			m1.set(1);
		}
	}
	
	public void pushGear() {
		if(haveGear == true) {
			m1.set(-1);
		}
	}
	
	public void gearUp() {
		haveGear = true;
		autoUp = false;
	}
	
	public void gearDown() {
		haveGear = false;
		autoUp = false;
	}
	
	public void autoUp() {
		autoUp = true;
	}
	
	public void stopMotor() {
		m1.set(0);
	}
	
	public void update() {
		if(autoUp == true) {
			haveGear();
		}
		solenoid.set(haveGear);
	}

}
