package org.usfirst.frc.team4753.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team4753.robot.Robot.pneumatics;

/**
 *This command can be used to toggle the lifting Pneumatics to lift or lower totes
 *
 *@author nathan brownstein
 */
public class Lifting extends Command 
{
	private boolean up;
	private boolean finished;
    public Lifting() 
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	finished = false;
    	pneumatics.raise();
    	up = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	if (up = true)
    	{
    		pneumatics.lower();
    		up = false;
    	}
    	else if (up = false)
    	{
    		pneumatics.raise();
    		up = true;
    	}
    	finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	finished = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	end();
    }
}
