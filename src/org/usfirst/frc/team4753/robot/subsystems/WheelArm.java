package org.usfirst.frc.team4753.robot.subsystems;

import org.usfirst.frc.team4753.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WheelArm extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private SpeedController left, middle, right;

	public WheelArm() {
		left = new Victor(RobotMap.LEFT_ARM_MOTOR);
		middle = new Victor(RobotMap.MIDDLE_ARM_MOTOR);
		right = new Victor(RobotMap.RIGHT_ARM_MOTOR);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void forward() {
		left.set(1);
		middle.set(1);
		right.set(1);
	}

	public void backward() {
		left.set(-1);
		middle.set(-1);
		right.set(-1);
	}

	public void stop() {
		left.set(0);
		middle.set(0);
		right.set(0);
	}
}
