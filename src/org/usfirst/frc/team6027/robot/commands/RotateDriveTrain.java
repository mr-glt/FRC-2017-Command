package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6027.robot.Robot;

/**
 * Created by colso on 1/12/2017.
 */
public class RotateDriveTrain extends Command{
    private PIDController pid;

    public RotateDriveTrain(double theta){
        requires(Robot.drivetrain);
        pid = new PIDController(0.01, 0, 0, new PIDSource(){
            PIDSourceType source = PIDSourceType.kDisplacement;
            @Override
            public double pidGet() {
                if(Robot.oi.getGyro().getAngle()<0){
                    return Robot.oi.getGyro().getAngle() + 360;
                }
                else{
                    return Robot.oi.getGyro().getAngle();
                }
            }

            @Override
            public void setPIDSourceType(PIDSourceType pidSource) {
                source = pidSource;
            }

            @Override
            public PIDSourceType getPIDSourceType() {
                return source;
            }
        },new PIDOutput(){
            @Override
            public void pidWrite(double d) {
                Robot.drivetrain.drive(0, d);
            }
        });
        pid.setAbsoluteTolerance(1);
        pid.setInputRange(0,360);
        pid.setSetpoint(theta);
    }

    @Override
    protected void initialize() {
        Robot.gyro.calibrateGyro();
        pid.reset();
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
        Robot.drivetrain.drive(0, 0);
    }

    @Override
    protected void interrupted() {
        pid.disable();
        Robot.drivetrain.drive(0, 0);
    }
}
