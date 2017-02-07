
package org.usfirst.frc.team6027.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6027.robot.commands.Autonomous;
import org.usfirst.frc.team6027.robot.subsystems.*;

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
	public static Deflector deflector = new Deflector();
	public static OI oi = new OI();

	Command autonomousCommand;

	@Override
	public void robotInit() {
		vision.setUpCamera();
		vision.startProcessing();
		autonomousCommand = new Autonomous();
		SmartDashboard.putData(drivetrain);
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
		autonomousCommand.start();
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		autonomousCommand.cancel();
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
