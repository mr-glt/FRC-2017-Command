package org.usfirst.frc.team6027.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team6027.robot.commands.DriveDistance;
import org.usfirst.frc.team6027.robot.commands.RotateDriveTrain;

public class OI {
	private Joystick stick = new Joystick(0);
	private JoystickButton forward = new JoystickButton(stick,7);
	private JoystickButton backward = new JoystickButton(stick,8);

	public OI(){
		forward.whenPressed(new DriveDistance(40));
		backward.whenPressed(new RotateDriveTrain(180));
	}

	public Joystick getJoystick(){
		return stick;
	}
}
