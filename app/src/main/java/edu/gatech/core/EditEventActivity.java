package edu.gatech.core;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EditEventActivity extends AppCompatActivity {
    private Event _event;
    private EditText name, from, to, org, location, description;
    private Button tagButton;
    private Spinner tagSpinner, monthSpinner, daySpinner, yearSpinner;
    private TextView tags;
    private String tagString;
    private ContentEvent cEvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_event);
        tagButton = (Button)findViewById(R.id.button);
        tagString = "";
        name = (EditText)findViewById(R.id.editText);
        from = (EditText)findViewById(R.id.editText2);
        to = (EditText)findViewById(R.id.editText3);
        org = findViewById(R.id.editText4);
        location = findViewById(R.id.editText6);
        description = findViewById(R.id.EditTextFeedbackBody);


        monthSpinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapterM = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Event.Months);
        adapterM.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthSpinner.setAdapter(adapterM);
        daySpinner = findViewById(R.id.spinner2);
        List<Integer> dayz = new ArrayList<Integer>();
        for (int i = 1; i <= 31; i++) {
            dayz.add(i);
        }
        ArrayAdapter<String> adapterD = new ArrayAdapter(this,android.R.layout.simple_spinner_item, dayz);
        adapterD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daySpinner.setAdapter(adapterD);
        List <Integer> yearz = new ArrayList<>();
        for (int i = 2018; i <= 2025; i++) {
            yearz.add(i);
        }
        yearSpinner = findViewById(R.id.spinner3);
        ArrayAdapter<String> adapterY = new ArrayAdapter(this,android.R.layout.simple_spinner_item, yearz);
        adapterY.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(adapterY);
        cEvent = new ContentEvent();
        _event = new Event();
        tags = (TextView)findViewById(R.id.textView14);
        tags.setMovementMethod(new ScrollingMovementMethod());
        tagSpinner = (Spinner)findViewById(R.id.spinner4);
        ArrayAdapter<Attributes> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Attributes.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tagSpinner.setAdapter(adapter);
//        _event = (Event) getIntent().getParcelableExtra(_event.getName());
//        monthSpinner.setSelection(Event.findPosition(_event.getMonth()));
//        name.setText(_event.getName());

        tagButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                tagString += tagSpinner.getSelectedItem() + "  ";
                tags.setText(tagString + "  ");
            }

        });
    }
    public void onAddPressed(View view) {

        Model model = Model.getInstance();

        _event.setName(name.getText().toString());
        _event.setDate((String) monthSpinner.getSelectedItem() + " " + daySpinner.getSelectedItem() + ", " + yearSpinner.getSelectedItem());
        _event.setStart(from.getText().toString());
        _event.setEnd(to.getText().toString());
        _event.setOrg(org.getText().toString());
        model.addToList(_event);


        //cEvent.reload();
        finish();
        Intent refresh = new Intent(this, ContentEvent.class);
        startActivity(refresh);
    }
}

