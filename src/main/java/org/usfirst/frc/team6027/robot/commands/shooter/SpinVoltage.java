package org.usfirst.frc.team6027.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usfirst.frc.team6027.robot.Robot;

public class SpinVoltage extends Command {
    private double voltage;
    private boolean timed;
    private Logger logger = LoggerFactory.getLogger(SpinVoltage.class);
    public SpinVoltage(double voltage, boolean timed){
        this.voltage = voltage;
        this.timed = timed;
        requires(Robot.flywheel);
        requires(Robot.meter);
        System.out.println("Spinning shooter to " + voltage + "% Timed: " + timed);
    }
    @Override
    protected void initialize() {
        setTimeout(3);
        logger.debug("Spinning shooter to " + voltage + "% Timed: "+ timed);
    }

    @Override
    protected void execute() {
        Robot.flywheel.setFlywheelVoltage(voltage, false);
        Robot.meter.spinMeterUp();
    }

    @Override
    protected boolean isFinished() {
        if (timed){
            return isTimedOut();
        }else{
            return false;
        }
    }

    @Override
    protected void end() {
        Robot.flywheel.stopFlywheel();
        Robot.meter.spinMeterDown();
        logger.debug("Spinning shooter down");
    }

    @Override
    protected void interrupted() {
        Robot.flywheel.stopFlywheel();
        Robot.meter.spinMeterDown();
        logger.debug("Shooter interrupted");
    }
}
