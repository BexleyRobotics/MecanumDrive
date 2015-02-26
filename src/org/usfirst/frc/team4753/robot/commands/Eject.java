package org.usfirst.frc.team4753.robot.commands;

import static org.usfirst.frc.team4753.robot.Robot.pneumatics;
import static org.usfirst.frc.team4753.robot.Robot.arms;
import static org.usfirst.frc.team4753.robot.Robot.oi;
import static org.usfirst.frc.team4753.robot.RobotMap.*;

import edu.wpi.first.wpilibj.command.Command;



/**
 *ToggleEjector - how we will tell the robot to push the totes from internal stacking mechanism using pneumatic subsystem
 *
 *@author Nathan Brownstein
 */
public class Eject extends Command {
	double speed;
	private boolean finished = false;
    public Eject() 
    {
    	requires (pneumatics);
    	requires(arms);
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
    	if(!ejected){
    		if(raised){
    			pneumatics.lower();
    			raised = false;
    		}
        	pneumatics.eject();
        	ejected = true;
        	
    	}
    	
    	speed = -(oi.getY());
    	arms.backward(speed);
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
