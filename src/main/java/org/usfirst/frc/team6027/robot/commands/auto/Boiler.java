package org.usfirst.frc.team6027.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team6027.robot.commands.DriveDistance;
import org.usfirst.frc.team6027.robot.commands.RotateDriveTrain;
import org.usfirst.frc.team6027.robot.commands.shooter.SpinVoltage;

public class Boiler extends CommandGroup {
    /**
     *
     * Auto mode for shooting balls in boiler.
     * 1. Drive 82 inches
     * 2. Rotate 90 degrees
     * 3. Drive 47 inches
     * 4. Drive back 3 inches
     * 5. Rotate 90 degrees
     * 6. Spin up to 78% indefinitely
     */
    public Boiler(){
        addSequential(new DriveDistance(82,false,0));
        addSequential(new RotateDriveTrain(90));
        addSequential(new DriveDistance(47,false, 0));
        addSequential(new DriveDistance(-3,false,0));
        addSequential(new RotateDriveTrain(-90));
        addSequential(new SpinVoltage(0.78,false));
    }
}
