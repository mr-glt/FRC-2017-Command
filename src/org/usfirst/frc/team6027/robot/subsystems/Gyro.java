package org.usfirst.frc.team6027.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * A subsystem to operate the gyro
 */
public class Gyro extends Subsystem {
    private ADXRS450_Gyro gyro = new ADXRS450_Gyro();
    public Gyro(){
    }

    /**
     * No default command
     */
    @Override
    protected void initDefaultCommand() {

    }

    /**
     * A method to reset the gyro
     */
    public void reset(){
        gyro.reset();
    }

    /**
     * A method to calibrate the gyro
     */
    public void calibrate(){
        gyro.calibrate();
    }

    /**
     *
     * @return angle from starting position in degrees
     */
    public double getAngle(){
        return gyro.getAngle();
    }

    /**
     *
     * @return rate of the gyro
     */
    public double getRate(){
        return gyro.getRate();
    }

    /**
     *
     * @return construed gyro
     */
    public ADXRS450_Gyro getGyro(){
        return gyro;
    }
}
