package org.usfirst.frc.team6027.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6027.robot.RobotMap;
import org.usfirst.frc.team6027.robot.commands.StickDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * This class provides drive functionality to the robot. It uses the two most common forms of standard drive, arcade and tank. Motor ports
 * can be changed in the RobotMap.
 */
public class DriveTrain extends Subsystem{
	private CANTalon frontRight = new CANTalon(RobotMap.frontRight);
    private CANTalon backRight = new CANTalon(RobotMap.backRight);
    private CANTalon frontLeft = new CANTalon(RobotMap.frontLeft);
    private CANTalon backLeft = new CANTalon(RobotMap.backLeft);
    private RobotDrive drivetrain= new RobotDrive(frontLeft,backLeft,frontRight,backRight);

    public DriveTrain() {
    }

    /**
     * Sets the default state of the robot to be driven by the joystick.
     */
    public void initDefaultCommand() {
    	setDefaultCommand(new StickDrive());
    }

    /**
     * A method to drive arcade style with a joystick.
     * @param stick joystick to drive with
     */
    public void arcadeDrive(Joystick stick){
    	drivetrain.arcadeDrive(stick);
    }

    /**
     * A method to drive the robot based on forward power and rotation.
     * @param forward the value from -1 to 1 to move the robot in the y-axis
     * @param turn the value from -1 to 1 to move the robot in the x-axis
     */
    public void arcadeDrive(double forward, double turn){
    	drivetrain.arcadeDrive(forward,turn);
    }

    /**
     * A method the drive the robot using tank style left/right joysticks.
     * @param joystickLeft joystick for left control
     * @param joystickRight joystick for right control
     */
    public void tankDrive(Joystick joystickLeft, Joystick joystickRight){
        drivetrain.tankDrive(joystickLeft,joystickRight);
    }

    /**
     * A method to drive the robot using tank style left/right values.
     * @param leftValue a value from -1 to 1
     * @param rightValue a value from -1 to 1
     */
    public void tankDrive(double leftValue, double rightValue){
        drivetrain.tankDrive(leftValue,rightValue);
    }
}

