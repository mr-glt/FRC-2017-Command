package org.usfirst.frc.team6027.robot.commands;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usfirst.frc.team6027.robot.Robot;
import org.usfirst.frc.team6027.robot.RobotMap;

public class ResetWinch extends Command{
    private Logger logger = LoggerFactory.getLogger(ResetWinch.class);
    //DigitalInput limitSwitch = new DigitalInput(RobotMap.winchLimitPort);
    public ResetWinch() {
        requires(Robot.winch);
        requires(Robot.winchPush);
    }
    @Override
    protected void initialize() {
        logger.debug("Resetting Winch");
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
        logger.debug("Winch reset");
    }

    @Override
    protected void interrupted() {
        Robot.winch.off();
        logger.debug("Winch reset interrupted");
    }
}
