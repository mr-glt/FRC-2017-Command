package org.usfirst.frc.team6027.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gyro extends Subsystem {
    private ADXRS450_Gyro gyro = new ADXRS450_Gyro();
    public Gyro(){
    }
    @Override
    protected void initDefaultCommand() {

    }
    public void reset(){
        gyro.reset();
    }
    public void calibrate(){
        gyro.calibrate();
    }
    public double getAngle(){
        return gyro.getAngle();
    }
    public double getRate(){
        return gyro.getRate();
    }
    public ADXRS450_Gyro getGyro(){
        return gyro;
    }
}
