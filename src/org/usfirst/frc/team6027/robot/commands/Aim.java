package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6027.robot.Robot;

public class Aim extends Command {
    public Aim() {
        requires(Robot.vision);
    }
    @Override
    protected void initialize() {
        
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
    }

    @Override
    protected void interrupted() {
    }
}
