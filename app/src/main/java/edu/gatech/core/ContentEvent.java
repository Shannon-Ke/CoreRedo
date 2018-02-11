package edu.gatech.core;

/**
 * Created by Megan on 2/10/18.
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContentEvent extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Event nufonia = new Event();
        nufonia.setName("Nufonia Must Fall");
        nufonia.setAttributes(new Attributes[]{Attributes.ARTS});
        nufonia.setStart("19:30");
        nufonia.setEnd("21:30");
        nufonia.setOrg("Arts at Tech");
        nufonia.setDate("February 13, 2018");

        Event basketball = new Event();
        basketball.setName("Women's Basketball: GT v NCU");
        basketball.setAttributes(new Attributes[]{Attributes.SPORTS, Attributes.FEMALE});
        basketball.setStart("19:00");
        basketball.setEnd("21:00");
        basketball.setOrg("GT Sports");
        basketball.setDate("February 15, 2018");

        Event ccf = new Event();
        ccf.setName("Thursday Night Dinners");
        ccf.setAttributes(new Attributes[]{Attributes.RELIGIOUS, Attributes.FREEFOOD});
        ccf.setStart("18:45");
        ccf.setEnd("21:00");
        ccf.setOrg("Arts at Tech");
        ccf.setDate("February 15, 2018");

        Event qchat = new Event();
        qchat.setName("Q-Chat: Men's Group");
        qchat.setAttributes(new Attributes[]{Attributes.MALE, Attributes.LGBTQIA});
        qchat.setStart("18:00");
        qchat.setEnd("19:00");
        qchat.setOrg("LGBTQIA Resource Center");
        qchat.setDate("February 13, 2018");

        String[] events = new String[]{nufonia.getName(), basketball.getName(), ccf.getName(), qchat.getName()};
        ListAdapter listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, events);
        ListView listOfEvents = (ListView) findViewById(R.id.listOfEvents);
        listOfEvents.setAdapter(listAdapter);
    }

}
