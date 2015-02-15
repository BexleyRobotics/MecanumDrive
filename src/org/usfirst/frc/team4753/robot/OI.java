package org.usfirst.frc.team4753.robot;

import org.usfirst.frc.team4753.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI 
{
	
	private Joystick stick = new Joystick(0);
	private Button button1 = new JoystickButton(stick, 1);
	private Button button2 = new JoystickButton(stick, 2);
	private Button button4 = new JoystickButton(stick, 4);
	private Button button6 = new JoystickButton(stick, 6);
	private Button button7 = new JoystickButton(stick, 7);
   
	public OI() 
	{
		button1.whenPressed(new SetSpeed());
		button2.whileHeld(new PullToteIn());
		button4.whenPressed(new StackTote());
		button6.whileHeld(new Eject());
		button7.whenPressed(new ToggleCompressor());
	}

	public Joystick getJoy() {
		return stick;
	}

	public double getY() {
		return stick.getY();
	}

	public double getX() {
		return stick.getX();
	}
	
	public double getZ(){
		return stick.getZ();
	}
}
