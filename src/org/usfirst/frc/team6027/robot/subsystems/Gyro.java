package org.usfirst.frc.team6027.robot.subsystems;

import org.usfirst.frc.team6027.robot.commands.GetGyro;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Gyro extends Subsystem {
	private ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	
    public Gyro() {
		super();
	}
    public void initDefaultCommand() {
    	setDefaultCommand(new GetGyro());
    }
    public double getGyroAngle(){
    	return gyro.getAngle();
    }
    public void calibrateGyro(){
    	gyro.calibrate();
    }
    public void displayGyro(){
    	SmartDashboard.putNumber("Angle", gyro.getAngle());
    }
}

