package org.usfirst.frc.team4753.robot.commands;

import org.usfirst.frc.team4753.robot.Robot;
import org.usfirst.frc.team4753.robot.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.command.Command;


/**
 *StackTote- will activate internal stacking mechanism, hold totes up until it recieves new tote, then activate to grab entire stack
 *
 *@author nathan brownstein
 */
public class StackTote extends Command 
{
	private boolean finish;
	
	Pneumatics stack = new Pneumatics();
    public StackTote() 
    {
    	requires(Robot.pneumatics);
    	
    }

    protected void initialize() 
    {
    	finish = false;
    }

    protected void execute() 
    {
    	stack.release();
    	setTimeout(1);
    	stack.lower();
    	setTimeout(2);
    	stack.grab();
    	setTimeout(1);
    	stack.raise();
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
