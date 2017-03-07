package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6027.robot.Robot;

public class Climb extends Command{
    public Climb(){
        requires(Robot.winch);
        requires(Robot.fieldTimer);
    }
    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.fieldTimer.stopRumble();
    	Robot.winch.on();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.winch.off();
    }


    @Override
    protected void interrupted() {
        Robot.winch.off();
    }
}
