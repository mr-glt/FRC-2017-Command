package org.usfirst.frc.team6027.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6027.robot.Robot;

public class SpinMeter extends Command{
    public SpinMeter(){
        requires(Robot.meter);
    }
    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.meter.spinMeterUp();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.meter.spinMeterDown();
    }

    @Override
    protected void interrupted() {
        Robot.meter.spinMeterDown();
    }
}
