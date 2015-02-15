package org.usfirst.frc.team4753.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team4753.robot.commands.Autonomous;
import org.usfirst.frc.team4753.robot.commands.SystemsCheck;
import org.usfirst.frc.team4753.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4753.robot.subsystems.Pneumatics;
import org.usfirst.frc.team4753.robot.subsystems.WheelArm;
import org.usfirst.frc.team4753.robot.subsystems.Communications;
import org.usfirst.frc.team4753.robot.subsystems.Dashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static DriveTrain drivetrain;
	public static WheelArm arms;
	public static Pneumatics pneumatics;
	public static Communications comms;
	public static Dashboard dashboard;
	private Command autonomousCommand;
	private Command testCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {

		// instantiate the command used for the autonomous period
		drivetrain = new DriveTrain();
		arms = new WheelArm();
		pneumatics = new Pneumatics();
		comms = new Communications();
		
		dashboard = new Dashboard();
		oi = new OI();
		dashboard.startTime();
		pneumatics.unclamp();
		pneumatics.raise();
		autonomousCommand = new Autonomous();
		testCommand = new SystemsCheck();
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() 
	{
		Scheduler.getInstance().run();
		Robot.drivetrain.drive(oi.getY(), oi.getX());
		dashboard.startTime();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
	
    public void testInit(){
    	testCommand.start();
    }
}
