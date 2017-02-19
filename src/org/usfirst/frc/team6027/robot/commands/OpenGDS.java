package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6027.robot.Robot;

public class OpenGDS extends Command{
    public OpenGDS() {
        requires(Robot.gds);
    }
    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.gds.open();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    	Robot.gds.close();
    }

    @Override
    protected void interrupted() {
    	Robot.gds.close();
    }
}
