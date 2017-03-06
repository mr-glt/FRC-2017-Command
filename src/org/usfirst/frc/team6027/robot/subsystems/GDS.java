package org.usfirst.frc.team6027.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6027.robot.RobotMap;

/**
 * A subsystem to control the Gear Deliver System(GDS).
 * @author Charlie Wade
 * @version Post-Build
 */
public class GDS extends Subsystem{
    private DoubleSolenoid sol = new DoubleSolenoid(10,RobotMap.solGDSOne,RobotMap.solGDSTwo);

    public GDS(){
        super();
    }

    /**
     * There is no default command.
     */
    @Override
    protected void initDefaultCommand() {
    }

    /**
     * Sets the GDS to open.
     */
    public void open(){
        sol.set(DoubleSolenoid.Value.kForward);
        System.out.println("GDS opened");
    }

    /**
     * Sets the GDS to close.
     */
    public void close(){
        sol.set(DoubleSolenoid.Value.kReverse);
        System.out.println("GDS closed");
    }

    /**
     * Vents the GDS.
     */
    public void vent(){
        sol.set(DoubleSolenoid.Value.kOff);
    }

    /**
     *
     * @return returns the state of the GDS as a DoubleSolenoid
     */
    public DoubleSolenoid.Value get(){
        return  sol.get();
    }

    /**
     *
     * @return returns the state of the GDS as a bool
     */
    public boolean isOut(){
        return sol.get() == DoubleSolenoid.Value.kForward;
    }
}
