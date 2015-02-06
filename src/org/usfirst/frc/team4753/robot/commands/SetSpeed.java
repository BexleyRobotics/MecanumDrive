package org.usfirst.frc.team4753.robot.commands;

import static org.usfirst.frc.team4753.robot.Robot.drivetrain;
import static org.usfirst.frc.team4753.robot.Robot.oi;
import edu.wpi.first.wpilibj.command.Command;

/**
 *SetSpeed - set output of motors using z axis of joystick
 *
 *@author nathan brownstein
 */
public class SetSpeed extends Command {

	private boolean finished = false;

	/**
	 * SetSpeed uses the Z axis of the joystick (throttle on ours) to tell the
	 * motors what percentage of power they are to use, down to 5% power
	 * requires drivetrain, joystick
	 * 
	 * @param joy
	 */
	public SetSpeed() {

		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(drivetrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double setSpeed;
		setSpeed = -oi.getZ();
		if (setSpeed < -0.9) {
			setSpeed = -0.9;
		}
		setSpeed = (.5 + (setSpeed / 2));
		drivetrain.setMaxOutput(setSpeed);
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
	protected void interrupted() 
	{
		end();
	}
}
