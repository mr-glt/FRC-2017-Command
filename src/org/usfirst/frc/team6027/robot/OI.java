package org.usfirst.frc.team6027.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team6027.robot.commands.DriveDistance;

public class OI {
	private Joystick stick = new Joystick(0);
	private JoystickButton trigger = new JoystickButton(stick,7);
	private AnalogInput ultrasonic = new AnalogInput(0);
	private ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	private Encoder driveEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);

	public OI(){
		trigger.whileHeld(new DriveDistance(10));
	}
	public Joystick getJoystick(){
		return stick;
	}
	public AnalogInput getUltrasonic(){
		return ultrasonic;
	}
	public ADXRS450_Gyro getGyro(){
		return gyro;
	}
	public Encoder getDriveEncoder(){
		return driveEncoder;
	}
}
