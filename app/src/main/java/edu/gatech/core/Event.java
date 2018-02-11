package edu.gatech.core;

/**
 * Created by Megan on 2/10/18.
 */

import com.google.android.gms.maps.model.LatLng;

public class Event {

    private String name;
    private Attributes[] attributes;
    private String start;
    private String end;
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

    public String getStart(){
        return start;
    }
    public void setStart(String newStart){
        start = newStart;
    }

    public String getEnd(){
        return end;
    }
    public void setEnd(String newEnd){
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
