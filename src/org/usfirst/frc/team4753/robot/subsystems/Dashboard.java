package org.usfirst.frc.team4753.robot.subsystems;

import org.usfirst.frc.team4753.robot.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
import static org.usfirst.frc.team4753.robot.RobotMap.*;
/**
 *Dashboard is how we will display information about the robot to the driver and provide buttons to provide additional functions
 *
 *@author Nathan Brownstein
 */
public class Dashboard extends Subsystem 
{
	private int numStacked = 0;
	private Timer time = new Timer();
	private int compressorToggle = -1;

    public void initDefaultCommand() 
    {
		
		
    }
    public Dashboard()
    {
    	
		SmartDashboard.putNumber("Speed", 0.0);
		SmartDashboard.putNumber("Time", 0.0);
		SmartDashboard.putNumber("ArmSpeed", 0.0);
		SmartDashboard.putBoolean("Clamped", (clamped == -1));
		SmartDashboard.putBoolean("Lifted", (lifted == -1));
		SmartDashboard.putData("Toggle Lift", new Lifting());
		SmartDashboard.putData("Toggle Grab", new Clamping());
		SmartDashboard.putData("Toggle Arms", new ArmSpinner());
		SmartDashboard.putData("Toggle Compressor", new ToggleCompressor());
		SmartDashboard.putBoolean("Compressor State", false);
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
	 * speedometer will display the maximum power for our wheels
	 * @param speedpercent
	 */
	public void speedometer(double speedpercent)
	{
		SmartDashboard.putNumber("Speed", speedpercent);
	}
	
	public void compressorState(){
		compressorToggle *= -1;
		SmartDashboard.putBoolean("Compressor State", compressorToggle > 0);
	}
	
    
}

