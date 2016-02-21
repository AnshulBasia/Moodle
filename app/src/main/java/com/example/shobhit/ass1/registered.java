package com.example.shobhit.ass1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class registered extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
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
    void get_registered{
        String starting_date,id,professor,semester,ending_date,year,course_id;
        TextView Name;
        Name = (TextView) findViewById(R.id.textView2);
        Name.setText(starting_date);
        TextView File;
        File=(TextView) findViewById(R.id.textView4);
        File.setText(id);
        TextView Created_at;
        Created_at=(TextView) findViewById(R.id.textView6);
        Created_at.setText(professor);
        TextView Registered_course_id;
        Registered_course_id=(TextView) findViewById(R.id.textView8);
        Registered_course_id.setText(semester);
        TextView Late_days_allowed;
        Late_days_allowed=(TextView) findViewById(R.id.textView10);
        Late_days_allowed.setText(ending_date);
        TextView Type;
        Type=(TextView) findViewById(R.id.textView12);
        Type.setText(year);
        TextView Deadline;
        Deadline=(TextView) findViewById(R.id.textView14);
        Deadline.setText(course_id);





    }

}
