package org.usfirst.frc.team6027.robot.commands;

import org.usfirst.frc.team6027.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GetGyro extends Command {

    public GetGyro() {
    	requires(Robot.gyro);
    }

    protected void initialize() {
    	Robot.gyro.calibrateGyro();
    }
    
    protected void execute() {
    	Robot.gyro.displayGyro();
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }

    protected void interrupted() {
    }
}
