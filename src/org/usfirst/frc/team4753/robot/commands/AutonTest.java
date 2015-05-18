package org.usfirst.frc.team4753.robot.commands;

import org.usfirst.frc.team4753.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team4753.robot.Robot.drivetrain;
import static org.usfirst.frc.team4753.robot.Robot.dashboard;

/**
 *
 */
public class AutonTest extends Command {
	
	boolean finished = false;
	Timer t;
	double speed = 0.5, duration = 1.5;

    public AutonTest() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(drivetrain);
    	requires(dashboard);
    	t = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	speed = (Robot.oi.getZ() + 1.0)/2;
    	duration = (Robot.oi.getZ2() + 1.0) * 2.5;
    	dashboard.autoSpeed(speed, duration);
    	t.reset();
    	t.start();
    	drivetrain.drive(-speed, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	//finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return t.get() > duration;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//finished = false;
    	t.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
