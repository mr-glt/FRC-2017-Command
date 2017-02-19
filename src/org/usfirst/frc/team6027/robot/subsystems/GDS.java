package org.usfirst.frc.team6027.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6027.robot.RobotMap;
import org.usfirst.frc.team6027.robot.commands.OpenGDS;

public class GDS extends Subsystem{
    private DoubleSolenoid sol = new DoubleSolenoid(10,2,1);
    public GDS(){
        super();
    }
    @Override
    protected void initDefaultCommand() {
        //setDefaultCommand(new OpenGDS());
    }
    public void open(){
        sol.set(DoubleSolenoid.Value.kForward);
    }
    public void close(){
        sol.set(DoubleSolenoid.Value.kReverse);
    }
    public void vent(){
        sol.set(DoubleSolenoid.Value.kOff);
    }
    public DoubleSolenoid.Value get(){
        return  sol.get();
    }
    public boolean isOut(){
        return sol.get() == DoubleSolenoid.Value.kForward;
    }
}
