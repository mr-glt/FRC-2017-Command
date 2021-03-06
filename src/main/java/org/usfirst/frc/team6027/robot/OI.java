package org.usfirst.frc.team6027.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team6027.robot.commands.*;
import org.usfirst.frc.team6027.robot.commands.shooter.SpinVoltage;

public class OI {
	private Joystick controller = new Joystick(RobotMap.controllerPort);

	public OI(){
		JoystickButton x = new JoystickButton(controller, 3);
		JoystickButton y = new JoystickButton(controller, 4);
		JoystickButton a = new JoystickButton(controller, 1);
		JoystickButton b = new JoystickButton(controller, 2);
		JoystickButton rb = new JoystickButton(controller, 6);
		JoystickButton lb = new JoystickButton(controller, 5);
		JoystickButton start = new JoystickButton(controller, 8);
		JoystickButton back = new JoystickButton(controller,7);

		a.whileHeld(new PickupOn());
		b.whileHeld(new PickupReverse());
		y.whileHeld(new OpenGDS(5));
		x.whileHeld(new Climb());
		rb.whileHeld(new SpinVoltage(0.80, false));
		start.toggleWhenPressed(new ResetWinch());
		lb.whileHeld(new InvertedStickDrive());
	}
	public Joystick getController(){
		return controller;
	}
}
