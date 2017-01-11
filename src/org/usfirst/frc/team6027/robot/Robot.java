
package org.usfirst.frc.team6027.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team6027.robot.subsystems.DriveTrain;
import org.usfirst.frc.team6027.robot.subsystems.Gyro;
import org.usfirst.frc.team6027.robot.subsystems.Ultrasonic;
import org.usfirst.frc.team6027.robot.subsystems.Vision;

public class Robot extends IterativeRobot {

	public static DriveTrain drivetrain = new DriveTrain();
	public static Ultrasonic ultrasonic = new Ultrasonic();
	public static Gyro gyro = new Gyro();
	public static Vision vision = new Vision();
	public static OI oi = new OI();
	
	Command StickCommand;

	@Override
	public void robotInit() {
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
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
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
