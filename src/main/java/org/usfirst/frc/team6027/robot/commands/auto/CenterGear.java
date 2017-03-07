package org.usfirst.frc.team6027.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team6027.robot.commands.DriveDistance;
import org.usfirst.frc.team6027.robot.commands.DriveDistanceFast;
import org.usfirst.frc.team6027.robot.commands.OpenGDS;
import org.usfirst.frc.team6027.robot.commands.RotateDriveTrain;
import org.usfirst.frc.team6027.robot.commands.shooter.SpinVoltage;

public class CenterGear extends CommandGroup {
    /**
     * Auto to do center gear, shoot balls, and cross baseline
     * 1. Drive in revere 79 inches
     * 2. Open GDS for 1 second
     * 3. Drive 27 inches forward
     * 4. Rotate drive train backwards 87 degrees
     * 5. Drive 94 inches in reverse
     * 6. Rotate 30 degrees backwards
     * 7. Spin shooter at 69% for 3 seconds
     * 8. Rotate drive train back 55 degrees
     * 9. Drive quickly 200 inches to cross baseline
     */
    public CenterGear(){
        addSequential(new DriveDistance(-79));
        addSequential(new OpenGDS(1));
        addSequential(new DriveDistance(27));
        addSequential(new RotateDriveTrain(-87));
        addSequential(new DriveDistance(-94));
        addSequential(new RotateDriveTrain(-30));
        addSequential(new SpinVoltage(0.69,true));
        addSequential(new RotateDriveTrain(-55));
        addSequential(new DriveDistanceFast(200));
    }
}
