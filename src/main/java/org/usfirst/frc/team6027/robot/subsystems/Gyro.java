package org.usfirst.frc.team6027.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * A Subsystem for gyro
 * @author Charlie Wade
 * @version Post-Build
 */
public class Gyro extends Subsystem {
    private ADXRS450_Gyro gyro = new ADXRS450_Gyro();

    /**
     * Subsystem for gyro
     */
    public Gyro(){
    }

    /**
     * No default command
     */
    @Override
    protected void initDefaultCommand() {

    }

    /**
     * Resets gyro count
     */
    public void reset(){
        gyro.reset();
    }

    /**
     * Recalibrates gyro
     */
    public void calibrate(){
        gyro.calibrate();
    }

    /**
     *
     * @return angle turned in degrees
     */
    public double getAngle(){
        return gyro.getAngle();
    }

    /**
     *
     * @return poll rate of gyro
     */
    public double getRate(){
        return gyro.getRate();
    }

    /**
     *
     * @return ADXRS450 gyro
     */
    public ADXRS450_Gyro getGyro(){
        return gyro;
    }
}
