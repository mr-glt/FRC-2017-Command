package org.usfirst.frc.team6027.robot.commands.shooter;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6027.robot.Robot;

public class SpinRPM extends Command {
    private PIDController pid;
	Encoder enc = new Encoder(5,4, false, Encoder.EncodingType.k4X);
	
    public SpinRPM(double rpm){
    	rpm = rpm/60;
        requires(Robot.flywheel);
    	enc.setMaxPeriod(0.1);
    	enc.setMinRate(10);
    	enc.setDistancePerPulse(0.05);
    	enc.setReverseDirection(true);
    	enc.setSamplesToAverage(7);
        pid = new PIDController(0.27, 0, 0, enc, new pidOutput());
        pid.setAbsoluteTolerance(100);
        pid.setSetpoint(rpm);
    }
    @Override
    protected void initialize() {
    	pid.enable();
    }

    @Override
    protected void execute() {
		SmartDashboard.putNumber("RPM", enc.getRate()*60);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        pid.disable();
        Robot.flywheel.stopFlywheel();
    }

    @Override
    protected void interrupted() {
        pid.disable();
        Robot.flywheel.stopFlywheel();
    }
    private class pidOutput implements PIDOutput {
        @Override
        public void pidWrite(double output) {
                Robot.flywheel.setFlywheelVoltage(output, true);
        }
    }
}
