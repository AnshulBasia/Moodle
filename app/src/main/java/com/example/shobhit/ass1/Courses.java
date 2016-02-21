package com.example.shobhit.ass1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.shobhit.ass1.dummy.course;

public class Courses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
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
        get_courses_data();
    }
    course subject[];
    public void get_courses_data() {
        //use localhost:8000​/default/login.json?userid=username&password=password to login and then
        // ​use localhost:8000/courses/list.json and parse it's response to save the
        // no. of courses, smeseter number and name of courses along with code,description, ltp, credits , id
        int no_of_courses;//no. of courses
        int semester_no; //semester number in which user is enrolled in
        String code[] = new String[no_of_courses];


        Button button[] = new Button[no_of_courses];
        button[0] = (Button) findViewById(R.id.button1);
        button[1] = (Button) findViewById(R.id.button2);
        button[2] = (Button) findViewById(R.id.button3);
        button[3] = (Button) findViewById(R.id.button4);
        button[4] = (Button) findViewById(R.id.button5);
        for (int i = 0; i < no_of_courses; i++) {
            //get these parameters after parsing the Json response ad initialize them

            button[i].setText(code[i]);


        }
    }
        void details(){
        Intent intent =new Intent(this,details_of_course.class);
            startActivity(intent);
    }





}
