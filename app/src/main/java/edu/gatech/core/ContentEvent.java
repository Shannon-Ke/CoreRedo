package edu.gatech.core;

/**
 * Created by Megan on 2/10/18.
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class ContentEvent {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Event nufonia = new Event();
    nufonia.setName("Nufonia Must Fall");
    Event basketball = new Event();
    basketball.setName("Women's Basketball: GT v NCU");
    Event ccf = new Event();
    ccf.setName("Thursday Night Dinners");
    Event qchat = new Event();
    qchat.setName("Q-Chat: Men's Group");

    Event[] events = [nufonia, basketball, ccf, qchat];
    ListAdapter listAdapter = new ArrayAdapter<Event>(thus, android.R.layout.simple_expandable_list_item_1, events);
    

}
