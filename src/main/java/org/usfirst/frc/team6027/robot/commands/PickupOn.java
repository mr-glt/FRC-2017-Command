package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usfirst.frc.team6027.robot.Robot;

/**
 * A command to run the pickup forward to pickup balls. This can interrupted PickupReverse
 */
public class PickupOn extends Command{
    private Logger logger = LoggerFactory.getLogger(PickupOn.class);

    /**
     * Requires pickup
     */
    public PickupOn() {
        requires(Robot.pickup);
    }
    @Override
    protected void initialize() {
        logger.info("Pickup On");
    }

    /**
     * Pickup on
     */
    @Override
    protected void execute() {
        Robot.pickup.pickUp();
    }

    /**
     *
     * @return must ne interrupted
     */
    @Override
    protected boolean isFinished() {
        return false;
    }

    /**
     * Pickup off
     */
    @Override
    protected void end() {
        Robot.pickup.off();
        logger.info("Pickup off");
    }

    /**
     * Pickup off
     */
    @Override
    protected void interrupted() {
        Robot.pickup.off();
        logger.info("Pickup off");
    }
}
