package org.usfirst.frc.team6027.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team6027.robot.commands.DriveDistance;
import org.usfirst.frc.team6027.robot.commands.OpenGDS;

public class CenterGear extends CommandGroup {
    public CenterGear(){
        addSequential(new DriveDistance(80));
        addSequential(new OpenGDS(5));
        addParallel(new DriveDistance(-10));
    }
}
