/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.livewindow.*;

/**
 *
 * @author Developer
 */
public class Drive {
    Victor fl, fr, bl, br;
    Joystick joy;
    Timer timer = new Timer();
    
    Drive (Joystick JOY, Victor FL, Victor FR, Victor BL, Victor BR) {
        fl = FL;
        fr = FR;
        bl = BL;
        br = BR;
        joy = JOY;
    }
    
    double leftX = joy.getRawAxis(2);
    double leftY = joy.getRawAxis(1);
    double rightX = joy.getRawAxis(4);
   
    public void mecanumDrive() {
        fl.set((leftY*(.75)) - (leftX*(.75)) + (rightX/3) );
        fr.set((leftY*(.75))+(leftX*(.75)) + (rightX/3) );
        bl.set((-leftY*(.75))-(leftX*(.75)) + (rightX/3) );
        br.set((-leftY*(.75))+(leftX*(.75)) + (rightX/3) );
    }
    
    public void tankDrive() {
        fl.set(leftY + rightX);
        bl.set(leftY + rightX);
        fr.set(leftY - rightX);
        br.set(leftY - rightX);
    }
    
    public void mecMoveLeft(double time) {
        timer.start();
        while (timer.get() < time) {
            fl.set(-1);
            bl.set(-1);
            fr.set(1);
            br.set(1);
        }
        timer.stop();
        timer.reset();
    }
    
    public void mecMoveRight(double time) {
        timer.start();
        while (timer.get() < time) {
            fl.set(1);
            bl.set(1);
            fr.set(-1);
            br.set(-1);
        }
        timer.stop();
        timer.reset();
    }
    
    public void mecMoveBack(double time) {
        timer.start();
        while (timer.get() < time) {
            fl.set(-1);
            bl.set(-1);
            fr.set(-1);
            br.set(-1);
        }
        timer.stop();
        timer.reset();
    }
    
    public void mecMoveForward(double time) {
        timer.start();
        while (timer.get() < time) {
            fl.set(1);
            bl.set(1);
            fr.set(1);
            br.set(1);
        }
        timer.stop();
        timer.reset();
    }
    
    public void mecRotateRight() {
        fl.set(1);
        bl.set(1);
        fr.set(-1);
        br.set(-1);
    }
    
    public void mecRotateLeft() {
        fl.set(-1);
        bl.set(-1);
        fr.set(1);
        br.set(1);
    }    
}
