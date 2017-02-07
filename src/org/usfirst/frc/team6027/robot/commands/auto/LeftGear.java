package org.usfirst.frc.team6027.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team6027.robot.commands.DriveDistance;
import org.usfirst.frc.team6027.robot.commands.RotateDriveTrain;

public class LeftGear extends CommandGroup {
    public LeftGear(){
        addSequential(new DriveDistance(100));
        addSequential(new RotateDriveTrain(-30));
        addSequential(new DriveDistance(30));
    }
}
