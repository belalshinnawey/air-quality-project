package Impl;
import Interfaces.IGPS;


public class GPS implements IGPS{
private double latitude,longitude;

    public GPS(double latitude, double longitude) {
        setLatitude(latitude);
        setLongitude(longitude);
    }

    @Override
    public void setLatitude(double latitude) {
       if(latitude>=-90 && latitude<=90){
           this.latitude=latitude;
       }else throw new IllegalArgumentException("Latitude must be within [-90,90]");
              
    }

    @Override
    public void setLongitude(double longitude) {
       if(longitude>=-180 && longitude<=180){
           this.longitude=longitude;
       }throw new IllegalArgumentException("Longitude must be within [-180,180]");
    }

    @Override
    public double getLatitude() {
       return latitude;
    }

    @Override
    public double getLongitude() {
       return longitude;
    }

    @Override
    public String toString() {
        return '{'+"latitude = " + latitude + ", longitude = " + longitude + '}';
    }
    
    
}
