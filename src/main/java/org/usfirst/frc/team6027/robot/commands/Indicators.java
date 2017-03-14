package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6027.robot.Robot;
import org.usfirst.frc.team6027.robot.RobotMap;

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
        if(Robot.ultrasonic.getDistance()<= RobotMap.gearMax){
            SmartDashboard.putBoolean("Gear Distance", true);
            SmartDashboard.putBoolean("Shooter Distance", false);
        }else if(Robot.ultrasonic.getDistance()<= RobotMap.shootMax && Robot.ultrasonic.getDistance() >= RobotMap.shootMin){
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
