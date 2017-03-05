package org.usfirst.frc.team6027.robot.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6027.robot.RobotMap;

/**
 * Subsystem for ball pickup
 * @author Charlie Wade
 * @version Post-Build
 */
public class Pickup extends Subsystem{
    private CANTalon controller = new CANTalon(RobotMap.pickup);

    /**
     * Subsystem for ball pickup
     */
    public Pickup(){
    }
    /**
     * No Default Command
     */
    @Override
    protected void initDefaultCommand() {
    }

    /**
     * Sets pickup to 80%
     */
    public void pickUp(){
        controller.set(0.8);
    }

    /**
     * Sets pickup to full reverse
     */
    public void reverse(){
        controller.set(-1);
    }

    /**
     * Sets pickup to off
     */
    public void off(){
        controller.set(0);
    }
}
