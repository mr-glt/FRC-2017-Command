package org.usfirst.frc.team6027.robot.commands;

import org.usfirst.frc.team6027.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class InvertedStickDrive extends Command {

    public InvertedStickDrive() {
    	requires(Robot.drivetrain);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.drivetrain.arcadeDrive(Robot.oi.getController().getRawAxis(1)*0.6, -Robot.oi.getController().getRawAxis(4)*0.75);
    }

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
