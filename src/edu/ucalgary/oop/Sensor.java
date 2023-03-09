package edu.ucalgary.oop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sensor implements Cloneable, FormattedOutput{
    private String sensor;
    private static final String REGEX = "\\(([a-z]+)\\)";

    private static final Pattern PATTERN = Pattern.compile(REGEX);

    public Sensor(String sensor) throws IllegalArgumentException{
        Matcher m = PATTERN.matcher(sensor);
        System.out.println(sensor);
        if (m.find()){
            this.sensor = m.group(1);
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public String getSensor(){
        return this.sensor;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public String getFormatted(){
        return ("Sensor: " + this.sensor);
    }
}
