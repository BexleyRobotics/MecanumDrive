package org.usfirst.frc.team4753.robot.commands;

import static org.usfirst.frc.team4753.robot.RobotMap.*;
import static org.usfirst.frc.team4753.robot.Robot.*;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StackTote extends Command 
{
	private boolean finish = false;

    public StackTote() 
    {
        requires(pneumatics);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
//    	pneumatics.clamp();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
//    	pneumatics.unclamp();
//    	setTimeout(.25);
    	
    	if(raised){
    		pneumatics.lower();
    		setTimeout(.25);
    	}
//    	pneumatics.clamp();
//    	setTimeout(.25);
    	pneumatics.raise();
    	STACK++;
    	raised = true;
    	finish = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return finish;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
//    	pneumatics.clamp();
    	pneumatics.raise();
    	finish = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	end();
    }
}
