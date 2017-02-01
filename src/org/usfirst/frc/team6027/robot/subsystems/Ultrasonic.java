package org.usfirst.frc.team6027.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6027.robot.RobotMap;

public class Ultrasonic extends Subsystem {
    private double valueToInches = RobotMap.valueToInches;
    private AnalogInput ultrasonic;
    private Double lastLocation;
    int port = RobotMap.ultrasonicPort;

    public Ultrasonic(double valueToInches, int port){
        valueToInches = this.valueToInches;
        port = this.port;
        ultrasonic = new AnalogInput(port);
        lastLocation = ultrasonic.getValue() * valueToInches;
    }
    @Override
    protected void initDefaultCommand() {

    }
    public double getDistance(){
        return ultrasonic.getValue() * valueToInches;
    }
    public void reset(){
        lastLocation = ultrasonic.getValue()*valueToInches;
    }
    public double getDistanceGone(){
        return ultrasonic.getValue()*valueToInches - lastLocation;
    }
}
