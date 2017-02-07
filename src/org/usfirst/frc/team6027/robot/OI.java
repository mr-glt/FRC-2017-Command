package org.usfirst.frc.team6027.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team6027.robot.commands.RotateDriveTrain;

public class OI {
	private Joystick stick = new Joystick(RobotMap.joystickPort);
	private Joystick controller = new Joystick(RobotMap.controllerPort);
	private DigitalInput winchLimit = new DigitalInput(RobotMap.winchLimitPort);

	public OI(){
		JoystickButton aim = new JoystickButton(stick, 5);
		JoystickButton trigger = new JoystickButton(stick, 7);
		aim.whenPressed(new RotateDriveTrain(Robot.vision.getTurn()*0.1875));
		trigger.whenPressed(new RotateDriveTrain(-30));

	}
	public Joystick getJoystick(){
		return stick;
	}
	public Joystick getController(){
		return controller;
	}
	public DigitalInput getWinchLimit(){
		return winchLimit;
	}
}
