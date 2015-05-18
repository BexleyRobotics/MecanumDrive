package org.usfirst.frc.team4753.robot.commands;

import static org.usfirst.frc.team4753.robot.Robot.arms;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ReverseArms extends Command {

private boolean finished = false;
	
	public ReverseArms() {
		requires(arms);
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		arms.backward(1.0);
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
