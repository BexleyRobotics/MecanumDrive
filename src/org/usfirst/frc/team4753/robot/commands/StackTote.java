package org.usfirst.frc.team4753.robot.commands;

import org.usfirst.frc.team4753.robot.Robot;
import org.usfirst.frc.team4753.robot.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class StackTote extends Command 
{
	Pneumatics stack = new Pneumatics();
    public StackTote() 
    {
    	requires(Robot.pneumatics);
    	
    }

    protected void initialize() 
    {
    	
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
    }

    protected boolean isFinished() 
    {
        return false;
    }

    protected void end() 
    {
    }

	protected void interrupted() 
	{
	}
}
