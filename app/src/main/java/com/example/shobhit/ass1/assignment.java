package com.example.shobhit.ass1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class assignment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void assignment_details() {
         String name;
         String file;
         String created_at;
         String registered_course_id;
         String late_days_allowed;
         String type;
         String deadline;
         String id;
         String description;
         TextView Name;
         Name = (TextView) findViewById(R.id.textView2);
         Name.setText(name);
         TextView File;
         File=(TextView) findViewById(R.id.textView4);
         File.setText(file);
        TextView Created_at;
        Created_at=(TextView) findViewById(R.id.textView6);
        Created_at.setText(created_at);
        TextView Registered_course_id;
        Registered_course_id=(TextView) findViewById(R.id.textView8);
        Registered_course_id.setText(registered_course_id);
        TextView Late_days_allowed;
        Late_days_allowed=(TextView) findViewById(R.id.textView10);
        Late_days_allowed.setText(late_days_allowed);
        TextView Type;
        Type=(TextView) findViewById(R.id.textView12);
        Type.setText(type);
        TextView Deadline;
        Deadline=(TextView) findViewById(R.id.textView14);
        Deadline.setText(deadline);
        TextView Id;
        Id=(TextView) findViewById(R.id.textView16);
        Id.setText(id);
        TextView Description;
        Description=(TextView) findViewById(R.id.textView18);
        Description.setText(description);
    }



}
