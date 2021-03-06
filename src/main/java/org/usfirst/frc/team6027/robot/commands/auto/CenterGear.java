package org.usfirst.frc.team6027.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team6027.robot.AutoMap;
import org.usfirst.frc.team6027.robot.commands.DriveDistance;
import org.usfirst.frc.team6027.robot.commands.DriveDistanceFast;
import org.usfirst.frc.team6027.robot.commands.OpenGDS;
import org.usfirst.frc.team6027.robot.commands.RotateDriveTrain;
import org.usfirst.frc.team6027.robot.commands.shooter.SpinVoltage;

public class CenterGear extends CommandGroup {
    /**
     * Auto to do center gear, shoot balls, and cross baseline
     * 1. Drive in revere 67 inches
     * 2. Open GDS for 1 second
     * 3. Drive 27 inches forward
     * 4. Rotate drive train backwards 90 degrees
     * 5. Drive 94 inches in reverse
     * 6. Rotate 45 degrees backwards
     * 7. Spin shooter at 69% for 3 seconds
     * 8. Rotate drive train back 45 degrees
     * 9. Drive quickly 80 inches to cross baseline
     */
    public CenterGear(){
        addSequential(new DriveDistance(-(AutoMap.wallToPeg-AutoMap.adjustment),false,0));
        addSequential(new OpenGDS(1));
        addSequential(new DriveDistance(27,false,0));
        addSequential(new RotateDriveTrain(-90));
        addSequential(new DriveDistance(-94,true,-90));
        addSequential(new RotateDriveTrain(-135));
        addSequential(new SpinVoltage(0.69,true));
        addSequential(new RotateDriveTrain(-180));
        addSequential(new DriveDistanceFast(80));
    }
}
