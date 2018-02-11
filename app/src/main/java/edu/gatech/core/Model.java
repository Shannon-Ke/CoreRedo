package edu.gatech.core;

import android.support.compat.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Crymsonfire on 2/11/2018.
 */

public class Model {
    /** Singleton instance */
    private static final Model _instance = new Model();
    public static Model getInstance() { return _instance; }



    private List<Event> events;
    /**
     * make a new model
     */
    private Model() {

        events = new ArrayList<>();
        //comment this out after full app developed -- for homework leave in
        loadDummyData();

    }

    /**
     * populate the model with some dummy data.  The full app would not require this.
     * comment out when adding new courses functionality is present.
     */
    private void loadDummyData() {
        Event nufonia = new Event();
        nufonia.setName("Nufonia Must Fall");
        nufonia.setAttributes(new Attributes[]{Attributes.ARTS});
        nufonia.setStart("19:30");
        nufonia.setEnd("21:30");
        nufonia.setOrg("Arts at Tech");
        nufonia.setDate("February 13, 2018");
//        nufonia.makeEventPage();
        events.add(nufonia);

        Event basketball = new Event();
        basketball.setName("Women's Basketball: GT v NCU");
        basketball.setAttributes(new Attributes[]{Attributes.SPORTS, Attributes.FEMALE});
        basketball.setStart("19:00");
        basketball.setEnd("21:00");
        basketball.setOrg("GT Sports");
        basketball.setDate("February 15, 2018");
//        basketball.makeEventPage();
        events.add(basketball);

        Event ccf = new Event();
        ccf.setName("Thursday Night Dinners");
        ccf.setAttributes(new Attributes[]{Attributes.RELIGIOUS, Attributes.FREEFOOD});
        ccf.setStart("18:45");
        ccf.setEnd("21:00");
        ccf.setOrg("Arts at Tech");
        ccf.setDate("February 15, 2018");
//        ccf.makeEventPage();
        events.add(ccf);

        Event qchat = new Event();
        qchat.setName("Q-Chat: Men's Group");
        qchat.setAttributes(new Attributes[]{Attributes.MALE, Attributes.LGBTQIA});
        qchat.setStart("18:00");
        qchat.setEnd("19:00");
        qchat.setOrg("LGBTQIA Resource Center");
        qchat.setDate("February 13, 2018");
//        qchat.makeEventPage();
        events.add(qchat);
    }

    /**
     * get the courses
     * @return a list of the courses in the app
     */
    public List<Event> getHardEvents() { return events; }


}
