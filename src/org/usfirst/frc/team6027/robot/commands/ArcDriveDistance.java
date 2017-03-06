package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6027.robot.Robot;

public class ArcDriveDistance extends Command {
    private PIDController pidX;
    private PIDController pidY;
    double xOutput=0;
    double yOutput=0;
    double setpoint1=0;
    double setpoint2=0;
    public ArcDriveDistance(double radius, boolean isRighthand){
        requires(Robot.drivetrain);
        requires(Robot.driveEncoders);
        requires(Robot.gyro);
        requires(Robot.ultrasonic);
        if (isRighthand){
            setpoint1 = 2*Math.PI*radius;
            setpoint2 = 2*Math.PI*(radius-34);
        }else{
            setpoint1 = 2*Math.PI*(radius-34);
            setpoint2 = 2*Math.PI*radius;
        }
        pidX= new PIDController(0.05, 0, 0, Robot.driveEncoders.getEncoderLeft(), new pidXOutput());
        if(setpoint1>0){
            pidX.setInputRange(0,setpoint1+10);
        }else{
            pidX.setInputRange(setpoint1-10,0);
        }
        pidX.setAbsoluteTolerance(0.5);
        pidX.setOutputRange(-0.6,0.6);
        pidX.setSetpoint(setpoint1);

        pidY = new PIDController(0.05, 0, 0, Robot.driveEncoders.getEncoderRight(), new pidYOutput());
        if(setpoint2>0){
            pidY.setInputRange(0,setpoint2+10);
        }else{
            pidY.setInputRange(setpoint2-10,0);
        }
        pidY.setAbsoluteTolerance(0.5);
        pidY.setOutputRange(-0.6,0.6);
        pidY.setSetpoint(setpoint2);
    }
    @Override
    protected void initialize() {
    	Robot.driveEncoders.getEncoderLeft().reset();
    	Robot.gyro.reset();
    	pidX.enable();
    	pidY.enable();
    }

    @Override
    protected void execute() {
        SmartDashboard.putNumber("Distance", Robot.driveEncoders.getEncoderLeft().getDistance());
        Robot.drivetrain.tankDrive(xOutput,yOutput);
    }

    @Override
    protected boolean isFinished() {
        return (pidX.onTarget() && pidY.onTarget()) || (Robot.ultrasonic.getDistance()<4);
    }

    @Override
    protected void end() {
        pidX.disable();
        pidX.reset();
        pidY.disable();
        pidY.reset();
        Robot.drivetrain.arcadeDrive(0,0);
    }

    @Override
    protected void interrupted() {
        pidX.disable();
        pidX.reset();
        pidY.disable();
        pidY.reset();
        Robot.drivetrain.arcadeDrive(0,0);
    }
    private class pidXOutput implements PIDOutput {
        @Override
        public void pidWrite(double output) {
            xOutput=output;
        }
    }
    private class pidYOutput implements PIDOutput {
        @Override
        public void pidWrite(double output) {
            yOutput=output;
        }
    }
}
