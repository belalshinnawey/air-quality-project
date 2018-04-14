package Impl;
import Interfaces.ICity;
import Interfaces.IGPS;

public class City implements ICity{
    private GPS location;
    private String name;

    public City(String name,GPS location) {
        setGPS(location);
        setName(name);
    }
    

    @Override
    public void setGPS(IGPS GPS) {
        this.location=(GPS)GPS;
    }

    @Override
    public void setName(String name) {  
            this.name=name;
        
    }

    @Override
    public IGPS getGPS() {
        return location;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return   '{'+"location=" + location + ", name=" + name +'}';
    }
    
}
