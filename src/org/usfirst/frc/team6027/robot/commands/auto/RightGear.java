package org.usfirst.frc.team6027.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team6027.robot.commands.DriveDistance;
import org.usfirst.frc.team6027.robot.commands.OpenGDS;
import org.usfirst.frc.team6027.robot.commands.RotateDriveTrain;

public class RightGear extends CommandGroup {
    public RightGear(){
        addSequential(new DriveDistance(-93));
        addSequential(new RotateDriveTrain(49));
        addSequential(new DriveDistance(-34));
        addSequential(new OpenGDS(1));
        addSequential(new DriveDistance(30));
        addSequential(new RotateDriveTrain(-49));
        addSequential(new DriveDistance(-120));
        addSequential(new RotateDriveTrain(45));
        addSequential(new DriveDistance(-120));
    }
}
