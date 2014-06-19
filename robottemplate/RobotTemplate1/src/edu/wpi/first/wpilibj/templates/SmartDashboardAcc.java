/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 * @author Developer
 */
public class SmartDashboardAcc implements PIDSource {
    NetworkTable table = NetworkTable.getTable("SmartDashboard");
    
    public SmartDashboardAcc() {
        
    }
    
    public double pidGet() {
        return table.getNumber("SmartDashboardAcc") + table.getNumber("angleOffset");
    }
    
}
