package org.usfirst.frc.team4753.robot.commands;

import static org.usfirst.frc.team4753.robot.Robot.arms;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *Activates arms while in Autonomous Mode
 *
 *@author Nathan Brownstein
 */
public class AutonomousArms extends Command {
	private Timer time;

    public AutonomousArms() 
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(arms);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	time.reset();
    	time.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	time.reset();
    	time.start();
    	arms.forward();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return (time.get() <= 15.0);
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	arms.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
