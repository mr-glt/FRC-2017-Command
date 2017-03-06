package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6027.robot.Robot;

public class DriveDistance extends Command {
    private PIDController pid;

    public DriveDistance(double setpoint){
        requires(Robot.drivetrain);
        requires(Robot.driveEncoders);
        requires(Robot.gyro);
        requires(Robot.ultrasonic);
        pid = new PIDController(0.1, 0, 0, Robot.driveEncoders.getEncoderLeft(), new pidOutput());
        if(setpoint>0){
            pid.setInputRange(0,setpoint+10);
        }else{
            pid.setInputRange(setpoint-10,0);
        }
        pid.setAbsoluteTolerance(0.5);
        pid.setOutputRange(-0.6,0.6);
        pid.setSetpoint(setpoint);
        System.out.println("Driving Forward for:  " + setpoint);
    }
    @Override
    protected void initialize() {
    	Robot.driveEncoders.getEncoderLeft().reset();
    	Robot.gyro.reset();
    	pid.enable();
    }

    @Override
    protected void execute() {
        SmartDashboard.putNumber("Distance", Robot.driveEncoders.getEncoderLeft().getDistance());
    }

    @Override
    protected boolean isFinished() {
        return pid.onTarget();
    }

    @Override
    protected void end() {
    	System.out.println("Finished on target at: " + Robot.driveEncoders.getEncoderLeft().getDistance());
    	pid.disable();
        pid.reset();
        Robot.drivetrain.arcadeDrive(0,0);
    }

    @Override
    protected void interrupted() {
    	System.out.println("Interrupted at: " + Robot.driveEncoders.getEncoderLeft().getDistance());
    	pid.disable();
        pid.reset();
        Robot.drivetrain.arcadeDrive(0,0);
    }
    private class pidOutput implements PIDOutput {
        @Override
        public void pidWrite(double output) {
            double turningValue = (0 - Robot.gyro.getAngle()) * 0.0085;
            Robot.drivetrain.arcadeDrive(output,turningValue);
        }
    }
}
