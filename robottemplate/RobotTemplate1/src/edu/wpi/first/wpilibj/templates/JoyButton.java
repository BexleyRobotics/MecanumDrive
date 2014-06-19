/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.*;

/**
 *
 * @author Developer
 */
public class JoyButton {
    
    Joystick joy;
    int buttonID;
    boolean previousState;
    boolean result;
    boolean prev = false;
    
    public JoyButton(Joystick joyA, int buttonNum) {
        previousState = false;
        joy = joyA;
        buttonID = buttonNum;
    }
    
    public boolean checkState() {
        // If we press and it wasn't just pressed..
        if (joy.getRawButton(buttonID) && !prev) { 
            // and the motor's on..
            if (result) {
                //turn off
                result = false;
                prev = true;
            }
            // if it's not on..
            else {
                // turn on
                result = true;
                prev = true;
            }
        }
        // if we let go, set the prev to false
        if (!joy.getRawButton(buttonID)) {
            prev = false;
        }
       // sends out whether the motor's on or off
       return result;
   }
    
}
