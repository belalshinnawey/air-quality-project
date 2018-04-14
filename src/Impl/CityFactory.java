package Impl;

import Interfaces.ICityFactory;




public class CityFactory implements ICityFactory{

    static String [] cities = {"Jeddah", "Makkah", "Madinah", "Riyadh"};
    
    private static ICityFactory instance = new CityFactory();
    
    private CityFactory(){
        
    }
    
    public static ICityFactory getInstance(){
        return instance;
    }

    @Override
    public City getCity(String cityName) {
        if (cityName.equalsIgnoreCase("riyadh") ){
            return new City("Riyadh",new GPS(24.7136,46.6753) );
        }else if (cityName.equalsIgnoreCase("makkah")){
            return new City("Makkah", new GPS(21.3891,39.8579));
        }else if (cityName.equalsIgnoreCase("jeddah")){
            return new City("Jeddah", new GPS(21.2854,39.2376));
        }else if (cityName.equalsIgnoreCase("madinah")){
            return new City("Madinah", new GPS(24.5247,39.5692));
        }
        return null;
    }
    
    
}



