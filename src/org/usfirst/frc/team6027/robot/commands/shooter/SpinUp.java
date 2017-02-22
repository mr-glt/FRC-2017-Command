package org.usfirst.frc.team6027.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6027.robot.Robot;

public class SpinUp extends Command {
    private double voltage;
    public SpinUp(double voltage){
        this.voltage = voltage;
        requires(Robot.flywheel);
    }
    @Override
    protected void initialize() {
        setTimeout(2);
    }

    @Override
    protected void execute() {
        Robot.flywheel.setFlywheelVoltage(voltage, false);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}
