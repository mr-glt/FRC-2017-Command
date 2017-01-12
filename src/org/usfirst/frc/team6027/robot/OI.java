package org.usfirst.frc.team6027.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team6027.robot.commands.DriveDistance;

public class OI {
	private Joystick stick = new Joystick(0);
	private JoystickButton trigger = new JoystickButton(stick,0);
	public OI(){
		trigger.whenActive(new DriveDistance(10));
	}
	public Joystick getJoystick(){
		return stick;
	}
}
