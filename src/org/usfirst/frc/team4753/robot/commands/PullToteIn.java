package org.usfirst.frc.team4753.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import static org.usfirst.frc.team4753.robot.Robot.arms;
import static org.usfirst.frc.team4753.robot.RobotMap.*;

public class PullToteIn extends Command {
	@Override
	protected void initialize() {
		requires(arms);
	}

	@Override
	protected void execute() 
	{
		arms.forward();
		if (STACK == 3)
		{
			STACK++;
		}
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