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
        pid = new PIDController(0.27, 0, 0, Robot.driveEncoders.getEncoderLeft(), new pidOutput());
        pid.setAbsoluteTolerance(0.5);
        pid.setSetpoint(setpoint);
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
        return pid.onTarget() || (Robot.ultrasonic.getDistance()<4);
    }

    @Override
    protected void end() {
        pid.disable();
        pid.reset();
        Robot.drivetrain.arcadeDrive(0,0);
    }

    @Override
    protected void interrupted() {
        pid.disable();
        pid.reset();
        Robot.drivetrain.arcadeDrive(0,0);
    }
    private class pidOutput implements PIDOutput {
        @Override
        public void pidWrite(double output) {
            double turningValue = (0 - Robot.gyro.getAngle()) * 0.005;
            Robot.drivetrain.arcadeDrive(output*0.60,turningValue);
        }
    }
}
