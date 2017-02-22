package org.usfirst.frc.team6027.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6027.robot.Robot;

public class SpinVoltage extends Command {
    private double voltage;
    public SpinVoltage(double voltage){
        this.voltage = voltage;
        requires(Robot.flywheel);
        requires(Robot.meter);
    }
    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.flywheel.setFlywheelVoltage(voltage, false);
        Robot.meter.spinMeterUp();
    }

    @Override
    protected boolean isFinished() {
        return false;
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
