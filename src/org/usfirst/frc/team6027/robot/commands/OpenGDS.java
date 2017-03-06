package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6027.robot.Robot;

public class OpenGDS extends Command{
    public OpenGDS(double timeout) {
        requires(Robot.gds);
        setTimeout(timeout);
        System.out.println("GDS is opening for " + timeout + " seconds");
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
        return isTimedOut();
    }

    @Override
    protected void end() {
    	Robot.gds.close();
    	System.out.println("Finished GDS cycle");
    }

    @Override
    protected void interrupted() {
    	Robot.gds.close();
    	System.out.println("Interrupted GDS cycle");
    }
}
