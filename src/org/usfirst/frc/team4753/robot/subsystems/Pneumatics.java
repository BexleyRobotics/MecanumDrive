package org.usfirst.frc.team4753.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import static org.usfirst.frc.team4753.robot.RobotMap.*;

/**
 *Pneumatics - how we will control all pneumatics within our robot, will hopefully make controlling easier overall
 *
 *@author nathan brownstein
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
		clamping = new DoubleSolenoid(CLAMPING_FORWARD,CLAMPING_REVERSE);
		lifting = new DoubleSolenoid(LIFTING_FORWARD,LIFTING_REVERSE);
		pushing = new DoubleSolenoid(PUSHING_FORWARD, PUSHING_REVERSE);
		compressor = new Compressor();
		compressor.setClosedLoopControl(true);
		
	}

		// Put methods for controlling this subsystem
		// here. Call these from Commands.


		/**
		 * Activates grabbing solenoid so that it grabs tote
		 * 
		 */
		public void eject() {
			pushing.set(DoubleSolenoid.Value.kReverse);
		}

		public void retract() {
			pushing.set(DoubleSolenoid.Value.kForward);
		}
		
		public void clamp() {
			clamping.set(DoubleSolenoid.Value.kForward);
		}

		/**
		 * Retracts pistons so that tote rises false = raise true = lower
		 */
		public void raise() {
			lifting.set(DoubleSolenoid.Value.kReverse);
		}

		/**
		 * Releases pistons so that tote is released
		 * 
		 */
		public void unclamp() {
			clamping.set(DoubleSolenoid.Value.kForward);
		}

		/**
		 * activates pistons so that tote is lowered
		 * 
		 */
		public void lower() {
			lifting.set(DoubleSolenoid.Value.kForward);
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


