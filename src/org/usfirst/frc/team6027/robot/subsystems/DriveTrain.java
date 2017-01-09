package org.usfirst.frc.team6027.robot.subsystems;

import org.usfirst.frc.team6027.robot.commands.StickDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	private CANTalon backRight = new CANTalon(0);
    private CANTalon frontLeft = new CANTalon(1);
    private VictorSP frontRight = new VictorSP(1);
    private VictorSP backLeft = new VictorSP(0);
    private RobotDrive drivetrain= new RobotDrive(frontLeft,backLeft,frontRight,backRight);
	
    public DriveTrain() {
		super();
	}
    
    public void initDefaultCommand() {
    	setDefaultCommand(new StickDrive());
    }
    public void drive(Joystick stick){
    	drivetrain.arcadeDrive(stick);
    }
    public void drive(double forward, double turn){
    	drivetrain.arcadeDrive(forward,turn);
    }
}

