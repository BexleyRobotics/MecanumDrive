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
public class PIDCounter implements PIDSource {
    
    double RPM;   
    Counter counter;
    
    public PIDCounter(Counter count) {
        counter = count;
    }
    
    public double pidGet() {
        RPM = (1 / counter.getPeriod()*60);
        return RPM;
    }
}