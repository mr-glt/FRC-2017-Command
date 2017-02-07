package org.usfirst.frc.team6027.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team6027.robot.commands.Aim;

import org.usfirst.frc.team6027.robot.commands.DriveDistance;
import org.usfirst.frc.team6027.robot.commands.RotateDriveTrain;

public class OI {
	private Joystick stick = new Joystick(RobotMap.joystickPort);
	private Joystick controller = new Joystick(RobotMap.controllerPort);
	public OI(){
		JoystickButton aim = new JoystickButton(stick, 5);
		aim.whenPressed(new RotateDriveTrain(Robot.vision.getTurn()*0.1875));
		JoystickButton trigger = new JoystickButton(stick, 7);
		trigger.whenPressed(new RotateDriveTrain(-30));
	}
	public Joystick getJoystick(){
		return stick;
	}
	public Joystick getController(){
		return controller;
	}
}
