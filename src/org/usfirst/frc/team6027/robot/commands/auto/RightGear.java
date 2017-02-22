package org.usfirst.frc.team6027.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team6027.robot.commands.DriveDistance;
import org.usfirst.frc.team6027.robot.commands.OpenGDS;
import org.usfirst.frc.team6027.robot.commands.RotateDriveTrain;

public class RightGear extends CommandGroup {
    public RightGear(){
        addSequential(new DriveDistance(100));
        addSequential(new RotateDriveTrain(30));
        addSequential(new DriveDistance(30));
        addSequential(new OpenGDS(3));
    }
}
