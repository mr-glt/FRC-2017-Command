package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6027.robot.Robot;

public class PickupOn extends Command{
    public PickupOn() {
        requires(Robot.pickup);
    }
    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.pickup.pickUp();
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
