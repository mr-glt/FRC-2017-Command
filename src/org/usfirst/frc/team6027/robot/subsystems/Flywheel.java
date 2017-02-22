package org.usfirst.frc.team6027.robot.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6027.robot.RobotMap;

public class Flywheel extends Subsystem {
    private CANTalon mainFlywheel = new CANTalon(RobotMap.mainFlywheelPort);

    public Flywheel(){

    }
    @Override
    protected void initDefaultCommand() {

    }
    /*
    public void setFlywheelRPM(double rpm, boolean isReverse){
        if(isReverse){
            mainFlywheel.setSetpoint(-rpm);
        }
        else{
            mainFlywheel.setSetpoint(rpm);
        }
    }
    */
    public void setFlywheelVoltage(double voltage, boolean isReverse){
        if(isReverse){
            mainFlywheel.set(-voltage);
        }else{
            mainFlywheel.set(voltage);
        }
    }
    public void stopFlywheel(){
        mainFlywheel.set(0);
    }
}