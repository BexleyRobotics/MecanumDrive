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
public class PandaStuff implements PIDSource {
    
    String value;
    NetworkTable table = NetworkTable.getTable("SmartDashboard");
    
    public PandaStuff(String val) {
        value = val;
    }

    public double pidGet() {
        if (value == "x3") {
            return -1 * table.getNumber(value);
        } else if (value == "y3") {
            return -1 * table.getNumber(value);
        } else if (value == "xpyr"){
            return -1 * table.getNumber(value);
        } else if (value == "ypyr"){
            return -1 * table.getNumber(value);
        } else {
            return 0;
        }
    }
    
}
