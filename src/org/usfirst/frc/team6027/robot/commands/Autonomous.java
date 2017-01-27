package org.usfirst.frc.team6027.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup{
    public Autonomous(){
        addSequential(new DriveDistance(20));
        //addParallel(new Aim());
        addParallel(new DriveDistance(20));
    }
}
