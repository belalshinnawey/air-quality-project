/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Impl.Measurement;
import Impl.TemperatureSensor;
import java.util.Comparator;

/**
 *
 * @author belal
 */
public class MeasurementComparator implements Comparator<Measurement>{

    @Override
    public int compare(Measurement m, Measurement m1) {
        double t = ((TemperatureSensor) m.getSensor("TempratureSensor")).getValue();
        double t1 = ((TemperatureSensor) m1.getSensor("TempratureSensor")).getValue();
        
        if (t > t1) {
            return 1;
        } else if (t < t1) {
            return -1;
        }else 
            return 0 ;
    }
     
   
}
