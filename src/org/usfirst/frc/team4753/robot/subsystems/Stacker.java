package org.usfirst.frc.team4753.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Stacker extends Subsystem {


	Solenoid grabbing = new Solenoid(1);
	Solenoid liftingOne = new Solenoid(2);
	Solenoid liftingTwo = new Solenoid(3);

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());

	}

	/**
	 * Activates grabbing solenoid so that it grabs tote
	 * 
	 */
	public void grab() {
		grabbing.set(true);
	}

	/**
	 * Retracts pistons so that tote rises false = raise true = lower
	 */
	public void raise() {
		liftingOne.set(false);
		liftingTwo.set(false);
	}

	/**
	 * Releases pistons so that tote is released
	 * 
	 */
	public void release() {
		grabbing.set(false);
	}

	/**
	 * activates pistons so that tote is lowered
	 * 
	 */
	public void lower() {
		liftingOne.set(true);
		liftingTwo.set(true);
	}
}
