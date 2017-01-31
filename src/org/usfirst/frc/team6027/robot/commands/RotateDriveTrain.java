package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6027.robot.Robot;

public class RotateDriveTrain extends Command{
    private PIDController pid;

    public RotateDriveTrain(double theta){
        requires(Robot.drivetrain);
        pid = new PIDController(0.27, 0, 0, Robot.gyro.getGyro(), new pidOutput());
        pid.setAbsoluteTolerance(1);
        pid.setSetpoint(theta);
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
        pid.reset();
    }
    private class pidOutput implements PIDOutput {
        @Override
        public void pidWrite(double output) {
            Robot.drivetrain.arcadeDrive(0,output*-0.40);
        }
    }
}
