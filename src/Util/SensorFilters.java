/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Impl.DistanceSensor;
import Impl.HumiditySensor;
import Impl.Measurement;
import Impl.PressureSensor;
import Impl.TemperatureSensor;
import java.util.ArrayList;


/**
 *
 * @author belal
 */
public class SensorFilters {
    
    public ArrayList<TemperatureSensor> CityTemperatures(String cityName, ArrayList<Measurement> measurements, Date d1, Date d2) {
        ArrayList<TemperatureSensor> cityTemperatures = new ArrayList<>();
        if(d2.compareTo(d1)>0){
            Date temp = d2;
            d2=d1;
            d1=temp;
        }

        for (int i = 0; i < measurements.size(); i++) {
            if (measurements.get(i).getDate().compareTo(d2) > -1 && measurements.get(i).getDate().compareTo(d1) < 0) {
                if (measurements.get(i).getCity().getName().equals(cityName)) {
                    cityTemperatures.add((TemperatureSensor) measurements.get(i).getSensor("TemperatureSensor"));
                }
            }

        }
        return cityTemperatures;

    }
    public ArrayList<DistanceSensor> CityDistance(String cityName, ArrayList<Measurement> measurements, Date d1, Date d2) {
        ArrayList<DistanceSensor> cityDistance = new ArrayList<>();
        if(d2.compareTo(d1)>0){
            Date temp = d2;
            d2=d1;
            d1=temp;
        }

        for (int i = 0; i < measurements.size(); i++) {
            if (measurements.get(i).getDate().compareTo(d2) > -1 && measurements.get(i).getDate().compareTo(d1) < 0) {
                if (measurements.get(i).getCity().getName().equals(cityName)) {
                    cityDistance.add((DistanceSensor) measurements.get(i).getSensor("DistanceSensor"));
                }
            }

        }
        return cityDistance;

    }
    public ArrayList<HumiditySensor> CityHumidity(String cityName, ArrayList<Measurement> measurements, Date d1, Date d2) {
        ArrayList<HumiditySensor> cityHumidity = new ArrayList<>();
        if(d2.compareTo(d1)>0){
            Date temp = d2;
            d2=d1;
            d1=temp;
        }

        for (int i = 0; i < measurements.size(); i++) {
            if (measurements.get(i).getDate().compareTo(d2) > -1 && measurements.get(i).getDate().compareTo(d1) < 0) {
                if (measurements.get(i).getCity().getName().equals(cityName)) {
                    cityHumidity.add((HumiditySensor) measurements.get(i).getSensor("HumiditySensor"));
                }
            }

        }
        return cityHumidity;

    }
    public ArrayList<PressureSensor> CityPressure(String cityName, ArrayList<Measurement> measurements, Date d1, Date d2) {
        ArrayList<PressureSensor> cityPressure = new ArrayList<>();
        if(d2.compareTo(d1)>0){
            Date temp = d2;
            d2=d1;
            d1=temp;
        }

        for (int i = 0; i < measurements.size(); i++) {
            if (measurements.get(i).getDate().compareTo(d2) > -1 && measurements.get(i).getDate().compareTo(d1) < 0) {
                if (measurements.get(i).getCity().getName().equals(cityName)) {
                    cityPressure.add((PressureSensor) measurements.get(i).getSensor("PressureSensor"));
                }
            }

        }
        return cityPressure;

    }
    
}
