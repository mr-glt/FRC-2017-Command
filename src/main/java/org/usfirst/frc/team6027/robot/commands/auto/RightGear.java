package org.usfirst.frc.team6027.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team6027.robot.commands.DriveDistance;
import org.usfirst.frc.team6027.robot.commands.OpenGDS;
import org.usfirst.frc.team6027.robot.commands.RotateDriveTrain;

public class RightGear extends CommandGroup {
    /**
     * Delivers a gear to the right peg, then crosses baseline.
     * 1. Drive backwards 90 inches
     * 2. Rotate backwards 49 degrees
     * 3. Drive 29 inches backwards
     * 4. Open GDS for 1 second
     * 5. Drive 30 inches forward
     * 6. Rotate 49 inches
     * 7. Drive 240 inches backwards
     */
    public RightGear(){
        addSequential(new DriveDistance(-90,false));
        addSequential(new RotateDriveTrain(-49));
        addSequential(new DriveDistance(-29,false));
        addSequential(new OpenGDS(1));
        addSequential(new DriveDistance(30,false));
        addSequential(new RotateDriveTrain(49));
        addSequential(new DriveDistance(-240,true));
    }
}
