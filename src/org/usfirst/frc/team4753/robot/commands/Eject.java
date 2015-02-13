package org.usfirst.frc.team4753.robot.commands;

import static org.usfirst.frc.team4753.robot.Robot.pneumatics;
import static org.usfirst.frc.team4753.robot.Robot.arms;
import static org.usfirst.frc.team4753.robot.Robot.oi;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team4753.robot.Robot.dashboard;


/**
 *ToggleEjector - how we will tell the robot to push the totes from internal stacking mechanism using pneumatic subsystem
 *
 *@author nathan brownstein
 */
public class Eject extends Command {
	double speed;
	private boolean finished;
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
    	finished = false;
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	pneumatics.eject();
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
    	dashboard.resetTotes();
    	pneumatics.retract();
    	arms.stop();
    	finished = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	end();
    }
}
