package org.usfirst.frc.team6027.robot.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6027.robot.RobotMap;

/**
 * A subsystem to control the pickup motor
 */
public class Pickup extends Subsystem{
    private CANTalon controller = new CANTalon(RobotMap.pickup);

    /**
     * No default command
     */
    @Override
    protected void initDefaultCommand() {

    }

    /**
     * A method the set the pickup to 80%
     */
    public void pickUp(){
        controller.set(0.8);
    }

    /**
     * A method to set the pickup to -100%
     */
    public void reverse(){
        controller.set(-1);
    }

    /**
     * A method to set the pickup to 0%
     */
    public void off(){
        controller.set(0);
    }
}
