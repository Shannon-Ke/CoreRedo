package edu.gatech.core;

/**
 * Created by Megan on 2/10/18.
 */

public class Event {

    private String name;
    private int startTime;
    private int endTime;
    private int length;
    private String description;
    private String org;
    private String location;
    private int latitude;
    private int longitude;
    private Attributes attributes;

    public Event() {

    }
    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }





}
