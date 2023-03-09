package edu.ucalgary.oop;
// Assignment 3.

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Matcher r = ROBOT_PATTERN.matcher(line);
        Matcher d = DATE_PATTERN.matcher(line);

        String c = "\\[(0[1-9]|[1-2][0-9]|3[0-1])\\/(0[1-9]|1[0-2])\\/\\d{4}\\]";
        Pattern calendarPattern = Pattern.compile(c);
        Matcher cal = calendarPattern.matcher(line);


        if(r.find() && d.find() && cal.find()) {
            this.dataLine = line;
            this.robotID = r.group().replace(" ", "");
            this.date = LocalDate.parse(d.group().replace("[", "").replace("]", ""), formatter);
            this.movement = new Movement(line);
            this.sensor= new Sensor(line);
        }
        else{
            throw new IllegalArgumentException("Illegal argument.");
        }

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
        RobotDataLine copy = (RobotDataLine)super.clone();
        copy.sensor = (Sensor)sensor.clone();
        copy.movement = (Movement)movement.clone();
        return copy;
    }
}
