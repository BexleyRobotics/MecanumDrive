package org.usfirst.frc.team4753.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *Systems Check will check that all of the other systems in the robot are working properly and are properly interfaced
 *
 *@author nathan brownstein
 */
public class SystemsCheck extends CommandGroup {
    
    public  SystemsCheck() 
    {
    	addSequential(new Clamping());
    	setTimeout(2);
    	addSequential(new Clamping());
    	setTimeout(2);
    	addSequential(new Lifting());
    	setTimeout(2);
    	addSequential(new Lifting());
    	setTimeout(2);
    	addSequential(new PullToteIn());
    	setTimeout(2);
    	addSequential(new Eject());
    	setTimeout(2);	
    }
}
