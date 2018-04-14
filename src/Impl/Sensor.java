/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import Interfaces.ISensor;

/**
 *
 * @author belal
 */
public abstract class Sensor implements ISensor {

    private double value;
    private String unit;

    public Sensor(double Value) {
        setValue(Value);
    }

    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public String getUnit() {
        return this.unit;
    }

    @Override
    public void setValue(double value){
        this.value=value;
    }

    @Override
    public  void setUnit(String unit){
        this.unit=unit;
    }
    @Override
    public String toString(){
        return String.format("%.2f,%s",value,unit);
    }

}
