package Interfaces;

public interface ICity {

    public abstract void setGPS(IGPS G);

    public abstract void setName(String name);

    public abstract IGPS getGPS();

    public abstract String getName();

}
