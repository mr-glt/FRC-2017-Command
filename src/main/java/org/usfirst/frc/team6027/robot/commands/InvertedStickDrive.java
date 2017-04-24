package org.usfirst.frc.team6027.robot.commands;

import org.usfirst.frc.team6027.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * A command to drive the robot to the controller backwards and slower for gear delivery.
 */
public class InvertedStickDrive extends Command {
    /**
     * Requires drive train
     */
    public InvertedStickDrive() {
    	requires(Robot.drivetrain);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.drivetrain.arcadeDrive(Robot.oi.getController().getRawAxis(1)*0.65, -Robot.oi.getController().getRawAxis(4)*0.80);
    }

    /**
     *
     * @return must be interrupted
     */
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.drivetrain.arcadeDrive(0, 0);
    }

    protected void interrupted() {
    	Robot.drivetrain.arcadeDrive(0,0);
    }
}
