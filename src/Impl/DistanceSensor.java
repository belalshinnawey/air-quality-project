/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

/**
 *
 * @author belal
 */
public class DistanceSensor extends Sensor {

    public DistanceSensor(double value, String unit) {
        super(value);
        setUnit(unit);
    }

 

    @Override
    public void setUnit(String unit) {
        if(unit.equalsIgnoreCase("m"))
        super.setUnit("m");
        else throw new IllegalArgumentException("wrong unit for DistanceSensor");

    }

}
