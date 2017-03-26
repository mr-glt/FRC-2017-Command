package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6027.robot.Robot;

/**
 * This single action command command ends timers in the timer subsystem at the end of the match.
 */
public class StopEndTimer extends Command {
    /**
     * Requires FieldTimer
     */
    public StopEndTimer(){
        requires(Robot.fieldTimer);
    }
    @Override
    protected void initialize() {
    }
    @Override
    protected void execute() {
        Robot.fieldTimer.stopTimers();
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
