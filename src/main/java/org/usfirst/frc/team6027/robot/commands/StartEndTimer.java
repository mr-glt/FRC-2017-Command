package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6027.robot.Robot;

public class StartEndTimer extends Command {
    public StartEndTimer(){
        requires(Robot.fieldTimer);
    }
    @Override
    protected void initialize() {
    }
    @Override
    protected void execute() {
        Robot.fieldTimer.endTimer();
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
