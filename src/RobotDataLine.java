// Assignment 3.

import java.time.LocalDate;
import java.util.regex.Pattern;

public class RobotDataLine {
    private String dataLine;
    private String robotID;
    private Sensor sensor;
    private Movement movement;
    private LocalDate date;

    private static final String DATE_REGEX= "\\[([0-9]{1,2})/([0-9]{1,2})/([0-9]{4})\\]";
    private static final Pattern DATE_PATTERN = Pattern.compile(DATE_REGEX);
    private static final String ROBOT_REGEX = "\\s([0-9]{3}[A-Z]{1})\\s";
    private static final Pattern ROBOT_PATTERN = Pattern.compile(ROBOT_REGEX);

    public RobotDataLine(String line){

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
