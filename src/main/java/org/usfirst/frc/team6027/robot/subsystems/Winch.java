package org.usfirst.frc.team6027.robot.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6027.robot.RobotMap;

/**
 * A subsystem to control the rotation drum on the winch.
 * @author Charlie Wade
 * @version Post-Build
 */
public class Winch extends Subsystem{
    private CANTalon winch = new CANTalon(RobotMap.winchPort);
    private DigitalInput limitSwitch = new DigitalInput(RobotMap.winchLimitPort);
    private Counter counter = new Counter(limitSwitch);
    public Winch(){

    }

    /** There is not default command
     *
     */
    @Override
    protected void initDefaultCommand() {

    }

    /**
     *
     * @return is limit is hit
     */
    public boolean isSwitchSet() {
        return counter.get() > 0;
    }

    /**
     * Sets up counter for limit switch
     */
    public void initializeCounter() {
        counter.reset();
    }
    /**
     * Sets the winch to rotate.
     */
    public void on(){
        winch.set(1);
    }

    /**
     * Sets the winch to zero.
     */
    public void off(){
        winch.set(0);
    }

    /**
     *
     * @param state sets the break state on the speed controller
     */
    public void breakMode(boolean state){
        winch.enableBrakeMode(state);
    }
}
