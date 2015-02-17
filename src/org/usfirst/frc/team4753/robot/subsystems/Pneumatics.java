package org.usfirst.frc.team4753.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import static org.usfirst.frc.team4753.robot.RobotMap.*;

/**
 *Pneumatics - how we will control all pneumatics within our robot, will hopefully make controlling easier overall
 *
 *@author Nathan Brownstein
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
    
    
	private DoubleSolenoid clamping;
	private DoubleSolenoid lifting;
	private DoubleSolenoid pushing;
	private Compressor compressor;
	
	public Pneumatics(){
//		clamping = new DoubleSolenoid(CLAMPING_CLAMP,CLAMPING_UNCLAMP);
		lifting = new DoubleSolenoid(LIFTING_UP,LIFTING_DOWN);
		pushing = new DoubleSolenoid(PUSHING_EJECT, PUSHING_RETRACT);
		compressor = new Compressor();
		compressor.setClosedLoopControl(true);
		
	}

		// Put methods for controlling this subsystem
		// here. Call these from Commands.


		/**
		 * Extends the ejector bar
		 * 
		 */
		public void eject() {
			pushing.set(DoubleSolenoid.Value.kForward);
		}

		/**
		 * Retracts the ejector bar
		 */
		public void retract() {
			pushing.set(DoubleSolenoid.Value.kReverse);
		}
		
//		public void clamp() {
//			clamping.set(DoubleSolenoid.Value.kForward);
//		}

		/**
		 * Retracts pistons so that tote rises false = raise true = lower
		 */
		public void raise() {
			lifting.set(DoubleSolenoid.Value.kForward);
		}

		/**
		 * Releases pistons so that tote is released
		 * 
		 */
//		public void unclamp() {
//			clamping.set(DoubleSolenoid.Value.kReverse);
//		}

		/**
		 * activates pistons so that tote is lowered
		 * 
		 */
		public void lower() {
			lifting.set(DoubleSolenoid.Value.kReverse);
		}
		
		/**
		 * Take compressor off of closed loop and start it manually
		 * 
		 * @author Ian Foreman
		 */
		public void startCompressor(){
			compressor.setClosedLoopControl(false);
			compressor.start();
		}
		
		/**
		 * Manually stops compressor
		 * 
		 * @author Ian Foreman
		 */
		public void stopCompressor(){
			compressor.stop();
		}
		
		/**
		 * Starts compressor on closed loop control
		 * 
		 * @author Ian Foreman
		 */
		public void startClosedLoop(){
			compressor.setClosedLoopControl(true);
		}
}


