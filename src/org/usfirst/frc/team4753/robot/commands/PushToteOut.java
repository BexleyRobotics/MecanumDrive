package org.usfirst.frc.team4753.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4753.robot.Robot;

public class PushToteOut extends Command {
	@Override
	protected void initialize() {
		requires(Robot.arms);
	}

	@Override
	protected void execute() {
		Robot.arms.backward();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end()
	{
		Robot.arms.stop();
	}

	@Override
	protected void interrupted() {

	}

}