
package org.usfirst.frc.team6027.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.slf4j.LoggerFactory;
import org.usfirst.frc.team6027.robot.commands.StartEndTimer;
import org.usfirst.frc.team6027.robot.commands.StopEndTimer;
import org.usfirst.frc.team6027.robot.subsystems.*;
import org.usfirst.frc.team6027.robot.commands.auto.*;
import org.slf4j.Logger;

/**
 * Team 6027's 2017 Code
 * @author Charlie Wade
 * @version Post-Build
 */
public class Robot extends IterativeRobot {

	public static DriveTrain drivetrain;
	public static DriveEncoders driveEncoders;
	public static Ultrasonic ultrasonic;
	public static Gyro gyro;
	public static Vision vision;
	public static GDS gds;
	public static Pickup pickup;
	public static Flywheel flywheel;
	public static Meter meter;
	public static Winch winch;
	public static WinchPush winchPush;
	public static FieldTimer fieldTimer;
	public static OI oi;
	private final String forwardAuto = "Forward Drive";
	private final String centerGearAuto = "Center Gear Blue";
	private final String leftGearAuto = "Left Gear";
	private final String rightGearAuto = "Right Gear";
	private final String boilerAuto = "Boiler Red";
	private final String noAuto = "No Auto";
	private final String centerGearOnlyAuto = "Center Gear Only";
	private final String boilerAutoBlue = "Boiler Blue";
	private final String centerGearRed = "Center Gear Red";
	private SendableChooser<String> chooser;

	private CommandGroup autonomousCommandGroup;
	private Command endTimer;
	private Command stopTimers;
	private Logger logger;
	@Override
	public void robotInit() {
		logger = LoggerFactory.getLogger(Robot.class);
		logger.info("Initializing Robot");
		drivetrain = new DriveTrain();
		driveEncoders = new DriveEncoders(RobotMap.leftEncoderA,RobotMap.leftEncoderB,RobotMap.rightEncoderA, RobotMap.rightEncoderB,
				RobotMap.encoderMaxPeriod, RobotMap.encoderMinRate, RobotMap.encoderDPP,RobotMap.encoderReverseDirection,RobotMap.encoderSamplesToAvg);
		ultrasonic = new Ultrasonic(RobotMap.valueToInches,RobotMap.ultrasonicPort);
		gyro = new Gyro();
		vision = new Vision();
		gds = new GDS();
		pickup = new Pickup();
		flywheel = new Flywheel();
		meter = new Meter();
		winch = new Winch();
		winchPush = new WinchPush();
		fieldTimer = new FieldTimer();
		oi = new OI();

		chooser = new SendableChooser<>();
		endTimer = new StartEndTimer();
		stopTimers = new StopEndTimer();

		vision.setUpCamera();
		SmartDashboard.putData(drivetrain);
		chooser.addDefault("None", noAuto);
		chooser.addObject("Forward Drive", forwardAuto);
		chooser.addObject("Center Gear Blue", centerGearAuto);
		chooser.addObject("Left Gear", leftGearAuto);
		chooser.addObject("Right Gear", rightGearAuto);
		chooser.addObject("Boiler Red", boilerAuto);
		chooser.addObject("Center Gear Only",centerGearOnlyAuto);
		chooser.addObject("Boiler Blue", boilerAutoBlue);
		chooser.addObject("Center Gear Red", centerGearRed);
		SmartDashboard.putData("Auto choices", chooser);
		Compressor c = new Compressor(10);
		c.setClosedLoopControl(true);
	}

	@Override
	public void disabledInit() {
		logger.info("Robot disabled");
		stopTimers.start();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		String autoSelected = chooser.getSelected();
		logger.info("Stating new auto run:" + autoSelected);
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
			case centerGearOnlyAuto:
				autonomousCommandGroup = new CenterGearOnly();
				break;
			case boilerAutoBlue:
				autonomousCommandGroup = new BoilerBlue();
				break;
			case centerGearRed:
				autonomousCommandGroup = new CenterGearRed();
			case noAuto:
			default:
				autonomousCommandGroup = new NoAuto();
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
		logger.info("Autonomous ended");
		logger.info("Teleop started");
		if(autonomousCommandGroup!=null) autonomousCommandGroup.cancel();
		endTimer.start();
	}
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
	}
}
