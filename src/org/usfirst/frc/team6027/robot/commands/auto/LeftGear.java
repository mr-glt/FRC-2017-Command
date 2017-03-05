package org.usfirst.frc.team6027.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team6027.robot.commands.DriveDistance;
import org.usfirst.frc.team6027.robot.commands.OpenGDS;
import org.usfirst.frc.team6027.robot.commands.RotateDriveTrain;

public class LeftGear extends CommandGroup {
    public LeftGear(){
        addSequential(new DriveDistance(-90));
        addSequential(new RotateDriveTrain(-49));
        addSequential(new DriveDistance(-29));
        addSequential(new OpenGDS(1));
        addSequential(new DriveDistance(30));
        addSequential(new RotateDriveTrain(49));
        addSequential(new DriveDistance(-240));
    }
}
