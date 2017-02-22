package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6027.robot.Robot;

public class DriveUntil extends Command {
    private PIDController pid;

    public DriveUntil(double setpoint){
        requires(Robot.drivetrain);
        pid = new PIDController(0.27, 0, 0, Robot.ultrasonic.getUltrasonic(), new pidOutput());
        pid.setAbsoluteTolerance(2);
        pid.setSetpoint(setpoint);
    }
    @Override
    protected void initialize() {
        pid.enable();
    }

    @Override
    protected void execute() {

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
    }
    private class pidOutput implements PIDOutput {
        @Override
        public void pidWrite(double output) {
            if(output<0){
                Robot.drivetrain.tankDrive(output*-0.53,output*-0.5);
            }else{
                Robot.drivetrain.tankDrive(output*-0.50,output*-0.55);
            }
        }
    }
}