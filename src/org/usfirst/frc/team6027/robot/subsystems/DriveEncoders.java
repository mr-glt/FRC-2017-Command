package org.usfirst.frc.team6027.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;


public class DriveEncoders extends Subsystem {
    private Encoder encoderLeft;
    private Encoder encoderRight;

    public DriveEncoders(int leftChannelA, int leftChannelB, int rightChannelA,int rightChannelB,
                         double maxPeriod, int minRate, double distancePerPulse, boolean reverseDirection,int samplesToAverage) {

        encoderLeft  = new Encoder(leftChannelA, leftChannelB, reverseDirection, Encoder.EncodingType.k4X);
        encoderRight  = new Encoder(rightChannelA, rightChannelB, reverseDirection, Encoder.EncodingType.k4X);

        encoderLeft.setMaxPeriod(maxPeriod);
        encoderLeft.setMinRate(minRate);
        encoderLeft.setDistancePerPulse(distancePerPulse);
        encoderLeft.setSamplesToAverage(samplesToAverage);
        encoderRight.setMaxPeriod(maxPeriod);
        encoderRight.setMinRate(minRate);
        encoderRight.setDistancePerPulse(distancePerPulse);
        encoderRight.setSamplesToAverage(samplesToAverage);
    }

    @Override
    protected void initDefaultCommand() {
    }

    public double getLeftDistance(){
        return encoderLeft.getDistance();
    }
    public double getRightDistance(){
        return encoderRight.getDistance();
    }
    public double distanceDriven() {
        return (encoderLeft.getDistance()+encoderRight.getDistance())/2;
    }

    public int leftCount() {
        return encoderLeft.get();
    }
    public int rightCount() {
        return encoderRight.get();
    }

    public boolean direction() {
        return encoderLeft.getDirection();
    }

    public boolean stopped() {
        return encoderLeft.getStopped();
    }
    public void reset(){
        encoderLeft.reset();
        encoderRight.reset();
    }
}
