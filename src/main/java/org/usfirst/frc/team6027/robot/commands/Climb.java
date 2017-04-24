package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usfirst.frc.team6027.robot.Robot;

/**
 * A command to run the winch drum and stop the reminder.
 */
public class Climb extends Command{
    private Logger logger = LoggerFactory.getLogger(Climb.class);

    /**
     * Requires winch, FieldTimer
     */
    public Climb(){
        requires(Robot.winch);
        requires(Robot.fieldTimer);
        requires(Robot.winchPush);
    }
    @Override
    protected void initialize() {
        logger.info("WinchToggle on");
        SmartDashboard.putBoolean("Winch Ready", false);
    }

    @Override
    protected void execute() {
        Robot.fieldTimer.stopRumble();
    	Robot.winch.on();
    	Robot.winchPush.setLock(false);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.winch.off();
        logger.info("WinchToggle off");
    }


    @Override
    protected void interrupted() {
        Robot.winch.off();
        logger.info("WinchToggle off");
    }
}
