package org.usfirst.frc.team4753.robot;

import org.usfirst.frc.team4753.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI 
{
	
	private Joystick driveStick = new Joystick(0);
	private Joystick auxStick = new Joystick(1);
	private Button button1 = new JoystickButton(auxStick, 1);
	private Button button2 = new JoystickButton(auxStick, 2);
	private Button button3 = new JoystickButton(auxStick, 3);
	private Button button4 = new JoystickButton(auxStick, 4);
	//private Button button6 = new JoystickButton(stick, 6);
	private Button button7 = new JoystickButton(auxStick, 7);
	private Button button8 = new JoystickButton(auxStick, 8);
	
	public OI() 
	{
		Command stop = new StopArms();
		button1.whenPressed(new Lifting());
//		button1.whenReleased(stop);
//		
//		button2.whenPressed(new Lifting());
//		
//		button3.whileHeld(new Eject());
//		button3.whenReleased(new Retract());
//		
//		button4.whenPressed(new ReverseArms());
//		button4.whenReleased(stop);
//		
//		button7.whenPressed(new ToggleCompressor());
//		
//		button8.whenPressed(new SetSpeed());
	}

	public Joystick getJoy() {
		return auxStick;
	}

	public double getY() {
		return driveStick.getY();
	}

	public double getX() {
		return driveStick.getX();
	}
	
	public double getZ(){
		return auxStick.getZ();
	}
	
	public double getZ2(){
		return driveStick.getZ();
	}
}
