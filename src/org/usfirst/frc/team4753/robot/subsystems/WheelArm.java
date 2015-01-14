package org.usfirst.frc.team4753.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WheelArm extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private SpeedController L;
	private SpeedController M;
	private SpeedController R;
	
	public WheelArm() {
		L = new Victor(7);
		M = new Victor(8);
		R = new Victor(9);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void forward() {
    	L.set(1);
    	M.set(1);
    	R.set(1);
    }
    
    public void backward() {
    	L.set(-1);
    	M.set(-1);
    	R.set(-1);
    }
}

