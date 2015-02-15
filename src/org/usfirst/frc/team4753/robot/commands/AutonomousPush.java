package org.usfirst.frc.team4753.robot.commands;

import static org.usfirst.frc.team4753.robot.Robot.arms;
import static org.usfirst.frc.team4753.robot.Robot.pneumatics;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;

/**
 *Used to push out all of the totes stacked during the Auto period
 *
 *@author Nathan Brownstein
 */
public class AutonomousPush extends Command {
	private Timer time;
	public AutonomousPush() 
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		requires(arms);
		requires(pneumatics);
		
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	time.reset();
    	time.start();
    	arms.backward(-1.0);
    	pneumatics.unclamp();
   		pneumatics.eject();
    		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return (time.get() >= 3.0);
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	arms.stop();
    	pneumatics.retract();
    	pneumatics.clamp();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	end();
    }
}
