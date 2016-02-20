package com.example.shobhit.ass1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class grades_breakup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades_breakup);
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
    private TextView course;
    private TextView content;
    private TextView score;
    private TextView weight;
    private TextView result;
    private TextView total;
    public void get_grades_breakup(){
        //Following variables will re received by JSOn request for grades of a particular course
        //courses/course.json/<course_code>/grades
        int no_of_contents;
        String Course;
        Course="COURSE-->"+Course;
        String Content[]=new String[no_of_contents];
        String Score[]=new String[no_of_contents];
        String Weight[]=new String[no_of_contents];
        String Result[]=new String[no_of_contents];
        String Total;
        Total="Total  ="+Total;
        course=(TextView)findViewById(R.id.textView1);
        course.setText(Course);
        total=(TextView)findViewById(R.id.textView26);
        total.setText(Total);
        int i=0;
        content=(TextView)findViewById(R.id.textView2);
        content.setText(Content[i]);
        score=(TextView)findViewById(R.id.textView3);
        score.setText(Score[i]);
        weight=(TextView)findViewById(R.id.textView4);
        weight.setText(Weight[i]);
        result=(TextView)findViewById(R.id.textView5);
        result.setText(Result[i]);
        i++;
        content=(TextView)findViewById(R.id.textView7);
        content.setText(Content[i]);
        score=(TextView)findViewById(R.id.textView8);
        score.setText(Score[i]);
        weight=(TextView)findViewById(R.id.textView9);
        weight.setText(Weight[i]);
        result=(TextView)findViewById(R.id.textView10);
        result.setText(Result[i]);
        i++;
        content=(TextView)findViewById(R.id.textView12);
        content.setText(Content[i]);
        score=(TextView)findViewById(R.id.textView13);
        score.setText(Score[i]);
        weight=(TextView)findViewById(R.id.textView14);
        weight.setText(Weight[i]);
        result=(TextView)findViewById(R.id.textView15);
        result.setText(Result[i]);
        i++;
        content=(TextView)findViewById(R.id.textView17);
        content.setText(Content[i]);
        score=(TextView)findViewById(R.id.textView18);
        score.setText(Score[i]);
        weight=(TextView)findViewById(R.id.textView19);
        weight.setText(Weight[i]);
        result=(TextView)findViewById(R.id.textView20);
        result.setText(Result[i]);
        i++;
        content=(TextView)findViewById(R.id.textView22);
        content.setText(Content[i]);
        score=(TextView)findViewById(R.id.textView23);
        score.setText(Score[i]);
        weight=(TextView)findViewById(R.id.textView24);
        weight.setText(Weight[i]);
        result=(TextView)findViewById(R.id.textView25);
        result.setText(Result[i]);
        i++;





    }

}
