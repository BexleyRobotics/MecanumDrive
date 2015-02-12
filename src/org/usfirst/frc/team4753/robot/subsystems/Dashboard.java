package org.usfirst.frc.team4753.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class Dashboard extends Subsystem 
{
	int numStacked = 0;
	Timer time = new Timer();

    public void initDefaultCommand() 
    {
		
		
    }
    public Dashboard()
    {
    	SmartDashboard.putNumber("Number of Totes", 0);
		SmartDashboard.putNumber("Speed", 0.0);
		SmartDashboard.putNumber("Time", 0.0);
		time.reset();
		time.start();
    }
    /**
     * startTime will make a timer so that we know how long we have in the match.
     * 
     * 
     * 
     */
    public void startTime()
    {
    	SmartDashboard.putNumber("Time", (time.get()));
    }
    /**
     * resetTotes will reset number of totes displayed in Number Of Totes key to 0
     * 
     * 
     */
    public void resetTotes()
    {
    	numStacked = 0;
    	SmartDashboard.putNumber("Number of Totes", numStacked);
    }
    /**
     * addTote will add one to our tote total, which will have some indicator on the dashboard
     */
	public void addTote() 
	{
		numStacked++;
    	SmartDashboard.putNumber("Number of Totes", numStacked);
	}
	/**
	 * speedometer will display the maximum power for our wheels
	 * @param speedpercent
	 */
	public void speedometer(double speedpercent)
	{
		SmartDashboard.putNumber("Speed", speedpercent);
	}
    
}

