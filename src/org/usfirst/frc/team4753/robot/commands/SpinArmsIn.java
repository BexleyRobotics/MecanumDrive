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
public class SpinArmsIn extends Command {
	
	private boolean finished = false;
	
	public SpinArmsIn() {
		requires(arms);
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		arms.forward();
	}

	@Override
	protected boolean isFinished() {
		return finished;
	}

	@Override
	protected void end() 
	{
		finished = false;
	}

	@Override
	protected void interrupted() 
	{
		end();
	}

}