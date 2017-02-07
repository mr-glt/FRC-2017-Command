package org.usfirst.frc.team6027.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Deflector extends Subsystem {
    private DoubleSolenoid sol = new DoubleSolenoid(2,3);
    public Deflector(){

    }
    @Override
    protected void initDefaultCommand() {

    }
    public void engaged(){
        sol.set(DoubleSolenoid.Value.kForward);
    }
    public void disengaged(){
        sol.set(DoubleSolenoid.Value.kForward);
    }
}
