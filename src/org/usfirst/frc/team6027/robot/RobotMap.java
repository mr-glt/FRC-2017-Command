package org.usfirst.frc.team6027.robot;

public class RobotMap {
    //Motor Controllers
    public static int frontLeft = 0;
    public static int backLeft = 1;
    public static int frontRight = 2;
    public static int backRight = 3;
    public static int pickup = 4;
    public static int mainFlywheelPort = 5;
    public static int meterWheelPort = 6;
    public static int winchPort = 7;

    //Solenoids
    public static int solGDSOne;
    public static int solGDSTwo;
    public static int solWinchOne;
    public static int getSolWinchTwo;

    //Sensors
    public static int ultrasonicPort = 0;
    public static int leftEncoderA = 0;
    public static int leftEncoderB = 1;
    public static int rightEncoderA = 2;
    public static int rightEncoderB = 3;
    public static double encoderMaxPeriod = 0.1;
    public static int encoderMinRate = 10;
    public static double encoderDPP = 0.0095238095;
    public static int encoderSamplesToAvg = 7;
    public static boolean encoderReverseDirection = true;
    public static int winchLimitPort = 0;

    //Constants
    public static double valueToInches = 0.125;
    public static final int IMG_WIDTH = 320;
    public static final int IMG_HEIGHT = 240;
    public static final int exposure = 5;
    public static final int regularExposure = 40;
    public static final double FOV = 66;

    //OI Ports
    public static final int joystickPort = 0;
    public static final int controllerPort = 1;
}
