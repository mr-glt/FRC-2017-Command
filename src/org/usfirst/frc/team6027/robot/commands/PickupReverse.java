package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6027.robot.Robot;

public class PickupReverse extends Command{
    public PickupReverse() {
        requires(Robot.pickup);
    }
    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.pickup.reverse();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.pickup.off();
    }

    @Override
    protected void interrupted() {
        Robot.pickup.off();
    }
}
