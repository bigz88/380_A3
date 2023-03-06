package edu.ucalgary.oop;

import java.util.regex.Pattern;

public class Sensor implements Cloneable, FormattedOutput{
    private String sensor;
    private static final String REGEX = "\\(([a-z]+)\\)";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    public Sensor(String sensor) throws IllegalArgumentException{
        this.sensor = sensor;
    }

    public String getSensor(){
        return this.sensor;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public String getFormatted(){
        return "FString";
    }
}
