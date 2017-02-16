package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6027.robot.Robot;

public class WinchClose extends Command {
    public WinchClose(){
        requires(Robot.winch);
    }
    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.winch.setLock(true);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
    }


    @Override
    protected void interrupted() {
    }
}
