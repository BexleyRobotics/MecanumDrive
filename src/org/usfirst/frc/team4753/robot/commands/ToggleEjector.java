package org.usfirst.frc.team4753.robot.commands;

import org.usfirst.frc.team4753.robot.Robot;
import org.usfirst.frc.team4753.robot.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.command.Command;



/**
 *ToggleEjector - how we will tell the robot to push the totes from internal stacking mechanism using pneumatic subsystem
 *
 *@author nathan brownstein
 */
public class ToggleEjector extends Command {

    public ToggleEjector() 
    {
    	requires (Robot.pneumatics);
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
    	Robot.pneumatics.eject();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	Robot.pneumatics.retract();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
