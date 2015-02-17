package org.usfirst.frc.team4753.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import static org.usfirst.frc.team4753.robot.Robot.arms;

/**
 * Spins arms inwards while held.
 * 
 * @author Ian Foreman
 * @author Nick LeBlanc
 *
 */
public class PullToteIn extends Command {
	
	public PullToteIn() {
		requires(arms);
	}
	
	@Override
	protected void initialize() {
		arms.forward();
	}

	@Override
	protected void execute() {
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() 
	{
		arms.stop();
	}

	@Override
	protected void interrupted() 
	{
		end();
	}

}