package org.usfirst.frc.team6027.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team6027.robot.commands.Aim;
import org.usfirst.frc.team6027.robot.commands.DriveDistance;
import org.usfirst.frc.team6027.robot.commands.RotateDriveTrain;

public class OI {
	private Joystick stick = new Joystick(0);
	Button aim = new JoystickButton(stick, 5);
	private JoystickButton trigger = new JoystickButton(stick,7);

	public OI(){
		aim.whenPressed(new RotateDriveTrain(Robot.vision.getTurn()*0.1875));
		trigger.whenPressed(new RotateDriveTrain(-30));
	}

	public Joystick getJoystick(){
		return stick;
	}
}
