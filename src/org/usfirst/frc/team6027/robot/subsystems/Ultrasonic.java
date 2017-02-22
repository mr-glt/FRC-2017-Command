package org.usfirst.frc.team6027.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6027.robot.RobotMap;

/**
 * A subsystem to control the ultrasonic sensors.
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
     * There is no default command
     */
    @Override
    protected void initDefaultCommand() {

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
