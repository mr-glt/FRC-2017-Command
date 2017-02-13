package org.usfirst.frc.team6027.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team6027.robot.commands.*;

public class OI {
	private Joystick controller = new Joystick(RobotMap.controllerPort);
	private DigitalInput winchLimit = new DigitalInput(RobotMap.winchLimitPort);

	public OI(){
		JoystickButton x = new JoystickButton(controller, 3);
		JoystickButton y = new JoystickButton(controller, 4);
		JoystickButton a = new JoystickButton(controller, 1);
		JoystickButton b = new JoystickButton(controller, 2);
		JoystickButton rb = new JoystickButton(controller, 6);
		JoystickButton lb = new JoystickButton(controller, 5);

		a.toggleWhenPressed(new PickupOn());
		b.whileHeld(new PickupReverse());
		y.whileHeld(new OpenGDS());
		x.whenPressed(new Climb());
		rb.whileHeld(new Shoot());

	}
	public Joystick getController(){
		return controller;
	}
	public DigitalInput getWinchLimit(){
		return winchLimit;
	}
}
