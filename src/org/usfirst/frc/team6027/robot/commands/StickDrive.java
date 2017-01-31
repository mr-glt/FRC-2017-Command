package org.usfirst.frc.team6027.robot.commands;

import org.usfirst.frc.team6027.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StickDrive extends Command {

    public StickDrive() {
    	requires(Robot.drivetrain);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.drivetrain.arcadeDrive(Robot.oi.getJoystick());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.drivetrain.arcadeDrive(0, 0);
    }

    protected void interrupted() {
    }
}
