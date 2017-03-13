package org.usfirst.frc.team6027.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team6027.robot.commands.DriveDistance;
import org.usfirst.frc.team6027.robot.commands.shooter.SpinVoltage;

public class Boiler extends CommandGroup {
    /**
     *
     * Auto mode for shooting balls in boiler.
     * 1. Drive 20 inches
     * 2. Spin up to 69% indefinitely
     */
    public Boiler(){
        addSequential(new DriveDistance(20,false));
        addSequential(new SpinVoltage(0.69,false));
    }
}
