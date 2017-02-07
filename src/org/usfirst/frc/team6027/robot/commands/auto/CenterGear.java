package org.usfirst.frc.team6027.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team6027.robot.commands.DriveDistance;

public class CenterGear extends CommandGroup {
    public CenterGear(){
        addSequential(new DriveDistance(100));
    }
}
