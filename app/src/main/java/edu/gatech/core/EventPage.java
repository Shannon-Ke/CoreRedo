package edu.gatech.core;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


/**
 * Created by Hannah on 2/10/2018.
 */

public class EventPage extends AppCompatActivity {
    private TextView nameT, timeT, locationT, organizationT, descriptionT, tags;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_page);
        nameT = findViewById(R.id.eventName);
        timeT = findViewById(R.id.time);
        locationT = findViewById(R.id.location);
        organizationT = findViewById(R.id.organization);
        descriptionT = findViewById(R.id.description);
        tags = findViewById(R.id.attributes);
    }
//    public void setNameT(String newName) {
//        nameT.setText(newName);
//    }
//    public void setTimeT(String newTime) {
//        timeT.setText(newTime);
//    }
//    public void setLocationT(String newLoc) {
//        locationT.setText(newLoc);
//    }
//    public void setOrganizationT(String newOrg) {
//        organizationT.setText(newOrg);
//    }
//    public void setDescriptionT(String newDec) {
//        descriptionT.setText(newDec);
//    }
//    public void settags(Attributes[] newTags) {
//        String curr = "";
//        for (Attributes a : newTags) {
//            curr += a;
//        }
//        tags.setText(curr);
//    }
}
