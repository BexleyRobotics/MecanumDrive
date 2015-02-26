package org.usfirst.frc.team4753.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team4753.robot.Robot.arms;

/**
 * Stops the arms
 * 
 * @author Ian Foreman
 */
public class StopArms extends Command {

	private boolean finished = false;
	
    public StopArms() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(arms);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	arms.stop();
    	finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	finished = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
