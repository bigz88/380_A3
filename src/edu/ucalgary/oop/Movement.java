package edu.ucalgary.oop;

import java.util.regex.Pattern;

public class Movement implements Cloneable, FormattedOutput {
    private String action;
    private String direction;
    private static final String REGEX = "\"([A-Z]+)-([A-Z]{1,2})";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    public Movement(String movement){
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
        return "FString";
    }
}
