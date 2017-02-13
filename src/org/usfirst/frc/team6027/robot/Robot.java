
package org.usfirst.frc.team6027.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6027.robot.commands.Autonomous;
import org.usfirst.frc.team6027.robot.subsystems.*;
import org.usfirst.frc.team6027.robot.commands.auto.*;

public class Robot extends IterativeRobot {

	public static DriveTrain drivetrain = new DriveTrain();
	public static DriveEncoders driveEncoders = new DriveEncoders(RobotMap.leftEncoderA,RobotMap.leftEncoderB,RobotMap.rightEncoderA, RobotMap.rightEncoderB,
			RobotMap.encoderMaxPeriod, RobotMap.encoderMinRate, RobotMap.encoderDPP,RobotMap.encoderReverseDirection,RobotMap.encoderSamplesToAvg);
	public static Ultrasonic ultrasonic = new Ultrasonic(RobotMap.valueToInches,RobotMap.ultrasonicPort);
	public static Gyro gyro = new Gyro();
	public static Vision vision = new Vision();
	public static GDS gds = new GDS();
	public static Pickup pickup = new Pickup();
	public static Flywheel flywheel = new Flywheel();
	public static Meter meter = new Meter();
	public static Winch winch = new Winch();
	public static OI oi = new OI();
	private final String forwardAuto = "Forward Drive";
	private final String centerGearAuto = "Center Gear";
	private final String leftGearAuto = "Left Gear";
	private final String rightGearAuto = "Right Gear";
	private final String boilerAuto = "Boiler";
	private SendableChooser<String> chooser = new SendableChooser<>();

	private CommandGroup autonomousCommandGroup;

	@Override
	public void robotInit() {
		vision.setUpCamera();
		vision.startProcessing();
		SmartDashboard.putData(drivetrain);
		chooser.addDefault("Forward Drive", forwardAuto);
		chooser.addObject("Center Gear", centerGearAuto);
		chooser.addObject("Left Gear", leftGearAuto);
		chooser.addObject("Right Gear", rightGearAuto);
		chooser.addObject("Boiler", boilerAuto);
		SmartDashboard.putData("Auto choices", chooser);
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		String autoSelected = chooser.getSelected();
		System.out.println("Auto selected: " + autoSelected);
		switch (autoSelected) {
			case centerGearAuto:
				autonomousCommandGroup = new CenterGear();
				break;
			case leftGearAuto:
				autonomousCommandGroup = new LeftGear();
				break;
			case rightGearAuto:
				autonomousCommandGroup = new RightGear();
				break;
			case boilerAuto:
				autonomousCommandGroup = new Boiler();
				break;
			case forwardAuto:
			default:
				autonomousCommandGroup = new Forward();
				break;
		}
 		autonomousCommandGroup.start();

	}
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		autonomousCommandGroup.cancel();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
