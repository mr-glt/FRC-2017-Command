package org.usfirst.frc.team6027.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6027.robot.Robot;


public class DriveEncoders extends Subsystem {
    private Encoder encoder = Robot.oi.getDriveEncoder();

    public DriveEncoders(double maxPeriod, int minRate, double distancePerPulse, boolean reverseDirection,int samplesToAverage) {
        encoder.setMaxPeriod(maxPeriod);
        encoder.setMinRate(minRate);
        encoder.setDistancePerPulse(distancePerPulse);
        encoder.setReverseDirection(reverseDirection);
        encoder.setSamplesToAverage(samplesToAverage);
    }

    @Override
    protected void initDefaultCommand() {

    }

    public double distanceDriven() {
        SmartDashboard.putNumber("Distance", encoder.getDistance());
        return encoder.getDistance();
    }

    public int count() {
        SmartDashboard.putNumber("Count", encoder.get());
        return encoder.get();
    }

    public boolean direction() {
        SmartDashboard.putBoolean("Direction", encoder.getDirection());
        return encoder.getDirection();
    }

    public boolean stopped() {
        SmartDashboard.putBoolean("Stopped", encoder.getStopped());
        return encoder.getStopped();
    }
    public void reset(){
        encoder.reset();
    }
}
