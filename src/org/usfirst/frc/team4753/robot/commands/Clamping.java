package org.usfirst.frc.team4753.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team4753.robot.Robot.pneumatics;
import static org.usfirst.frc.team4753.robot.RobotMap.*;

/**
 *Clamping is a command which will turn the pneumatics to grab the tote on or off
 *
 *@author Nathan Brownstein
 */
public class Clamping extends Command 
{
	private boolean finished = false;
	
    public Clamping() 
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	finished = false;
    	if (clamped == -1)
    	{
//    		pneumatics.clamp();
    	}
    	else
    	{
//    		pneumatics.unclamp();
    	}
    	clamped = clamped *-1;
    	finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
