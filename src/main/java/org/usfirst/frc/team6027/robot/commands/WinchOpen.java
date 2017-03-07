package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6027.robot.Robot;

public class WinchOpen extends Command {
    public WinchOpen(){
        requires(Robot.winchPush);
    }
    @Override
    protected void initialize() {
    }
    @Override
    protected void execute() {
        Robot.winchPush.setLock(false);
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
