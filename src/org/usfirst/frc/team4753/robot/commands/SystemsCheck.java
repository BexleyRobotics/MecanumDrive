package org.usfirst.frc.team4753.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *Systems Check will check that all of the other systems in the robot are working properly and are properly interfaced
 *
 *@author Nathan Brownstein
 */
public class SystemsCheck extends CommandGroup {
    
	private Command lifting = new Lifting();
	private Command clamping = new Clamping();
	
    public  SystemsCheck() 
    {
    	addSequential(clamping);
    	setTimeout(2);
    	addSequential(clamping);
    	setTimeout(2);
    	addSequential(lifting);
    	setTimeout(2);
    	addSequential(lifting);
    	setTimeout(2);
    	addSequential(new SpinArmsIn());
    	setTimeout(2);
    	addSequential(new Eject());
    	setTimeout(2);	
    }
}
