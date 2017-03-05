package org.usfirst.frc.team6027.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team6027.robot.commands.DriveDistance;

public class Forward extends CommandGroup {
    /**
     * Drive forwards to 300 inches
     */
    public Forward(){
        addSequential(new DriveDistance(300));
    }
}
