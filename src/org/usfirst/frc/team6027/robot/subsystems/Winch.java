package org.usfirst.frc.team6027.robot.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6027.robot.RobotMap;

public class Winch extends Subsystem{
    private CANTalon winch = new CANTalon(RobotMap.winchPort);
    public Winch(){

    }
    @Override
    protected void initDefaultCommand() {

    }
    public void on(){
        winch.set(0.5);
    }
    public void off(){
        winch.set(0);
    }
    public void breakMode(boolean state){
        winch.enableBrakeMode(state);
    }
}
