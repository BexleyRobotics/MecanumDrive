/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.*;

/**
 *
 * @author Developer
 */
public class Indexer {
    
    Timer timer = new Timer();
    Relay index;
    Indexer (Relay indexer) {
        index = indexer;
    }
    
    // This fires with a trigger input (namely Axis(3), or the right trigger)
    public void triggerFire360(double trig) {
        if (trig == -1 && timer.get() == 0.0) { //press R trigger
            
            timer.start();
            index.set(Relay.Value.kOn);
        }
        if (timer.get() >= .725) { //.1615 = 90 deg
            index.set(Relay.Value.kOff);
        }
        if (timer.get() >= 1.3) { // delay before next shot
            timer.stop();
            timer.reset();
        }
    }
    
    
    public void fire() {
        if (timer.get() == 0.0) { 
            System.out.println("FireAuto");
            timer.start();
            index.set(Relay.Value.kOn);
        }
        if (timer.get() >= 5) { //.1615 = 90 deg
            index.set(Relay.Value.kOff);
        }
        if (timer.get() >= 15) { // delay before next shot
            timer.stop();
            timer.reset();
        }
        System.out.println();
    }
    public void stop() {
        index.set(Relay.Value.kOff);
    }
}
