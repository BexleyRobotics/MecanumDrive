package org.usfirst.frc.team4753.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;
	public static final int LEFT_DRIVE_MOTOR = 0;
	public static final int RIGHT_DRIVE_MOTOR = 9;
	public static final int LEFT_ARM_MOTOR = 1;
	public static final int RIGHT_ARM_MOTOR = 2;
	public static final int MIDDLE_ARM_MOTOR = 3;
	public static int STACK = 0;
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
