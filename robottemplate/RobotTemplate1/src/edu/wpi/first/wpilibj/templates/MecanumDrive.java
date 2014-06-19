/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.*;
//import java.util.Scanner;
import java.lang.Math;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class MecanumDrive extends IterativeRobot {
        
    Victor motorFL = new Victor(1);
    Victor motorFR = new Victor(2);
    Victor motorBL = new Victor(4);
    Victor motorBR = new Victor(3);
    Relay indexer = new Relay (7);
    
    Timer timer = new Timer();
    
    Joystick joy = new Joystick(1);
    JoyButton joyA = new JoyButton(joy, 1);
    JoyButton joyB = new JoyButton(joy, 2);
    JoyButton joyX = new JoyButton(joy, 3);
    JoyButton joyY = new JoyButton(joy, 4);
    JoyButton joyLB = new JoyButton(joy, 5);
    JoyButton joyRB = new JoyButton(joy, 6);
    JoyButton joyBack = new JoyButton(joy, 7);
    JoyButton joyStart = new JoyButton(joy, 8);
    JoyButton joyLClick = new JoyButton(joy, 9);
    JoyButton joyRClck = new JoyButton(joy, 10);
    
    
    //RobotDrive drive = new RobotDrive(motorFL, motorBR, motorBL, motorFR );
    RobotDrive drive = new RobotDrive(motorFL, motorBL, motorFR, motorBR);
    
    //Scanner scan = new Scanner(System.in);
    
    public void robotInit() {

    }

    public void autonomousPeriodic() {

    }

    public void teleopPeriodic() {
        
        // 
        double leftX = joy.getRawAxis(2);
        double leftY = joy.getRawAxis(1);
        double rightX = joy.getRawAxis(4);

        motorFL.set((-leftY/2) + (leftX/2) - (rightX/2) );
        motorFR.set((-leftY/2)-(leftX/2) - (rightX/2) );
        motorBL.set((leftY/2)+(leftX/2) - (rightX/2) );
        motorBR.set((leftY/2)-(leftX/2) - (rightX/2) );

  
   
   
    }
    
}
