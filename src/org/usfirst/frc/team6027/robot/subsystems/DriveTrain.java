package org.usfirst.frc.team6027.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6027.robot.commands.StickDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;

public class DriveTrain extends Subsystem{
	private CANTalon frontRight = new CANTalon(0);
    private CANTalon backRight = new CANTalon(1);
    private VictorSP frontLeft = new VictorSP(1);
    private VictorSP backLeft = new VictorSP(0);
    private RobotDrive drivetrain= new RobotDrive(frontLeft,backLeft,frontRight,backRight);

    public DriveTrain() {
	}
   
    public void initDefaultCommand() {
    	setDefaultCommand(new StickDrive());
    }
    public void arcadeDrive(Joystick stick){
    	drivetrain.arcadeDrive(stick);
    }
    public void arcadeDrive(double forward, double turn){
    	drivetrain.arcadeDrive(forward,turn);
    }
    public void tankDrive(Joystick joystickLeft, Joystick joystickRight){
        drivetrain.tankDrive(joystickLeft,joystickRight);
    }
    public void tankDrive(double leftValue, double rightValue){
        drivetrain.tankDrive(leftValue,rightValue);
    }
}

