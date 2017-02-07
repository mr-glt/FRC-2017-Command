package org.usfirst.frc.team6027.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6027.robot.Robot;

public class EngageDeflector extends Command {
    public EngageDeflector(){
        requires(Robot.deflector);
    }
    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.deflector.engaged();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.deflector.disengaged();
    }

    @Override
    protected void interrupted() {
        Robot.deflector.disengaged();
    }
}
