package Interfaces;

public interface ISensor {

    public abstract double getValue();

    public abstract String getUnit();

    public abstract void setValue(double value);

    public abstract void setUnit(String unit);

}
