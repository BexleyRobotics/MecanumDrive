package org.usfirst.frc.team4753.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	// Drive Motor Indexes
	public static final int FRONT_LEFT_DRIVE_MOTOR = 0;
	public static final int FRONT_RIGHT_DRIVE_MOTOR = 1;
	public static final int BACK_LEFT_DRIVE_MOTOR = 8;
	public static final int BACK_RIGHT_DRIVE_MOTOR = 9;
	
	// Wheel motor indexes
	public static final int LEFT_ARM_MOTOR = 2;
	public static final int RIGHT_ARM_MOTOR = 3;
	//public static final int MIDDLE_ARM_MOTOR = 4;
	
	public static int clamped = -1;
	public static int lifted = 1;
	public static int STACK = 0;
	public static int arms = 1;
}
