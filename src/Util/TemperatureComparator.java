/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Impl.TemperatureSensor;
import java.util.Comparator;

/**
 *
 * @author belal
 */
public class TemperatureComparator implements Comparator<TemperatureSensor>{

    @Override
    public int compare(TemperatureSensor t, TemperatureSensor t1) {
    if(t.getValue()>t1.getValue()){
        return 1;
    }else if(t.getValue()<t1.getValue()){
        return -1;
    }else return 0;
    }
    
}
