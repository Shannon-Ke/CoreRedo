package edu.gatech.core;

/**
 * Created by Megan on 2/10/18.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;


import java.util.ArrayList;
import java.util.List;

public class ContentEvent extends Activity {

    private ListView listView;
    ArrayList<String> items;
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_event_page);

        listView = (ListView) findViewById(R.id.listOfEvents);
        items = new ArrayList<>();
        for (int i=0; i< Model.getHardEvents().length; i++) {
            items.add(Model.getHardEvents().get(i).getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = listView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "" + text, Toast.LENGTH_SHORT.show());
            }
        })

        fab = findViewById(R.id.fabu);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), EditEventActivity.class);
                startActivity(intent);
            }
        });
        reload();
        ListView lv = (ListView)findViewById(R.id.listOfEvents);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(getBaseContext(), EventPage.class);

                startActivity(intent);
            }
        });
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

    @Override
    public boolean onCreateOptions(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchItem = menu.findItem(R.id.SearchBar);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<String> templist = new ArrayList<>();

                for(String temp : items) {
                    if(temp.toLowerCase().contains(newText.toLowerCase())) {
                        templist.add(temp);
                    }
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, templist);
                listView.setAdapter(adapter);
                return true;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);

    }

}


