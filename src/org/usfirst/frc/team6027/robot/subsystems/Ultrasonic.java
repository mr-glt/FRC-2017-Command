package org.usfirst.frc.team6027.robot.subsystems;

import org.usfirst.frc.team6027.robot.Robot;
import org.usfirst.frc.team6027.robot.commands.GetDistance;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Ultrasonic extends Subsystem {
	private static final double valueToInches = 0.125;
	
    public Ultrasonic() {
		super();
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new GetDistance());
    }
    public double getDistance(){
    	return Robot.oi.getUltrasonic().getValue()*valueToInches;
    }
    public void displayDistance(){
    	SmartDashboard.putNumber("Distance", Robot.oi.getUltrasonic().getValue()*valueToInches);
    }
}

