package org.usfirst.frc.team6027.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team6027.robot.commands.DriveDistance;
import org.usfirst.frc.team6027.robot.commands.DriveDistanceFast;
import org.usfirst.frc.team6027.robot.commands.OpenGDS;
import org.usfirst.frc.team6027.robot.commands.RotateDriveTrain;

public class CenterGear extends CommandGroup {
    public CenterGear(){
        addSequential(new DriveDistance(-79));
        addSequential(new OpenGDS(1));
        addSequential(new DriveDistance(27));
        addSequential(new RotateDriveTrain(-87));
        addSequential(new DriveDistance(-94));
        addSequential(new RotateDriveTrain(-30));
        addSequential(new OpenGDS(2));
        addSequential(new RotateDriveTrain(-55));
        addSequential(new DriveDistanceFast(200));
    }
}
