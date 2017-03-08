package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6027.robot.Robot;

/**
 * A command to run indicators for ultrasonic and encoders when they are not being used.
 */
public class Indicators extends Command{
    /**
     * Requires ultrasonic, drive encoders
     */
    public Indicators() {
        requires(Robot.ultrasonic);
        requires(Robot.driveEncoders);
    }
    @Override
    protected void initialize() {

    }

    /**
     * Displays bools for in range for gears and shooting.
     */
    @Override
    protected void execute() {
        //Todo update these values
        if(Robot.ultrasonic.getDistance()<=12){
            SmartDashboard.putBoolean("Gear Distance", true);
            SmartDashboard.putBoolean("Shooter Distance", false);
        }else if(Robot.ultrasonic.getDistance()<= 80 && Robot.ultrasonic.getDistance() >= 60){
            SmartDashboard.putBoolean("Shooter Distance", true);
            SmartDashboard.putBoolean("Gear Distance", false);
        }else{
            SmartDashboard.putBoolean("Gear Distance", false);
            SmartDashboard.putBoolean("Shooter Distance", false);
        }
        SmartDashboard.putNumber("Distance Forward", Robot.ultrasonic.getDistance());
        SmartDashboard.putNumber("Distance", Robot.driveEncoders.getLeftDistance());
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
