package org.usfirst.frc.team6027.robot.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usfirst.frc.team6027.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Default command to drive the robot with joysticks. It may be overridden during autonomous mode to run drive sequence. This command grabs
 * the left and right joysticks on an XBox controller and sets them to arcade drive.
 */
public class StickDrive extends Command {
    private Logger logger = LoggerFactory.getLogger(StickDrive.class);

    /**
     * Requires DriveTrain
     */
    public StickDrive() {
    	requires(Robot.drivetrain);
    }

    protected void initialize() {
        logger.info("Using stick drive");
    }

    protected void execute() {
    	Robot.drivetrain.arcadeDrive(-Robot.oi.getController().getRawAxis(1), -Robot.oi.getController().getRawAxis(4));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.drivetrain.arcadeDrive(0, 0);
    }

    protected void interrupted() {
        logger.info("Stick drive interrupted");
    }
}
