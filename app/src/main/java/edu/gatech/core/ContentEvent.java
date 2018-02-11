package edu.gatech.core;

/**
 * Created by Megan on 2/10/18.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ContentEvent extends Activity {
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_event_page);
        fab = findViewById(R.id.fabu);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), EditEventActivity.class);
                startActivity(intent);
            }
        });
        reload();
    }

    public void reload() {
        Model model = Model.getInstance();
        //String[] events = new String[]{nufonia.getName(), basketball.getName(), ccf.getName(), qchat.getName()};
        List<String> names = new ArrayList<>();
        for (Event e : model.getHardEvents()) {
            names.add(e.getName());
        }
        ListAdapter listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, names);
        ListView eventsList = (ListView) findViewById(R.id.listOfEvents);
        eventsList.setAdapter(listAdapter);
    }

}


