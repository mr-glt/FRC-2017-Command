package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6027.robot.Robot;

public class WinchClose extends Command {
    public WinchClose(){
        requires(Robot.winchPush);
    }
    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.winchPush.setLock(true);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    	Robot.winchPush.setLock(false);
    }


    @Override
    protected void interrupted() {
    	Robot.winchPush.setLock(false);
    }
}
