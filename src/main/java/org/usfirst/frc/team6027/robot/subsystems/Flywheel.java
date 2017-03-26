package org.usfirst.frc.team6027.robot.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6027.robot.RobotMap;

/**
 * Subsystem to control the shooter wheel
 * @author Charlie Wade
 * @version Post-Build
 */
public class Flywheel extends Subsystem {
    private CANTalon mainFlywheel = new CANTalon(RobotMap.mainFlywheelPort);

    public Flywheel(){

    }
    @Override
    protected void initDefaultCommand() {

    }

    /**
     * Method to set the flywheel voltage.
     * @param voltage sets the power level of the flywheel
     * @param isReverse sets if the flywheel direction is reversed
     */
    public void setFlywheelVoltage(double voltage, boolean isReverse){
        if(isReverse){
            mainFlywheel.set(-voltage);
        }else{
            mainFlywheel.set(voltage);
        }
    }

    /**
     * Sets the flywheel to zero.
     */
    public void stopFlywheel(){
        mainFlywheel.set(0);
    }
}