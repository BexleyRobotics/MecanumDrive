package org.usfirst.frc.team4753.robot.commands;

import org.usfirst.frc.team4753.robot.Robot;
import org.usfirst.frc.team4753.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetSpeed extends Command {

	private Joystick stick;
	
    public SetSpeed(Joystick joy) 
    {
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	
    	stick = joy;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	double setSpeed;
    	setSpeed = stick.getZ();
    	if(setSpeed < -0.9)
    	{
    		setSpeed = -0.9;
    	}
    	setSpeed = (.5 + (setSpeed / 2));
    	DriveTrain.setMaxOutput(setSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
