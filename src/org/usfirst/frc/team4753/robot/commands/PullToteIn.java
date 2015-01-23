package org.usfirst.frc.team4753.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4753.robot.Robot;

public class PullToteIn extends Command {
	@Override
	protected void initialize() {
		requires(Robot.arms);
	}

	@Override
	protected void execute() {
		Robot.arms.forward();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {

	}

}