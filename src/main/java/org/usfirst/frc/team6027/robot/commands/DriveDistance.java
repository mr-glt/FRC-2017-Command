package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usfirst.frc.team6027.robot.Robot;

/**
 * A command to drive to a specified distance in inches using the drive encoders.
 */
public class DriveDistance extends Command {
    private Logger logger = LoggerFactory.getLogger(DriveDistance.class);
    private PIDController pid;
    private PIDController pidTurn;
    private double setpoint=0;
    private boolean stoppable=false;
    private double forward=0;
    private double turn=0;
    /**
     * Requires DriveTrain, DriveEncoders, Gyro, Ultrasonic
     * @param setpoint distance to move in inches
     */
    public DriveDistance(double setpoint, boolean stoppable, double turn){
        requires(Robot.drivetrain);
        requires(Robot.driveEncoders);
        requires(Robot.gyro);
        requires(Robot.ultrasonic);
        this.setpoint=setpoint;
        this.stoppable=stoppable;
        this.turn=turn;
        pid = new PIDController(0.85, 0, 0, Robot.driveEncoders.getEncoderLeft(), new pidOutput());
        pidTurn = new PIDController(0.2, 0.02, 0.4, Robot.gyro.getGyro(), new pidOutputTurn());

        pidTurn.setOutputRange(-0.50,0.50);
        if(setpoint>0){
            pid.setInputRange(0,setpoint+10);
        }else{
            pid.setInputRange(setpoint-10,0);
        }
        pid.setAbsoluteTolerance(0.25);
        pid.setOutputRange(-0.6,0.6);
        pid.setSetpoint(setpoint);
        System.out.println("Driving Forward for:  " + setpoint);
    }
    @Override
    protected void initialize() {
    	logger.info("Driving Forward for: " + setpoint);
        Robot.driveEncoders.getEncoderLeft().reset();
    	pid.enable();
        pidTurn.setSetpoint(turn);
    	pidTurn.enable();
    }

    @Override
    protected void execute() {
        SmartDashboard.putNumber("Distance", Robot.driveEncoders.getEncoderLeft().getDistance());
        SmartDashboard.putNumber("Gyro", Robot.gyro.getAngle());
        Robot.drivetrain.arcadeDrive(forward,turn);
    }

    /**
     *
     * @return when pid is on target or we are about to hit something
     */
    @Override
    protected boolean isFinished() {
        if (stoppable){
            return pid.onTarget() || Robot.ultrasonic.getDistance()<7;
        }else{
            return pid.onTarget();
        }
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
        pidTurn.disable();
    	pidTurn.reset();
    	pid.disable();
        pid.reset();
        Robot.drivetrain.arcadeDrive(0,0);
    }

    /**
     * Stop robot
     */
    @Override
    protected void interrupted() {
    	logger.info("Interrupted at: " + Robot.driveEncoders.getEncoderLeft().getDistance());
    	pid.disable();
        pid.reset();
        pidTurn.disable();
        pidTurn.reset();
        Robot.drivetrain.arcadeDrive(0,0);
    }
    private class pidOutput implements PIDOutput {
        @Override
        public void pidWrite(double output) {
            forward=output;
        }
    }
    private class pidOutputTurn implements PIDOutput {
        @Override
        public void pidWrite(double output) {
            turn=-output;
        }
    }
}
