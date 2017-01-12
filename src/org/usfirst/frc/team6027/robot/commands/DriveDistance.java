package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6027.robot.Robot;

public class DriveDistance extends Command {
    private double setpoint;
    public DriveDistance(double setpoint){
        this.setpoint = setpoint;
        requires(Robot.drivetrain);
    }
    @Override
    protected void initialize() {
        Robot.drivetrain.enable();
        Robot.drivetrain.setSetpoint(setpoint);
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return Robot.drivetrain.onTarget();
    }

    @Override
    protected void end() {
        Robot.drivetrain.disable();
    }

    @Override
    protected void interrupted() {
        Robot.drivetrain.disable();
    }
}
