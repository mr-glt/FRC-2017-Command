package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usfirst.frc.team6027.robot.Robot;

/**
 * A command to drive to a specified distance in inches using the drive encoders and a differential.
 */
public class DriveDistanceDiff extends Command {
    private Logger logger = LoggerFactory.getLogger(DriveDistanceDiff.class);
    private PIDController pid;
    private PIDController pidRight;
    private double setpoint=0;
    private double outputLeft=0;
    private double outputRight=0;

    /**
     * Requires DriveTrain, DriveEncoders, Gyro, Ultrasonic
     * @param setpoint distance to move in inches
     */
    public DriveDistanceDiff(double setpoint){
        requires(Robot.drivetrain);
        requires(Robot.driveEncoders);
        requires(Robot.ultrasonic);
        this.setpoint=setpoint;
        pid = new PIDController(0.1, 0, 0, Robot.driveEncoders.getEncoderLeft(), new pidOutput());
        pidRight = new PIDController(0.1,0,0,Robot.driveEncoders.getEncoderRight(),new pidOutputRight());
        if(setpoint>0){
            pid.setInputRange(0,setpoint+10);
            pidRight.setInputRange(0,setpoint+10);
        }else{
            pid.setInputRange(setpoint-10,0);
            pidRight.setInputRange(setpoint-10,0);
        }
        pid.setAbsoluteTolerance(0.5);
        pidRight.setAbsoluteTolerance(0.5);
        pid.setOutputRange(-0.6,0.6);
        pidRight.setOutputRange(-0.6,0.6);
        pid.setSetpoint(setpoint);
        pidRight.setSetpoint(setpoint);
    }
    @Override
    protected void initialize() {
    	logger.info("Driving Forward for: " + setpoint);
        Robot.driveEncoders.getEncoderLeft().reset();
        Robot.driveEncoders.getEncoderRight().reset();
    	pid.enable();
    	pidRight.enable();
    }

    @Override
    protected void execute() {
        SmartDashboard.putNumber("Distance", Robot.driveEncoders.getEncoderLeft().getDistance());
        Robot.drivetrain.tankDrive(outputRight,outputLeft);
    }

    /**
     *
     * @return when pid is on target or we are about to hit something
     */
    @Override
    protected boolean isFinished() {
        return (pid.onTarget() && pidRight.onTarget()) || Robot.ultrasonic.getDistance()<7;
    }

    /**
     * Stop robot
     */
    @Override
    protected void end() {
    	logger.info("Finished on target at: " + Robot.driveEncoders.getEncoderLeft().getDistance());
    	if((Math.abs(setpoint) - Math.abs(Robot.driveEncoders.getEncoderLeft().getDistance())) > 2){
            logger.info("Large error of: " + (Math.abs(setpoint) - Math.abs(Robot.driveEncoders.getEncoderLeft().getDistance())));
        }
        if((Math.abs(Robot.driveEncoders.getEncoderLeft().getDistance()) - Math.abs(Robot.driveEncoders.getEncoderRight().getDistance())) > 2){
    	    logger.info("Large left/right error of: " + (Math.abs(Robot.driveEncoders.getEncoderLeft().getDistance()) - Math.abs(Robot.driveEncoders.getEncoderRight().getDistance())));
        }
    	pid.disable();
        pidRight.disable();
    	pid.reset();
        pidRight.reset();
        Robot.drivetrain.arcadeDrive(0,0);
    }

    /**
     * Stop robot
     */
    @Override
    protected void interrupted() {
    	logger.info("Interrupted at: " + Robot.driveEncoders.getEncoderLeft().getDistance());
    	pid.disable();
    	pidRight.disable();
        pid.reset();
        pidRight.reset();
        Robot.drivetrain.arcadeDrive(0,0);
    }
    private class pidOutput implements PIDOutput {
        @Override
        public void pidWrite(double output) {
            outputLeft = output;
        }
    }
    private class pidOutputRight implements PIDOutput {
        @Override
        public void pidWrite(double output) {
            outputRight = output;
        }
    }
}
