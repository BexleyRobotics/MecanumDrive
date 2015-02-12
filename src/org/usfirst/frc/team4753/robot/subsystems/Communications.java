package org.usfirst.frc.team4753.robot.subsystems;



import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.*;



/**
 * Representation of networktable for communication with Jetson
 * 
 * @author Ian Foreman
 */
public class Communications extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private NetworkTable jetson;
	
	
	public Communications()
	{
		jetson = NetworkTable.getTable("Jetson");
				
	}

    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
}

