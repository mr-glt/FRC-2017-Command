package org.usfirst.frc.team6027.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6027.robot.Robot;

public class SpinVoltage extends Command {
    private double voltage;
    private boolean timed;
    public SpinVoltage(double voltage, boolean timed){
        this.voltage = voltage;
        this.timed = timed;
        requires(Robot.flywheel);
        requires(Robot.meter);
    }
    @Override
    protected void initialize() {
        setTimeout(3);
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
    }

    @Override
    protected void interrupted() {
        Robot.flywheel.stopFlywheel();
        Robot.meter.spinMeterDown();
    }
}
