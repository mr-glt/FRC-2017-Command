package org.usfirst.frc.team6027.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usfirst.frc.team6027.robot.Robot;

/**
 * A command to spin the shooter and meter to a specific voltage.
 */
public class SpinVoltage extends Command {
    private double voltage;
    private boolean timed;
    private Logger logger = LoggerFactory.getLogger(SpinVoltage.class);

    /**
     * Requires flywheel, meter
     * @param voltage percent power to spin shooter
     * @param timed if the command in timed out after 3 seconds
     */
    public SpinVoltage(double voltage, boolean timed){
        this.voltage = voltage;
        this.timed = timed;
        requires(Robot.flywheel);
        requires(Robot.meter);
    }
    @Override
    protected void initialize() {
        setTimeout(3);
        logger.info("Spinning shooter to " + voltage + "% Timed: "+ timed);
    }

    @Override
    protected void execute() {
        Robot.flywheel.setFlywheelVoltage(voltage, false);
        Robot.meter.spinMeterUp();
    }

    /**
     *
     * @return must be interrupted or timed out
     */
    @Override
    protected boolean isFinished() {
        if (timed){
            return isTimedOut();
        }else{
            return false;
        }
    }

    /**
     * Stop spinning
     */
    @Override
    protected void end() {
        Robot.flywheel.stopFlywheel();
        Robot.meter.spinMeterDown();
        logger.info("Spinning shooter down");
    }

    /**
     * Stop spinning
     */
    @Override
    protected void interrupted() {
        Robot.flywheel.stopFlywheel();
        Robot.meter.spinMeterDown();
        logger.info("Shooter interrupted");
    }
}
