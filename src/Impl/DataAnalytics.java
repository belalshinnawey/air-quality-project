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
import Util.CityComparator;
import Util.Date;
import Util.MeasurementComparator;
import Util.SensorFilters;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author belal
 */
public class DataAnalytics implements IDataAnalytics {

    SensorFilters sf = new SensorFilters();
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
        ArrayList<TemperatureSensor> RiyadhMeasurement = sf.CityTemperatures("Riyadh", Measurements, d1, d2);
        ArrayList<TemperatureSensor> MakkahMeasurement = sf.CityTemperatures("Makkah", Measurements, d1, d2);
        ArrayList<TemperatureSensor> JeddahMeasurement = sf.CityTemperatures("Jeddah", Measurements, d1, d2);
        ArrayList<TemperatureSensor> MadinahMeasurement = sf.CityTemperatures("Madinah", Measurements, d1, d2);
        ArrayList<TemperatureSensor> AbhaMeasurement = sf.CityTemperatures("Abha", Measurements, d1, d2);
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

    public Measurement averageMeasurements(City city, Date d1, Date d2) {
        Measurement m = new Measurement(city);
        ArrayList<TemperatureSensor> temperatureSensors = sf.CityTemperatures(city.getName(), Measurements, d1, d2);
        ArrayList<HumiditySensor> humiditySensors = sf.CityHumidity(city.getName(), Measurements, d1, d2);
        ArrayList<PressureSensor> pressureSensors = sf.CityPressure(city.getName(), Measurements, d1, d2);
        double sumTemperatur = 0;
        double sumHumidity = 0;
        double sumPressure = 0;

        for (int i = 0; i < temperatureSensors.size(); i++) {
            sumTemperatur += temperatureSensors.get(i).getValue();
        }
        for (int i = 0; i < humiditySensors.size(); i++) {
            sumHumidity += humiditySensors.get(i).getValue();
        }
        for (int i = 0; i < temperatureSensors.size(); i++) {
            sumTemperatur += temperatureSensors.get(i).getValue();
        }
        for (int i = 0; i < pressureSensors.size(); i++) {
            sumPressure += pressureSensors.get(i).getValue();
        }
        double avTemperatur = sumTemperatur / temperatureSensors.size();
        double avHumidity = sumHumidity / humiditySensors.size();
        double avPressure = sumPressure / pressureSensors.size();
        m.addSensor("TemperatureSensor", new TemperatureSensor(avTemperatur));
        m.addSensor("HumiditySensor", new HumiditySensor(avHumidity));
        m.addSensor("PressureSensor", new PressureSensor(avPressure));

        return m;
    }

    public Set<City> citiesByTemperature(Date d1, Date d2) {
        Set<City> cities = new TreeSet<>();
        ArrayList<City>Cities=new ArrayList<>();
        City riyadh = cf.getCity("Riyadh");
        City makkah = cf.getCity("makkah");
        City madinah = cf.getCity("Madinah");
        City jeddah = cf.getCity("Jeddah");
        City abha = cf.getCity("Abha");
        ArrayList<Measurement> m = new ArrayList<>();
        m.add(averageMeasurements(abha, d1, d2));
        m.add(averageMeasurements(riyadh, d1, d2));
        m.add(averageMeasurements(makkah, d1, d2));
        m.add(averageMeasurements(madinah, d1, d2));
        m.add(averageMeasurements(jeddah, d1, d2));
        Collections.sort(Cities, new CityComparator());
        cities.add((City) (m.get(0).getCity()));
        cities.add((City) (m.get(1).getCity()));
        cities.add((City) (m.get(2).getCity()));
        cities.add((City) (m.get(3).getCity()));
        return cities;
    }

}
