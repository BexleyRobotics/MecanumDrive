package org.usfirst.frc.team4753.robot.commands;

import static org.usfirst.frc.team4753.robot.Robot.pneumatics;
import static org.usfirst.frc.team4753.robot.Robot.dashboard;

import edu.wpi.first.wpilibj.command.Command;


/**
 *StackTote- will activate internal stacking mechanism, hold totes up until it recieves new tote, then activate to grab entire stack
 *
 *@author nathan brownstein
 */
public class StackTote extends Command 
{
	private boolean finish;
	
	
    public StackTote() 
    {
    	requires(pneumatics);
    	
    }

    protected void initialize() 
    {
    	
    }

    protected void execute() 
    {
    	finish = false;
    	pneumatics.unclamp();
    	setTimeout(1);
    	pneumatics.lower();
    	setTimeout(2);
    	pneumatics.clamp();
    	setTimeout(1);
    	pneumatics.raise();
    	setTimeout(2);
    	dashboard.addTote();
    	finish = true;
    }

    protected boolean isFinished() 
    {
        return finish;
    }

    protected void end() 
    {
    	finish = false;
    }

	protected void interrupted() 
	{
	}
}
