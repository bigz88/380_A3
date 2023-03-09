package edu.ucalgary.oop;

import java.util.ArrayList;

public class RobotDataRecord implements Cloneable{
    private ArrayList<RobotDataLine> log;

    public RobotDataRecord(String[] array){
        log = new ArrayList<>();
        for (int i = 0; i < array.length; i++){
            if (array[i] != null){
                log.add(i, new RobotDataLine(array[i]));
            }
        }
    }

    public RobotDataLine getLine(int index){
        if (log.get(index) != null) {
            return log.get(index);
        }
        else return null;
    }

    public ArrayList<RobotDataLine> getDataRecord(){
        return log;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
