package org.usfirst.frc.team4753.robot.commands;

import org.usfirst.frc.team4753.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *AutonomousMove - designed to move robot forward for certain amount of time, which we will change as required
 *
 *@author nathan brownstein
 */
public class AutonomousMove extends Command {
	
	private Timer time;
	private double timetodrive;
	DriveTrain speed = new DriveTrain();

    public AutonomousMove(double timing) 
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	timetodrive = timing;
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
    	speed.setMaxOutput(.25);
    	speed.drive(1, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	return (time.get() >= timetodrive);
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	speed.drive(0, 0);
    	time.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
