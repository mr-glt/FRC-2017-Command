package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6027.robot.Robot;

public class DistanceDIsplay extends Command {
    public DistanceDIsplay() {
		requires(Robot.driveEncoders);
    }
    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
    	SmartDashboard.putNumber("Distance", Robot.driveEncoders.getLeftDistance());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}
