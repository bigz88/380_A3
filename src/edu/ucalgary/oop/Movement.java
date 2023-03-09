package edu.ucalgary.oop;

import java.util.regex.Pattern;

public class Movement implements Cloneable, FormattedOutput {
    private String action;
    private String direction;
    private static final String REGEX = "\"([A-Z]+)-([A-Z]{1,2})";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    public Movement(String movement){
        String substr = movement.substring(movement.indexOf('"'));
        this.action = substr.substring(substr.indexOf('"')+1, substr.indexOf(' '));
        this.direction = substr.substring(substr.indexOf("- ")+2, substr.indexOf(" ("));
    }

    public String getAction(){
        return this.action;
    }

    public String getDirection(){
        return this.direction;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public String getFormatted(){
        StringBuilder sb = new StringBuilder("Action: ");
        for (Actions action: Actions.values()) {
            if ((this.action).equals(action.toString())) {
                sb.append(action.toString() + ",");
            }
        }
        for (Directions direction: Directions.values()){
            if ((this.direction.equals(direction.name()))){
                sb.append(" Direction: " + direction);
            }
        }
        return sb.toString();
    }
}
