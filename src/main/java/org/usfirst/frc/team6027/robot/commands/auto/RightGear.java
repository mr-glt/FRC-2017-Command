package org.usfirst.frc.team6027.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team6027.robot.AutoMap;
import org.usfirst.frc.team6027.robot.commands.DriveDistance;
import org.usfirst.frc.team6027.robot.commands.OpenGDS;
import org.usfirst.frc.team6027.robot.commands.RotateDriveTrain;

public class RightGear extends CommandGroup {
    /**
     * Delivers a gear to the right peg, then crosses baseline.
     * 1. Drive backwards 50 inches
     * 2. Rotate backwards 50 degrees
     * 3. Drive 70 inches backwards
     * 4. Open GDS for 1 second
     * 5. Drive 35 inches forward
     * 6. Rotate 50 degrees
     * 7. Drive 240 inches backwards
     */
    public RightGear(){
        addSequential(new DriveDistance(-(AutoMap.sideForward-AutoMap.adjustment),false,0));
        addSequential(new RotateDriveTrain(-AutoMap.sideTurn));
        addSequential(new DriveDistance(-(AutoMap.sideIn),false,-45));
        addSequential(new OpenGDS(1));
        addSequential(new DriveDistance(35,false,-45));
        addSequential(new RotateDriveTrain(0));
        addSequential(new DriveDistance(-240,true,0));
    }
}
