package org.usfirst.frc.team4753.robot.subsystems;

import org.usfirst.frc.team4753.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private RobotDrive drive;

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	/**
	 * creates DriveTrain
	 * 
	 */
	public DriveTrain() {
		drive = new RobotDrive(RobotMap.LEFT_MOTOR, RobotMap.RIGHT_MOTOR);

	}

	/**
	 * sets max speed
	 * 
	 * @param speed
	 */
	public void setMaxOutput(double speed) {// sets maximum output for drive
											// train based on the speed variable
		drive.setMaxOutput(speed);
	}

	/**
	 * sets driving parameters
	 * 
	 * @param y
	 *            percentage of speed
	 * @param x
	 *            extent of curvature
	 */
	public void drive(double y, double x) {// sets a distance to travel y and
											// and an extent to curve x

		double left, right;
		left = y + x;
		right = y - x;
		drive.setLeftRightMotorOutputs(left, right);

	}
}
