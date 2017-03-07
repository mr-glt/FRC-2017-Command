package org.usfirst.frc.team6027.robot.commands;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6027.robot.Robot;
import org.usfirst.frc.team6027.robot.RobotMap;

public class ResetWinch extends Command{
    //DigitalInput limitSwitch = new DigitalInput(RobotMap.winchLimitPort);
    public ResetWinch() {
        requires(Robot.winch);
        requires(Robot.winchPush);
    }
    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.winch.on();
        Robot.winchPush.setLock(false);
    }

    @Override
    protected boolean isFinished() {
        return false; //limitSwitch.get();
    }

    @Override
    protected void end() {
        Robot.winch.off();
    }

    @Override
    protected void interrupted() {
        Robot.winch.off();
    }
}
