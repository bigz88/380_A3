package edu.ucalgary.oop;
// Assignment 3.

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RobotDataLine implements Cloneable {
    private String dataLine;
    private String robotID;
    private Sensor sensor;
    private Movement movement;
    private LocalDate date;

    private static final String DATE_REGEX= "\\[([0-9]{1,2})/([0-9]{1,2})/([0-9]{4})\\]";
    private static final Pattern DATE_PATTERN = Pattern.compile(DATE_REGEX);
    private static final String ROBOT_REGEX =  "\\s([0-9]{3}[A-Z]{1})\\s";
    private static final Pattern ROBOT_PATTERN = Pattern.compile(ROBOT_REGEX);

    public RobotDataLine(String line) throws IllegalArgumentException{
        this.dataLine = line;
        Matcher r = ROBOT_PATTERN.matcher(line);
        if (r.find()){
            this.robotID = r.group(1);
        }
        else if (!r.find()){
            throw new IllegalArgumentException();
        }
        Matcher d = DATE_PATTERN.matcher(line);
        if (d.find()) {
            String str = (d.group().replace("[", "")
                    .replace("]", "").replaceAll("(\\d{2})/(\\d{2})/(\\d{4})", "$3/$2/$1")
                    .replace("/", "-"));
            this.date = LocalDate.parse(str);
        }
        else if (!(d.find())){
            throw new IllegalArgumentException();
        }
        this.sensor = new Sensor(line);
        this.movement = new Movement(line);
    }

    public String getRobotID(){
        return this.robotID;
    }

    public String getDataLine(){
        return this.dataLine;
    }

    public Sensor getSensor() {
        return this.sensor;
    }

    public Movement getMovement() {
        return movement;
    }

    public LocalDate getDate(){
        return this.date;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
