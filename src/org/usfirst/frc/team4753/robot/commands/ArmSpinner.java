package org.usfirst.frc.team4753.robot.commands;

import org.usfirst.frc.team4753.robot.RobotMap;
import static org.usfirst.frc.team4753.robot.Robot.*;

import edu.wpi.first.wpilibj.command.Command;

/**
 *ArmSpinner will be used by Dashboard as a way to set the arms using a button on SmartDashboard
 *
 *@author nathan brownstein
 */
public class ArmSpinner extends Command 
{
	private boolean finish;
    public ArmSpinner() 
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	finish = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	finish = false;
    	if (RobotMap.arms == 0)
    	{
    		arms.backward(-1.0);
    	}
    	else if (RobotMap.arms == 1)
    	{
    		arms.stop();
    	}
    	else if (RobotMap.arms == 2)
    	{
    		arms.forward();
    	}
    	finish = true;
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finish;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	finish = false;
    	RobotMap.arms++;
    	RobotMap.arms %= 3;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	end();
    }
}
