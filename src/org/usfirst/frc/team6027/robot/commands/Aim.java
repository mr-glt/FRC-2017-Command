package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6027.robot.Robot;

public class Aim extends Command {
    public Aim() {
        requires(Robot.vision);
        requires(Robot.drivetrain);
    }
    @Override
    protected void initialize() {
        Robot.vision.setAnalyzeExposure();
    }

    @Override
    protected void execute() {
    	new RotateDriveTrain(Robot.vision.getTurn());
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        Robot.drivetrain.arcadeDrive(0,0);
        Robot.vision.setRegularExposure();
    }

    @Override
    protected void interrupted() {
    }
}
