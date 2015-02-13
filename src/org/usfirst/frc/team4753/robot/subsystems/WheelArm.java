package org.usfirst.frc.team4753.robot.subsystems;

import static org.usfirst.frc.team4753.robot.RobotMap.LEFT_ARM_MOTOR;
import static org.usfirst.frc.team4753.robot.RobotMap.MIDDLE_ARM_MOTOR;
import static org.usfirst.frc.team4753.robot.RobotMap.RIGHT_ARM_MOTOR;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WheelArm extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private SpeedController left, middle, right;
	private double reverseMax = 1.0; 

	public WheelArm() {
		left = new Talon(LEFT_ARM_MOTOR);
		//middle = new Talon(MIDDLE_ARM_MOTOR);
		right = new Talon(RIGHT_ARM_MOTOR);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void forward() {
		left.set(1);
		//middle.set(1);
		right.set(1);
	}

	public void backward(double speed) {
		left.set(speed * reverseMax);
		//middle.set(-1);
		right.set(speed * reverseMax);
	}

	public void stop() {
		left.set(0);
		//middle.set(0);
		right.set(0);
	}
	
	public void setReverseMax(double limit){
		reverseMax = limit;
	}
}
