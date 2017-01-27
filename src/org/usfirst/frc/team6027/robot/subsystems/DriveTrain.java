package org.usfirst.frc.team6027.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6027.robot.commands.StickDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends PIDSubsystem {
	private CANTalon backRight = new CANTalon(0);
    private CANTalon frontLeft = new CANTalon(1);
    private VictorSP frontRight = new VictorSP(1);
    private VictorSP backLeft = new VictorSP(0);
    private RobotDrive drivetrain= new RobotDrive(frontLeft,backLeft,frontRight,backRight);
    private AnalogInput ultrasonic = new AnalogInput(0);

    public DriveTrain() {
		super("DriveTrain", 0.01,0.01,0.01);
		setInputRange(3,100);
		setAbsoluteTolerance(2);
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
    @Override
    protected double returnPIDInput() {
        return ultrasonic.getValue()*0.125;
    }

    @Override
    protected void usePIDOutput(double output) {
        SmartDashboard.putNumber("PID Output", output);
        drivetrain.arcadeDrive(output,0);
    }
}

