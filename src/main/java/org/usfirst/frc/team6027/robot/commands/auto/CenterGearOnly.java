package org.usfirst.frc.team6027.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team6027.robot.AutoMap;
import org.usfirst.frc.team6027.robot.commands.DriveDistance;
import org.usfirst.frc.team6027.robot.commands.OpenGDS;

public class CenterGearOnly extends CommandGroup {
    /**
     * Auto to do center gear and cross baseline
     * 1. Drive in revere 79 inches
     * 2. Open GDS for 1 second
     * 3. Drive 27 inches forward
     */
    public CenterGearOnly(){
        addSequential(new DriveDistance(-(AutoMap.wallToPeg-AutoMap.adjustment),false,0));
        addSequential(new OpenGDS(2));
        addSequential(new DriveDistance(30,false,0));
    }
}
