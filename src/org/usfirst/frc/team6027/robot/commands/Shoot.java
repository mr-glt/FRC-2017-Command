package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team6027.robot.commands.shooter.EngageDeflector;
import org.usfirst.frc.team6027.robot.commands.shooter.SpinMeter;
import org.usfirst.frc.team6027.robot.commands.shooter.SpinUp;
import org.usfirst.frc.team6027.robot.commands.shooter.SpinVoltage;

public class Shoot extends CommandGroup {
    public Shoot(boolean isHigh){
        if(isHigh){
            addSequential(new SpinUp(0.5));
            addParallel(new SpinVoltage(0.5));
            addSequential(new SpinMeter());
        }
        else{
            addSequential(new SpinUp(0.5));
            addParallel(new SpinVoltage(0.5));
            addSequential(new SpinMeter());
            addParallel(new EngageDeflector());
        }
    }
}
