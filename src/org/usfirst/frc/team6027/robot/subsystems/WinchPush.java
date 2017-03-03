package org.usfirst.frc.team6027.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6027.robot.RobotMap;

/**
 * A subsystem to control the rope pusher.
 */
public class WinchPush extends Subsystem{
    private DoubleSolenoid sol = new DoubleSolenoid(10,RobotMap.solWinchOne,RobotMap.solWinchTwo);
    public WinchPush(){

    }

    /**
     * There is no default command
     */
    @Override
    protected void initDefaultCommand() {
    	
    }

    /**
     *
     * @param value sets the solenoid state
     */
    public void setLock(boolean value){
        if(value){
            sol.set(DoubleSolenoid.Value.kForward);
        }else{
            sol.set(DoubleSolenoid.Value.kReverse);
        }
        SmartDashboard.putBoolean("Winch Cylinder", value);
    }

}
