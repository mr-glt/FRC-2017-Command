package org.usfirst.frc.team6027.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
	private Joystick stick = new Joystick(0);
	public OI(){
		
	}
	public Joystick getJoystick(){
		return stick;
	}
}
