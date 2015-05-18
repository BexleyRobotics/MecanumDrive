package org.usfirst.frc.team4753.robot.subsystems;

// Static imports for motor indexes
//import static org.usfirst.frc.team4753.robot.RobotMap.FRONT_LEFT_DRIVE_MOTOR;
//import static org.usfirst.frc.team4753.robot.RobotMap.FRONT_RIGHT_DRIVE_MOTOR;
//import static org.usfirst.frc.team4753.robot.RobotMap.BACK_LEFT_DRIVE_MOTOR;
//import static org.usfirst.frc.team4753.robot.RobotMap.BACK_RIGHT_DRIVE_MOTOR;
import static org.usfirst.frc.team4753.robot.RobotMap.LEFT_MOTOR;
import static org.usfirst.frc.team4753.robot.RobotMap.RIGHT_MOTOR;


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
//		drive = new RobotDrive(FRONT_LEFT_DRIVE_MOTOR,BACK_LEFT_DRIVE_MOTOR, 
//				FRONT_RIGHT_DRIVE_MOTOR, BACK_RIGHT_DRIVE_MOTOR);
		drive = new RobotDrive(LEFT_MOTOR, RIGHT_MOTOR);

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
	public void drive(double y, double x) {

		double left, right;
		left = -y - x;
		right = -y + x;
		drive.setLeftRightMotorOutputs(left, right);

	}
}
