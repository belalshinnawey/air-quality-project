/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Util.Date;
import java.util.Map;

/**
 *
 * @author belal
 */
public interface IDataAnalytics {
    public abstract Map<ICity,ISensor> hottestTemperature(Date d1, Date d2);
    
    
}
