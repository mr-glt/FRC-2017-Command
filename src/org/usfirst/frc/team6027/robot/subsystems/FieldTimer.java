package org.usfirst.frc.team6027.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6027.robot.Robot;
import org.usfirst.frc.team6027.robot.commands.ResetWinch;
import org.usfirst.frc.team6027.robot.commands.WinchOpen;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A subsystem that runs tasks that trigger when a time is reached.
 */
public class FieldTimer extends Subsystem{
    private Timer timer = new Timer();

    /**
     * There is no default command.
     */
    @Override
    protected void initDefaultCommand() {

    }

    /**
     * Runs a timer that sets the solenoid to the proper position at the start of auto.
     */
    public void endTimer(){
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new ResetWinch();
                Robot.oi.getController().setRumble(Joystick.RumbleType.kLeftRumble,1);
            }
        }, 105000); //105 seconds
    }

}
