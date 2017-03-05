package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6027.robot.Robot;

public class DriveDistanceFast extends Command {
    private PIDController pid;

    public DriveDistanceFast(double setpoint){
        requires(Robot.drivetrain);
        requires(Robot.driveEncoders);
        pid = new PIDController(0.27, 0, 0, Robot.driveEncoders.getEncoderLeft(), new pidOutput());
        pid.setAbsoluteTolerance(1);
        pid.setSetpoint(setpoint);
    }
    @Override
    protected void initialize() {
    	Robot.driveEncoders.getEncoderLeft().reset();
    	pid.enable();
    }

    @Override
    protected void execute() {
    	SmartDashboard.putNumber("Dist", Robot.driveEncoders.getEncoderLeft().getDistance());
    }

    @Override
    protected boolean isFinished() {
        return pid.onTarget();
    }

    @Override
    protected void end() {
        pid.disable();
        pid.reset();
    }

    @Override
    protected void interrupted() {
        pid.disable();
        pid.reset();
    }
    private class pidOutput implements PIDOutput {
        @Override
        public void pidWrite(double output) {
            if(output<0){
                Robot.drivetrain.tankDrive(output*0.82,output*0.80);
            }else{
                Robot.drivetrain.tankDrive(output*0.82,output*0.80);
            }
        }
    }
}
