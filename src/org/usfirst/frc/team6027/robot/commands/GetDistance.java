package org.usfirst.frc.team6027.robot.commands;

import org.usfirst.frc.team6027.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GetDistance extends Command {

    public GetDistance() {
    	requires(Robot.ultrasonic);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.ultrasonic.displayDistance();
	}

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
