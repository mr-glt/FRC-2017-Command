package org.usfirst.frc.team6027.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team6027.robot.commands.DriveDistance;
import org.usfirst.frc.team6027.robot.commands.OpenGDS;
import org.usfirst.frc.team6027.robot.commands.RotateDriveTrain;

public class LeftGear extends CommandGroup {
    /**
     * Delivers a gear to left peg, and then crosses baseline.
     * 1. Drive backward to 50 inches
     * 2. Rotate 50 degrees
     * 3. Drive 70 inches backward to peg
     * 4. Open GDS for 1 second
     * 5. Drive 35 inches forwards
     * 6. Rotate back 50 degrees
     * 7. Drive 120 inches backwards
     * 8. Rotate 45 degrees
     * 9. Drive 120 inches backwards
     */
    public LeftGear(){
        addSequential(new DriveDistance(-50,false));
        addSequential(new RotateDriveTrain(50));
        addSequential(new DriveDistance(-70,false));
        addSequential(new OpenGDS(1));
        addSequential(new DriveDistance(35,false));
        addSequential(new RotateDriveTrain(-50));
        addSequential(new DriveDistance(-120,true));
        addSequential(new RotateDriveTrain(45));
        addSequential(new DriveDistance(-120,true));
    }
}