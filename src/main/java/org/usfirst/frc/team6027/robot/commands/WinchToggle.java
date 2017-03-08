package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usfirst.frc.team6027.robot.Robot;

/**
 * Command to toggle the winch cylinder. On activation, this command sets the cylinder to out. On interrupt it sets it to in.
 */
public class WinchToggle extends Command {
    private Logger logger = LoggerFactory.getLogger(WinchToggle.class);

    /**
     * Requires WinchPush
     */
    public WinchToggle(){
        requires(Robot.winchPush);
    }
    @Override
    protected void initialize() {
        logger.debug("Winch closed");
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
    	logger.debug("Winch opened");
    }
    @Override
    protected void interrupted() {
    	Robot.winchPush.setLock(false);
    	logger.debug("Winch opened");
    }
}
