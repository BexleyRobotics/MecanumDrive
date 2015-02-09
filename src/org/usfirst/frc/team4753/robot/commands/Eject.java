package org.usfirst.frc.team4753.robot.commands;

import static org.usfirst.frc.team4753.robot.Robot.pneumatics;
import static org.usfirst.frc.team4753.robot.Robot.arms;
import static org.usfirst.frc.team4753.robot.Robot.oi;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.*;


/**
 *ToggleEjector - how we will tell the robot to push the totes from internal stacking mechanism using pneumatic subsystem
 *
 *@author nathan brownstein
 */
public class Eject extends Command {
	double speed;

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
    	
    	pneumatics.eject();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	speed = -(oi.getY());
    	arms.backward(speed);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	SmartDashboard.putInt(key, 0);
    	pneumatics.retract();
    	arms.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	end();
    }
}
