/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author Developer
 */
public class PIDMotors {
    Victor motorFL;
    Victor motorFR;
    Victor motorBL;
    Victor motorBR;
    public PIDMotors(Victor FL, Victor FR, Victor BL, Victor BR) {
        motorFL = FL;
        motorFR = FR;
        motorBL = BL;
        motorBR = BR;
    }
    public void mPIDInit() {
        
    }
}
