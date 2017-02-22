package org.usfirst.frc.team6027.robot.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6027.robot.RobotMap;

public class Pickup extends Subsystem{
    private CANTalon controller = new CANTalon(RobotMap.pickup);
    @Override
    protected void initDefaultCommand() {

    }
    public void pickUp(){
        controller.set(0.8);
    }
    public void reverse(){
        controller.set(-1);
    }
    public void off(){
        controller.set(0);
    }
}
