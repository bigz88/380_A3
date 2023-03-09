package edu.ucalgary.oop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Movement implements Cloneable, FormattedOutput {
    private String action;
    private String direction;
    private static final String REGEX = "\"([A-Z]+)-([A-Z]{1,2})";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    public Movement(String movement) throws IllegalArgumentException {
        movement = movement.replaceAll("\\s", "");
        Matcher m = PATTERN.matcher(movement);
        if (m.find()) {
            for (Actions action : Actions.values()) {
                if (m.group(1).equals(String.valueOf(action))) {
                    this.action = m.group(1);
                    break;
                }
            }
            for (Directions direction : Directions.values()) {
                if (m.group(2).equals(direction.name())) {
                    this.direction = m.group(2);
                    break;
                }
            }
        }
        else {
            throw new IllegalArgumentException("Inavlid movement.");
        }
    }

    public String getAction(){
        return this.action;
    }

    public String getDirection(){
        return this.direction;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        Movement copy = (Movement)super.clone();
        return copy;
    }
    @Override
    public String getFormatted(){
        StringBuilder sb = new StringBuilder("Action: ");
        for (Actions action: Actions.values()) {
            if ((this.action != null) && (this.action).equals(action.toString())) {
                sb.append(action + ",");
            }
        }
        for (Directions direction: Directions.values()){
            if ((this.direction != null) && (this.direction.equals(direction.name()))){
                sb.append(" Direction: " + direction);
            }
        }
        return sb.toString();
    }
}
