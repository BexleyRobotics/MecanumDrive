package org.usfirst.frc.team4753.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *Autonomous- command group to coordinate what our robot will do during auto period at beginning of match
 *
 *@author Nathan Brownstein
 */
public class Autonomous extends CommandGroup {
    
    public  Autonomous() 
    {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	addSequential(new AutonomousMove(2.0));
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
