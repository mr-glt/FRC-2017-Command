package org.usfirst.frc.team6027.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6027.robot.RobotMap;
import org.usfirst.frc.team6027.robot.commands.Indicators;

/**
 * A subsystem to control the ultrasonic sensors.
 * @author Charlie Wade
 * @version Post-Build
 */
public class Ultrasonic extends Subsystem {
    private double valueToInches = RobotMap.valueToInches;
    private AnalogInput ultrasonic;
    private Double lastLocation;
    private int port = RobotMap.ultrasonicPort;

    /**
     *
     * @param valueToInches voltage to inches
     * @param port analogue port
     */
    public Ultrasonic(double valueToInches, int port){
        valueToInches = this.valueToInches;
        port = this.port;
        ultrasonic = new AnalogInput(port);
        lastLocation = ultrasonic.getValue() * valueToInches;
    }

    /**
     * Runs indicators on SmartDashboard to show when the robot can shoot and deliver a gear.
     */
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new Indicators());
    }

    /**
     *
     * @return distance forward in inches
     */
    public double getDistance(){
        return ultrasonic.getValue() * valueToInches;
    }

    /**
     * Resets the ultrasonic sensor
     */
    public void reset(){
        lastLocation = ultrasonic.getValue()*valueToInches;
    }

    /**
     *
     * @return distance moved in inches
     */
    public double getDistanceGone(){
        return ultrasonic.getValue()*valueToInches - lastLocation;
    }

    /**
     *
     * @return ultrasonic sensor as a AnalogInput
     */
    public AnalogInput getUltrasonic(){
        return ultrasonic;
    }
}
