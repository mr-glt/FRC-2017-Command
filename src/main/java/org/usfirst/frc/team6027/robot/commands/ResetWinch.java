package org.usfirst.frc.team6027.robot.commands;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usfirst.frc.team6027.robot.Robot;
import org.usfirst.frc.team6027.robot.RobotMap;

/**
 * A command to reset the position of the winch drum and cylinder to start when issued.
 */
public class ResetWinch extends Command{
    private Logger logger = LoggerFactory.getLogger(ResetWinch.class);

    /**
     * Requires Winch, WinchPush
     */
    public ResetWinch() {
        requires(Robot.winch);
        requires(Robot.winchPush);
    }
    @Override
    protected void initialize() {
        Robot.winch.initializeCounter();
        logger.debug("Resetting Winch");
    }

    /**
     * Start rotating the winch
     */
    @Override
    protected void execute() {
        Robot.winch.on();
        Robot.winchPush.setLock(false);
        SmartDashboard.putString("Reset", "true");
    }

    /**
     *
     * @return whether the limit switch is activated on the drum
     */
    @Override
    protected boolean isFinished() {
        return Robot.winch.isSwitchSet();
    }

    /**
     * Stop rotating the winch
     */
    @Override
    protected void end() {
        Robot.winch.off();
        logger.debug("Winch reset");
        SmartDashboard.putString("Reset", "false");

    }

    /**
     * Stop rotating the winch
     */
    @Override
    protected void interrupted() {
        SmartDashboard.putString("Reset", "false");
        Robot.winch.off();
        logger.debug("Winch reset interrupted");
    }
}
