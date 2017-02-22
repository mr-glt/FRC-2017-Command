package org.usfirst.frc.team6027.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6027.robot.RobotMap;

public class WinchPush extends Subsystem{
    private DoubleSolenoid sol = new DoubleSolenoid(10,RobotMap.solWinchOne,RobotMap.solWinchTwo);
    public WinchPush(){

    }
    @Override
    protected void initDefaultCommand() {
    	
    }
    public void setLock(boolean value){
        if(value){
            sol.set(DoubleSolenoid.Value.kForward);
        }else{
            sol.set(DoubleSolenoid.Value.kReverse);
        }
    }

}
