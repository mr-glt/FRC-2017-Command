package org.usfirst.frc.team6027.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * A subsystem to operate the encoders located on the drivetrain.
 * @author Charlie Wade
 * @version Post-Build
 */
public class DriveEncoders extends Subsystem {
    private Encoder encoderLeft;
    private Encoder encoderRight;

    /**
     * Constructs left and right encoders to be used by the subsystem
     * @param leftChannelA DIO port for the left encoder and channel a
     * @param leftChannelB DIO port for the left encoder and channel b
     * @param rightChannelA DIO port for the right encoder and channel a
     * @param rightChannelB DIO port for the right encoder and channel b
     * @param maxPeriod max period to be considered stopped
     * @param minRate max rate to be considered stopped
     * @param distancePerPulse value to convert a pulse into a distance. This is based on encoder resolution and wheel size.
     * @param reverseDirection should the encoder direction be reversed
     * @param samplesToAverage number of samples to average to calculate period
     */
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

    /**
     * No default command.
     */
    @Override
    protected void initDefaultCommand() {
    }

    /**
     *
     * @return distance in inches of the left encoder
     */
    public double getLeftDistance(){
        return encoderLeft.getDistance();
    }

    /**
     *
     * @return distance in inches of the right encoder
     */
    public double getRightDistance(){
        return encoderRight.getDistance();
    }

    /**
     *
     * @return distance driver based on one encoder
     */
    public double distanceDriven() {
        return encoderLeft.getDistance();
    }

    /**
     *
     * @return number of pulses on left encoder
     */
    public int leftCount() {
        return encoderLeft.get();
    }

    /**
     *
     * @return number of pulses on right encoder
     */
    public int rightCount() {
        return encoderRight.get();
    }

    /**
     *
     * @return direction the robot is was last moving at, either forward or backward
     */
    public boolean direction() {
        return encoderLeft.getDirection();
    }

    /**
     *
     * @return is the robot moving
     */
    public boolean stopped() {
        return encoderLeft.getStopped();
    }

    /**
     * Resets encoder counts back to zero.
     */
    public void reset(){
        encoderLeft.reset();
        encoderRight.reset();
    }

    /**
     *
     * @return constructed left encoder
     */
    public Encoder getEncoderLeft(){
        return encoderLeft;
    }

    /**
     *
     * @return constructed right encoder
     */
    public Encoder getEncoderRight(){
        return encoderRight;
    }
}
