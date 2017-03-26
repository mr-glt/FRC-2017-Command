package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6027.robot.Robot;

/**
 * This single action command command starts timers in the timer subsystem at the start of the match.
 */
public class StartEndTimer extends Command {
    /**
     * Requires FieldTimer
     */
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
