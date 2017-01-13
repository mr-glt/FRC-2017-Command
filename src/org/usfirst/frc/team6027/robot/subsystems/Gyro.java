package org.usfirst.frc.team6027.robot.subsystems;

import org.usfirst.frc.team6027.robot.Robot;
import org.usfirst.frc.team6027.robot.commands.GetGyro;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Gyro extends Subsystem {

    public Gyro() {
		super();
	}
    public void initDefaultCommand() {
    	setDefaultCommand(new GetGyro());
    }
    public double getGyroAngle(){
    	return Robot.oi.getGyro().getAngle();
    }
    public void calibrateGyro(){
        Robot.oi.getGyro().calibrate();
    }
    public void displayGyro(){
    	SmartDashboard.putNumber("Angle", Robot.oi.getGyro().getAngle());
    }
}

