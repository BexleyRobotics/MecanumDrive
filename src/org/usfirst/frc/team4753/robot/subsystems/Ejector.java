package org.usfirst.frc.team4753.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * This is used to activate or deactivate the ejector bar, which will use
 * pneumatics requires that we create an ejectorBar in the OI
 */
public class Ejector extends Subsystem {

	DoubleSolenoid pushBar = new DoubleSolenoid(1, 2);

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public Ejector() {
	}

	public void initDefaultCommand() {

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void eject() {
		pushBar.set(DoubleSolenoid.Value.kForward);
	}

	public void retract() {
		pushBar.set(DoubleSolenoid.Value.kReverse);
	}
}
