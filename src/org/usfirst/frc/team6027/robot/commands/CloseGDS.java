package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6027.robot.Robot;

public class CloseGDS extends Command{
    public CloseGDS() {
        requires(Robot.gds);
    }
    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.gds.close();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}
