package org.usfirst.frc.team6027.robot.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6027.robot.RobotMap;

public class Winch extends Subsystem{
    private CANTalon winch = new CANTalon(RobotMap.winchPort);
    private DoubleSolenoid sol = new DoubleSolenoid(RobotMap.solWinchOne,RobotMap.solWinchTwo);
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
    public void setLock(boolean value){
        if(value){
            sol.set(DoubleSolenoid.Value.kForward);
        }else{
            sol.set(DoubleSolenoid.Value.kReverse);
        }
    }

}
