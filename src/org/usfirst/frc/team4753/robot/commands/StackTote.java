package org.usfirst.frc.team4753.robot.commands;

import static org.usfirst.frc.team4753.robot.Robot.pneumatics;

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
    	finish = false;
    }

    protected void execute() 
    {
    	pneumatics.release();
    	setTimeout(1);
    	pneumatics.lower();
    	setTimeout(2);
    	pneumatics.grab();
    	setTimeout(1);
    	pneumatics.raise();
    	setTimeout(2);
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
