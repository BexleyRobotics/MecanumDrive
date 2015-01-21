package org.usfirst.frc.team4753.robot.commands;

import org.usfirst.frc.team4753.robot.subsystems.Ejector;

import edu.wpi.first.wpilibj.command.Command;



/**
 *
 */
public class ToggleEjector extends Command {

    public ToggleEjector() 
    {
    	requires (Ejector);
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
    	Ejector.eject();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	while ()
    	
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	Ejector.retract();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
