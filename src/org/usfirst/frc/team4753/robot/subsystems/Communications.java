package org.usfirst.frc.team4753.robot.subsystems;



import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;


/**
 * Representation of networktable for communication with Jetson
 * 
 * @author Ian Foreman
 */
public class Communications extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private NetworkTable jetson;
	int numStacked = 0;
	Timer time = new Timer();
	
	public Communications()
	{
		jetson = NetworkTable.getTable("Jetson");
				
		SmartDashboard.putNumber("Number of Totes", 0);
		SmartDashboard.putNumber("Speed", 0.0);
		SmartDashboard.putNumber("Time", 0.0);
		time.reset();
		time.start();
	}

    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void startTime()
    {
    	SmartDashboard.putNumber("Time", (time.get()));
    }
    
    public void resetTotes()
    {
    	numStacked = 0;
    	SmartDashboard.putNumber("Number of Totes", numStacked);
    }
    
	public void addTote() 
	{
		numStacked++;
    	SmartDashboard.putNumber("Number of Totes", numStacked);
	}
	
	public void speedometer(double speedpercent)
	{
		SmartDashboard.putNumber("Speed", speedpercent);
	}
}

