package org.usfirst.frc.team4753.robot.subsystems;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
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
	SmartDashboard dashboard = new SmartDashboard();
	int numStacked = 0;
	Timer time = new Timer();
	
	public Communications()
	{
		jetson = NetworkTable.getTable("Jetson");
		
		dashboard.putInt("Number of Totes", 0);
		dashboard.putDouble("Speed", 0.0);
		dashboard.putDouble("Time", 0.0);
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
    	dashboard.putDouble("Time", (time.get()));
    }
    public void resetTotes()
    {
    	numStacked = 0;
    	dashboard.putInt("Number of Totes", numStacked);
    }
	public void addTote() 
	{
		numStacked++;
    	dashboard.putInt("Number of Totes", numStacked);
	}
	public void speedometer(double speedpercent)
	{
		dashboard.putDouble("Speed", speedpercent);
	}
}

