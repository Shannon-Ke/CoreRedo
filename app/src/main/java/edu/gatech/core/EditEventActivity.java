package edu.gatech.core;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class EditEventActivity extends AppCompatActivity {
    private Event _event;
    private Button tagButton;
    private Spinner tagSpinner;
    private TextView tags;
    private String tagString = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_event);
        tagButton = (Button)findViewById(R.id.button);

        tags = (TextView)findViewById(R.id.textView14);
        tags.setMovementMethod(new ScrollingMovementMethod());

        ArrayAdapter<Attributes> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Attributes.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tagSpinner.setAdapter(adapter);

        tagButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int counter = 0;
                tagSpinner = (Spinner)findViewById(R.id.spinner4);
                    tagString += "  " + tagSpinner.setSelection(_event.getStanding().ordinal());
                    tags.setText(tagString + "  ");
            }

        });
    }
}
