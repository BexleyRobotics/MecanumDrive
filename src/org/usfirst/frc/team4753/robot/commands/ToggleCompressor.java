package org.usfirst.frc.team4753.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team4753.robot.Robot.pneumatics;
import static org.usfirst.frc.team4753.robot.Robot.dashboard;

/**
 *
 */
public class ToggleCompressor extends Command {

	private boolean finished = false;
	private int toggle = -1;
	
    public ToggleCompressor() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(pneumatics);
    	requires(dashboard);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	toggle *= -1;
    	if(toggle > 0){
    		pneumatics.startCompressor();
    	}
    	else{
    		pneumatics.stopCompressor();
    	}
    	
    	dashboard.compressorState();
    	
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