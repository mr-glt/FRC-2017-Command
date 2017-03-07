package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usfirst.frc.team6027.robot.Robot;

public class PickupReverse extends Command{
    private Logger logger = LoggerFactory.getLogger(PickupReverse.class);
    public PickupReverse() {
        requires(Robot.pickup);
    }
    @Override
    protected void initialize() {
        logger.debug("Pickup reversed");
    }

    @Override
    protected void execute() {
        Robot.pickup.reverse();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.pickup.off();
        logger.debug("Pickup off");
    }

    @Override
    protected void interrupted() {
        Robot.pickup.off();
        logger.debug("Pickup off");
    }
}
