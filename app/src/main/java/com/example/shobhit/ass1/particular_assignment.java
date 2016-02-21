package com.example.shobhit.ass1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.shobhit.ass1.dummy.course;

public class particular_assignment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particular_assignment);
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
    public void get_assignment(){
        Intent intent = new Intent(this, assignment.class);
        startActivity(intent);

    }
    public void get_registered(){
        Intent intent=new Intent(this, registered.class);
        startActivity(intent);
    }
    public void get_course(){
        Intent intent =new Intent(this, details_of_course.class);
        startActivity(intent);
    }





}
