package org.usfirst.frc.team4753.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem 
{
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	DoubleSolenoid grabbing = new DoubleSolenoid(3, 4);
	Solenoid liftingOne = new Solenoid(2);
	Solenoid liftingTwo = new Solenoid(3);
	DoubleSolenoid pushBar = new DoubleSolenoid(1, 2);

		// Put methods for controlling this subsystem
		// here. Call these from Commands.


		/**
		 * Activates grabbing solenoid so that it grabs tote
		 * 
		 */
		public void eject() {
			pushBar.set(DoubleSolenoid.Value.kForward);
		}

		public void retract() {
			pushBar.set(DoubleSolenoid.Value.kReverse);
		}
		
		public void grab() {
			grabbing.set(DoubleSolenoid.Value.kForward);
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
			grabbing.set(DoubleSolenoid.Value.kForward);
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


