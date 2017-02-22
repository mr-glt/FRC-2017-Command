package org.usfirst.frc.team6027.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team6027.robot.commands.DriveDistance;
import org.usfirst.frc.team6027.robot.commands.RotateDriveTrain;
import org.usfirst.frc.team6027.robot.commands.shooter.SpinVoltage;

public class Boiler extends CommandGroup {
    public Boiler(){
        addSequential(new DriveDistance(20));
        //addSequential(new RotateDriveTrain(90));
        addSequential(new SpinVoltage(0.69));
    }
}
