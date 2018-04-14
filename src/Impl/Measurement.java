/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import Util.MeasurementComparator;
import Interfaces.ICity;
import Interfaces.IMeasurement;
import Interfaces.ISensor;
import Util.Date;
import java.util.ArrayList;

import java.util.HashMap;

import java.util.Map;

public class Measurement extends MeasurementComparator implements IMeasurement {

    private Date date;

    private Map<String, ISensor> sensors;

    private City city;
    private ArrayList<String> sensorTypes = new ArrayList<>();

    public Measurement(Date date, City city) {
        setDate(date);
        setCity(city);
        sensors = new HashMap<>();
        sensorTypes.add("DistanceSensor");
        sensorTypes.add("HumiditySensor");
        sensorTypes.add("PressureSensor");
        sensorTypes.add("TemperatureSensor");

    }

    public Measurement(City city) {
        setCity(city);
        sensors = new HashMap<>();
        sensorTypes.add("DistanceSensor");
        sensorTypes.add("HumiditySensor");
        sensorTypes.add("PressureSensor");
        sensorTypes.add("TemperatureSensor");

    }

    @Override
    public void addSensor(String sensorType, ISensor sensor) {
        if (sensorTypes.contains(sensorType)) {
            sensors.put(sensorType, sensor);
        }
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public void setCity(ICity city) {
        this.city = (City) city;
    }

    @Override
    public Date getDate() {
        return this.date;
    }

    @Override
    public ICity getCity() {
        return this.city;
    }

    @Override
    public Map<String, ISensor> getAllSensors() {
        return sensors;
    }

    @Override
    public ISensor getSensor(String sensorType) {
        return sensors.get(sensorType);
    }

    @Override
    public String toString() {
        return String.format("CityName: %s ,Location: %s ,Measurments: %s " + " " + date, this.city.getName(), this.city.getGPS(), sensors);
    }

    @Override
    public int compareTo(Measurement measurement) {
        return this.getDate().compareTo(measurement.getDate());
    }

}
