package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6027.robot.Robot;

public class Aim extends Command {
    public Aim() {
        requires(Robot.vision);
    }
    @Override
    protected void initialize() {
        Robot.vision.startProcessing();
    }

    @Override
    protected void execute() {
        Robot.drivetrain.drive(0, Robot.vision.getTurn()*0.005);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.drivetrain.drive(0, 0);
    }

    @Override
    protected void interrupted() {
    }
}
