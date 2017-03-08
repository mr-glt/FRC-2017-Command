package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usfirst.frc.team6027.robot.Robot;

/**
 * A command to run the pickup in reverse to free balls. This can interrupt PickupOn.
 */
public class PickupReverse extends Command{
    private Logger logger = LoggerFactory.getLogger(PickupReverse.class);

    /**
     * Requires Pickup
     */
    public PickupReverse() {
        requires(Robot.pickup);
    }
    @Override
    protected void initialize() {
        logger.debug("Pickup reversed");
    }

    /**
     * Run pickup in reverse
     */
    @Override
    protected void execute() {
        Robot.pickup.reverse();
    }

    /**
     *
     * @return must be interrupted
     */
    @Override
    protected boolean isFinished() {
        return false;
    }

    /**
     * Stop pickup
     */
    @Override
    protected void end() {
        Robot.pickup.off();
        logger.debug("Pickup off");
    }

    /**
     * Stop pickup
     */
    @Override
    protected void interrupted() {
        Robot.pickup.off();
        logger.debug("Pickup off");
    }
}
