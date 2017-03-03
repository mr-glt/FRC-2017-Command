package org.usfirst.frc.team6027.robot.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6027.robot.RobotMap;

public class Flywheel extends Subsystem {
    private VictorSP mainFlywheel = new VictorSP(RobotMap.mainFlywheelPort);

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