package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usfirst.frc.team6027.robot.Robot;

/**
 * A command to open and close the Gear Delivery System. Issuing this command opens, interrupting or timing out closes.
 */
public class OpenGDS extends Command{
    private Logger logger = LoggerFactory.getLogger(OpenGDS.class);
    private double timeout=0;

    /**
     *
     * @param timeout time in seconds till the command is ended
     */
    public OpenGDS(double timeout) {
        requires(Robot.gds);
        this.timeout=timeout;
        setTimeout(timeout);
    }
    @Override
    protected void initialize() {
        logger.debug("GDS is opening for" + timeout + " seconds");
    }

    /**
     * Open GDS
     */
    @Override
    protected void execute() {
        Robot.gds.open();
    }

    /**
     *
     * @return if timed out
     */
    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    /**
     * Close GDS
     */
    @Override
    protected void end() {
    	Robot.gds.close();
        logger.debug("Finished GDS cycle");
    }

    /**
     * Close GDS
     */
    @Override
    protected void interrupted() {
    	Robot.gds.close();
        logger.debug("Finished GDS cycle");
    }
}
