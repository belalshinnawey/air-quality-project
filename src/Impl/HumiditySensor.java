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
public class HumiditySensor extends Sensor {

    public HumiditySensor(double value, String unit) {
        super(value); 
        setUnit(unit);
    }

   

    @Override
    public void setUnit(String unit) {
        if(unit.equalsIgnoreCase("p"))
        super.setUnit("p");
        else throw new IllegalArgumentException("wrong unit for HumiditySensor");

    }

}
