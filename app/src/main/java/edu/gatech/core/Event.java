package edu.gatech.core;

/**
 * Created by Megan on 2/10/18.
 */

import java.time.LocalTime;

import com.google.android.gms.maps.model.LatLng;

public class Event {

    private String name;
    private Attributes[] attributes;
    private LocalTime start;
    private LocalTime end;
    private String org;
    private LatLng loc;
    private String date;


    public void Event() {
    }

    public String getName(){
        return name;
    }
    public void setName(String newName){
        name = newName;
    }

    public Attributes[] getAttributes(){
        return attributes;
    }
    public void setAttributes(Attributes[] newAttributes){
        attributes = newAttributes;
    }

    public LocalTime getStart(){
        return start;
    }
    public void setStart(LocalTime newStart){
        start = newStart;
    }

    public LocalTime getEnd(){
        return end;
    }
    public void setEnd(LocalTime newEnd){
        start = newEnd;
    }

    public String getOrg(){
        return org;
    }
    public void setOrg(String newOrg){
        org = newOrg;
    }

    public LatLng getLoc(){
        return loc;
    }

    public void setLoc(LatLng newLoc){
        loc = newLoc;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String newDate){
        date = newDate;
    }

}
