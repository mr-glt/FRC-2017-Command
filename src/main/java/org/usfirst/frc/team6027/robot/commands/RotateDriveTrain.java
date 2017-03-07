package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usfirst.frc.team6027.robot.Robot;

public class RotateDriveTrain extends Command{
    private double theta=0;
    private PIDController pid;
    private Logger logger = LoggerFactory.getLogger(RotateDriveTrain.class);

    public RotateDriveTrain(double theta){
        requires(Robot.drivetrain);
        requires(Robot.driveEncoders);
        requires(Robot.gyro);
        this.theta=theta;
        pid = new PIDController(0.085, 0, 0, Robot.gyro.getGyro(), new pidOutput());
        pid.setAbsoluteTolerance(1);
        pid.setInputRange(-180,180);
        pid.setOutputRange(-0.4,0.4);
        pid.setSetpoint(theta);
    }

    @Override
    protected void initialize() {
        logger.debug("Rotating robot to: " + theta);
        Robot.driveEncoders.getEncoderLeft().reset();
        Robot.gyro.reset();
    	pid.reset();
    	pid.enable();
    }

    @Override
    protected void execute() {
    	SmartDashboard.putNumber("Theta", Robot.gyro.getAngle());
    }

    @Override
    protected boolean isFinished() {
        return pid.onTarget();
    }

    @Override
    protected void end() {
    	logger.debug("Finished on target at: " + Robot.gyro.getAngle());
        if((Math.abs(theta) - Math.abs(Robot.gyro.getAngle())) > 2){
            logger.warn("Large error of: " + (Math.abs(theta) - Math.abs(Robot.gyro.getAngle())));
        }
    	Robot.driveEncoders.getEncoderLeft().reset();
        Robot.drivetrain.arcadeDrive(0,0);
    	pid.disable();
        pid.reset();
    }

    @Override
    protected void interrupted() {
    	logger.warn("Interrupted at: " + Robot.gyro.getAngle());
    	Robot.driveEncoders.getEncoderLeft().reset();
        Robot.drivetrain.arcadeDrive(0,0);
    	pid.disable();
        pid.reset();
    }
    private class pidOutput implements PIDOutput {
        @Override
        public void pidWrite(double output) {
            Robot.drivetrain.arcadeDrive(0,-output);
        }
    }
}
