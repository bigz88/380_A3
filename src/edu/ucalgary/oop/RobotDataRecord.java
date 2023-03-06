package edu.ucalgary.oop;

import java.util.ArrayList;

public class RobotDataRecord implements Cloneable{
    private ArrayList<RobotDataLine> log;

    public RobotDataRecord(String[] array){

    }

    public RobotDataLine getLine(int index){
        return log.get(index);
    }

    public ArrayList<RobotDataLine> getDataRecord(){
        return log;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
