package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usfirst.frc.team6027.robot.Robot;

public class OpenGDS extends Command{
    private Logger logger = LoggerFactory.getLogger(OpenGDS.class);
    private double timeout=0;
    public OpenGDS(double timeout) {
        requires(Robot.gds);
        this.timeout=timeout;
        setTimeout(timeout);
    }
    @Override
    protected void initialize() {
        logger.debug("GDS is opening for" + timeout + " seconds");
    }

    @Override
    protected void execute() {
        Robot.gds.open();
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
    	Robot.gds.close();
        logger.debug("Finished GDS cycle");
    }

    @Override
    protected void interrupted() {
    	Robot.gds.close();
        logger.debug("Finished GDS cycle");
    }
}
