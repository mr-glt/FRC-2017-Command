package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6027.robot.Robot;

public class GetDistanceEncoder extends Command {
    public GetDistanceEncoder(){
        requires(Robot.driveEncoders);
    }
    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.driveEncoders.distanceDriven();
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
