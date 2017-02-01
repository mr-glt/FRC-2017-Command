package org.usfirst.frc.team6027.robot.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6027.robot.RobotMap;


public class Meter extends Subsystem {
    CANTalon meterWheel = new CANTalon(RobotMap.meterWheelPort);
    public Meter(){

    }
    @Override
    protected void initDefaultCommand() {

    }
    public void spinMeterUp(){
        meterWheel.set(1);
    }
    public void spinMeterDown(){
        meterWheel.set(0);
    }
    public void spinMeterReverse(){
        meterWheel.set(-1);
    }
}
