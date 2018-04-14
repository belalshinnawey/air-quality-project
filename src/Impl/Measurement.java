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
        this.date = date;
        this.city = city;
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

    public ArrayList<Measurement> CitySensors(String cityName, ArrayList<Measurement> measurements, Date d1, Date d2) {
        ArrayList<Measurement> RiyadhMeasurement = new ArrayList<>();
        ArrayList<Measurement> MakkahMeasurement = new ArrayList<>();
        ArrayList<Measurement> JeddahMeasurement = new ArrayList<>();
        ArrayList<Measurement> MadinahMeasurement = new ArrayList<>();
        ArrayList<Measurement> AbhaMeasurement = new ArrayList<>();
        for (int i = 0; i < measurements.size(); i++) {

            if (measurements.get(i).getDate().compareTo(d2) > -1 && measurements.get(i).getDate().compareTo(d1) < 0) {
                switch (measurements.get(i).getCity().getName()) {
                    case "Riyadh":
                        RiyadhMeasurement.add(measurements.get(i));
                        break;
                    case "Madinah":
                        MadinahMeasurement.add(measurements.get(i));
                        break;
                    case "Jeddah":
                        JeddahMeasurement.add(measurements.get(i));
                        break;
                    case "Makkah":
                        MakkahMeasurement.add(measurements.get(i));
                        break;
                    case "Abha":
                        AbhaMeasurement.add(measurements.get(i));
                        break;
                }
            }

        }
        switch (cityName) {
                    case "Riyadh":
                       return RiyadhMeasurement;
                      
                    case "Madinah":
                        return MadinahMeasurement;
                        
                    case "Jeddah":
                       return JeddahMeasurement;
                        
                    case "Makkah":
                       return MakkahMeasurement;
                        
                    case "Abha":
                       return AbhaMeasurement;
                   
                    
                }
        return null;

    }
}
