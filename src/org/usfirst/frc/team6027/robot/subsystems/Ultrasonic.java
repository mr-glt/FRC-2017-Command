package org.usfirst.frc.team6027.robot.subsystems;

import org.usfirst.frc.team6027.robot.commands.GetDistance;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Ultrasonic extends Subsystem {
	private static final double valueToInches = 0.125;
	private AnalogInput ultrasonic = new AnalogInput(0);
	
    public Ultrasonic() {
		super();
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new GetDistance());
    }
    public double getDistance(){
    	return ultrasonic.getValue()*valueToInches;
    }
    public void displayDistance(){
    	SmartDashboard.putNumber("Distance", ultrasonic.getValue()*valueToInches);
    }
}

