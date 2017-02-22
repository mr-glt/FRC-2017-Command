package org.usfirst.frc.team6027.robot.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6027.robot.RobotMap;

/**
 * A subsystem to control the metering wheel
 */
public class Meter extends Subsystem {
    private CANTalon meterWheel = new CANTalon(RobotMap.meterWheelPort);
    public Meter(){
    }

    /**
     * There is no default command
     */
    @Override
    protected void initDefaultCommand() {
    }

    /**
     * Spin the metering wheel up
     */
    public void spinMeterUp(){
        meterWheel.set(1);
    }

    /**
     * Spin the metering wheel to zero.
     */
    public void spinMeterDown(){
        meterWheel.set(0);
    }

    /**
     * Spin the metering wheel in reverse
     */
    public void spinMeterReverse(){
        meterWheel.set(-1);
    }
}