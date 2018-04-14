/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import Util.TemperatureComparator;
import Interfaces.ICity;
import Interfaces.IDataAnalytics;
import Interfaces.ISensor;
import Util.Date;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author belal
 */
public class DataAnalytics implements IDataAnalytics {

    CityFactory cf = (CityFactory) CityFactory.getInstance();
    private ArrayList<Measurement> Measurements = new ArrayList<>();
    private static DataAnalytics instance = new DataAnalytics();

    private DataAnalytics() {
        Measurements = new ArrayList<>();
    }

    public static DataAnalytics getInstance() {
        return instance;
    }

    public boolean addMeasurement(Measurement measurement) {
        return Measurements.add(measurement);
    }

    public void read(String fileName) throws IOException {
        Scanner in = new Scanner(new File(fileName));
        while (in.hasNext()) {
            String read = in.nextLine();
            boolean conf = false;
            while (conf == false) {
                int check = 0;
                for (int i = 0; i < read.length(); i++) {
                    if (read.charAt(i) == ';') {
                        check++;
                    }
                }
                if (check < 11 || check > 11) {
                    System.out.println(read + " this line has a problem, please make sure all the lines in the file are correct");
                    read = in.nextLine();
                } else {
                    conf = true;
                }
            }
            String info[] = read.split(";");

            String date[] = info[12].split("/");
            Measurement m = new Measurement(new Date(Integer.parseInt(date[0]), Integer.parseInt(date[0]), Integer.parseInt(date[0])), cf.getCity(info[0]));
            m.addSensor("TemperatureSensor", new TemperatureSensor(Double.parseDouble(info[4]), info[5]));
            m.addSensor("HumiditySensor", new HumiditySensor(Double.parseDouble(info[6]), info[7]));
            m.addSensor("PressureSensor", new PressureSensor(Double.parseDouble(info[8]), info[9]));
            m.addSensor("DistanceSensor", new DistanceSensor(Double.parseDouble(info[10]), info[11]));
            addMeasurement(m);
        }
    }

    @Override
    public Map<ICity, ISensor> hottestTemperature(Date d1, Date d2) {
        ArrayList<TemperatureSensor> RiyadhMeasurement = CityTemperatures("Riyadh", Measurements, d1, d2);
        ArrayList<TemperatureSensor> MakkahMeasurement = CityTemperatures("Makkah", Measurements, d1, d2);
        ArrayList<TemperatureSensor> JeddahMeasurement = CityTemperatures("Jeddah", Measurements, d1, d2);
        ArrayList<TemperatureSensor> MadinahMeasurement = CityTemperatures("Madinah", Measurements, d1, d2);
        ArrayList<TemperatureSensor> AbhaMeasurement = CityTemperatures("Abha", Measurements, d1, d2);
        Map<ICity, ISensor> hottestTemperatures = new HashMap<>();
        TemperatureSensor hottestRiyadhTemperature = Collections.max(RiyadhMeasurement, new TemperatureComparator());
        TemperatureSensor hottestJeddahTemperature = Collections.max(JeddahMeasurement, new TemperatureComparator());
        TemperatureSensor hottestMadinahTemperature = Collections.max(MadinahMeasurement, new TemperatureComparator());
        TemperatureSensor hottestMakkahTemperature = Collections.max(MakkahMeasurement, new TemperatureComparator());
        TemperatureSensor hottestAbhaTemperature = Collections.max(AbhaMeasurement, new TemperatureComparator());
        hottestTemperatures.put(cf.getCity("Riyadh"), hottestRiyadhTemperature);
        hottestTemperatures.put(cf.getCity("Madinah"), hottestMadinahTemperature);
        hottestTemperatures.put(cf.getCity("Jeddah"), hottestJeddahTemperature);
        hottestTemperatures.put(cf.getCity("Makkah"), hottestMakkahTemperature);
        hottestTemperatures.put(cf.getCity("Abha"), hottestAbhaTemperature);
        System.out.println(hottestTemperatures);

        return hottestTemperatures;
    }

    public ArrayList<TemperatureSensor> CityTemperatures(String cityName, ArrayList<Measurement> measurements, Date d1, Date d2) {
        ArrayList<TemperatureSensor> cityTemperatures = new ArrayList<>();

        for (int i = 0; i < measurements.size(); i++) {
            if (measurements.get(i).getDate().compareTo(d2) > -1 && measurements.get(i).getDate().compareTo(d1) < 0) {
                if (measurements.get(i).getCity().getName().equals(cityName)) {
                    cityTemperatures.add((TemperatureSensor) measurements.get(i).getSensor("TemperatureSensor"));
                }
            }

        }
        return cityTemperatures;

    }
}
