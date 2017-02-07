package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6027.robot.Robot;

public class Climb extends Command{
    public Climb(){
        requires(Robot.winch);
    }
    @Override
    protected void initialize() {
        Robot.winch.breakMode(false);
    }

    @Override
    protected void execute() {
        Robot.winch.on();
    }

    @Override
    protected boolean isFinished() {
        return Robot.oi.getWinchLimit().get();
    }

    @Override
    protected void end() {
        Robot.winch.breakMode(true);
    }


    @Override
    protected void interrupted() {
        Robot.winch.breakMode(true);
    }
}
