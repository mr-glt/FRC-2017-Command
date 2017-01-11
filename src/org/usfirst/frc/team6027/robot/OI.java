package org.usfirst.frc.team6027.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team6027.robot.commands.Aim;

public class OI {
	private Joystick stick = new Joystick(0);
	Button trigger = new JoystickButton(stick, 1);
	public OI(){
		trigger.whenActive(new Aim());
	}
	public Joystick getJoystick(){
		return stick;
	}
}
