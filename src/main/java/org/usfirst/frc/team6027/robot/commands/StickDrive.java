package org.usfirst.frc.team6027.robot.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usfirst.frc.team6027.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StickDrive extends Command {
    private Logger logger = LoggerFactory.getLogger(StickDrive.class);
    public StickDrive() {
    	requires(Robot.drivetrain);
    }

    protected void initialize() {
        logger.debug("Using stick drive");
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
        logger.debug("Stick drive interrupted");
    }
}
