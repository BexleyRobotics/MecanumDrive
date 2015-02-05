package org.usfirst.frc.team4753.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import static org.usfirst.frc.team4753.robot.Robot.arms;

public class PullToteIn extends Command {
	@Override
	protected void initialize() {
		requires(arms);
	}

	@Override
	protected void execute() {
		arms.forward();
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
	protected void interrupted() {

	}

}