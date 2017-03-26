package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usfirst.frc.team6027.robot.Robot;

/**
 * This command rotates the drive train to a given degree.
 */
public class RotateDriveTrain extends Command{
    public double theta=0;
    private PIDController pid;
    private Logger logger = LoggerFactory.getLogger(RotateDriveTrain.class);

    /**
     *
     * @param theta degrees to rotate drive train.
     */
    public RotateDriveTrain(double theta){
        requires(Robot.drivetrain);
        requires(Robot.driveEncoders);
        requires(Robot.gyro);
        this.theta=theta;
        pid = new PIDController(0.55, 0.002, 0.4, Robot.gyro.getGyro(), new pidOutput());
        pid.setAbsoluteTolerance(0.25);
        pid.setInputRange(-360,360);
        pid.setOutputRange(-0.65,0.65);
        pid.setSetpoint(theta);
    }

    @Override
    protected void initialize() {
        logger.info("Rotating robot to: " + theta);
        Robot.driveEncoders.getEncoderLeft().reset();
    	pid.reset();
    	pid.enable();
    }

    @Override
    protected void execute() {
    	SmartDashboard.putNumber("Theta", Robot.gyro.getAngle());
    }

    /**
     *
     * @return when the PID is on target
     */
    @Override
    protected boolean isFinished() {
        return pid.onTarget();
    }

    /**
     * Stop driving the robot
     */
    @Override
    protected void end() {
    	logger.info("Finished on target at: " + Robot.gyro.getAngle());
        if((Math.abs(theta) - Math.abs(Robot.gyro.getAngle())) > 2){
            logger.info("Large error of: " + (Math.abs(theta) - Math.abs(Robot.gyro.getAngle())));
        }
    	Robot.driveEncoders.getEncoderLeft().reset();
        Robot.drivetrain.arcadeDrive(0,0);
    	pid.disable();
        pid.reset();
    }

    /**
     * Abort driving the robot
     */
    @Override
    protected void interrupted() {
    	logger.info("Interrupted at: " + Robot.gyro.getAngle());
    	Robot.driveEncoders.getEncoderLeft().reset();
        Robot.drivetrain.arcadeDrive(0,0);
    	pid.disable();
        pid.reset();
    }

    /**
     * Drives the robot to the PID output using arcade drive.
     */
    private class pidOutput implements PIDOutput {
        @Override
        public void pidWrite(double output) {
            Robot.drivetrain.arcadeDrive(0,-output);
        }
    }
}
