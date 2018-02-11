package edu.gatech.core;

/**
 * Created by Megan on 2/10/18.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;
import java.util.Arrays;
import java.util.List;

public class Event implements Parcelable {
    public static List<String> Months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    private String name;
    private Attributes[] attributes;
    private String start;
    private String description;
    private String end;
    private String org;
    private LatLng loc;
    private String date;
    private String location;
    private String month;
    private int day;
    private int year;



    public Event(String name, Attributes[] attributes, String start, String end, String org, String date) {
        this.name = name;
        this.attributes = attributes;
        this.start = start;
        this.end = end;
        this.org = org;
        this.date = date;
    }

    public Event() {
        this.name = "default name";
        this.attributes = new Attributes[0];
        start = "start time";
        end = "end time";
        org = "organization";
        date = "date";
        month = "January";
        day = 1;
        year = 2018;
        location = "location";
        description = "description";
    }
    public void makeEventPage() {
        EventPage page = new EventPage();
        page.setNameT(name);
        page.setTimeT(month + " " + day + ", " + year);
        page.setDescriptionT(description);
        page.setLocationT(location);
        page.setOrganizationT(org);
        page.settags(attributes);
    }
    private Event(Parcel in) {
        name = in.readString();
        start = in.readString();
        end = in.readString();
        attributes = (Attributes[]) in.readSerializable();
        org = in.readString();
        date = in.readString();

    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(start);
        dest.writeString(end);
        dest.writeSerializable(attributes);
        dest.writeString(org);
        dest.writeSerializable(date);

    }
    public static int findPosition(String code) {
        int i = 0;
        while (i < Months.size()) {
            if (code.equals(Months.get(i))) return i;
            ++i;
        }
        return 0;
    }
    @Override
    public int describeContents() {
        return 0;
    }
    public static final Parcelable.Creator<Event> CREATOR
            = new Parcelable.Creator<Event>() {
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        public Event[] newArray(int size) {
            return new Event[size];
        }
    };
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

    public String getMonth() { return month;}
    public int getDay() {return day;}
    public int getYear() {return year;}
    public String getDescription() { return description;}
    public void setDescription(String desc) { description = desc;}

    public void setLocation(String location) { this.location = location;}
    public String getLocation() { return location;}

}
