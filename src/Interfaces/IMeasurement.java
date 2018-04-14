package Interfaces;

import Impl.Measurement;
import Util.Date;
import java.util.Map;

public interface IMeasurement extends Comparable<Measurement> {

    public abstract void setDate(Date date);

    public abstract void setCity(ICity City);

    public abstract Date getDate();

    public abstract ICity getCity();

    public abstract void addSensor(String sensorType, ISensor sensor);

    public abstract Map<String, ISensor> getAllSensors();

    public abstract ISensor getSensor(String sensorType);
    
    

}
