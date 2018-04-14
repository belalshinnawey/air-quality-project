/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import java.util.Comparator;

/**
 *
 * @author belal
 */
public class TemperatureSensor extends Sensor {

    public TemperatureSensor(double value, String unit) {
        super(value);
        setUnit(unit);
    }

    public TemperatureSensor(double value) {

        this(value, "c");
    }

    @Override
    public void setUnit(String unit) {
        if (unit.equalsIgnoreCase("c")) {
            super.setUnit("c");
        } else {
            throw new IllegalArgumentException("wrong unit for TemperatureSensor");
        }
    }

}
