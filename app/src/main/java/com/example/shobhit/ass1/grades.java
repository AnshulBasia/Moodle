package com.example.shobhit.ass1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.*;


 class grade_class{
    String course_name;
    String grade_item;
    String score;
    String weight;
    String result;
     public grade_class(String a,String b,String c, String d, String e){
         course_name=a;
         grade_item=b;
         score=c;
         weight=d;
         result=e;
     }
     public String name(){return course_name;}
     public String item(){return grade_item;}
     public String score(){return score;}
     public String weight(){return weight;}
     public String result(){return result;}

}
public class grades extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);
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
    grade_class grades[];
    private TextView course;
    private TextView content;
    private TextView scoree;
    private TextView weightage;
    private TextView resultt;
    public void get_grades(){
        //Following parameters will be obtained by json request from the address localhost:8000/default/grades.json
        int no_of_courses;
        String course_name[]=new String[no_of_courses];
        String grade_item[]=new String[no_of_courses];
        String score[]=new String[no_of_courses];
        String weight[]=new String[no_of_courses];
        String result[]=new String[no_of_courses];

        grade_class grades[]=new grade_class[no_of_courses];
        for(int i=0;i<no_of_courses;i++){
            grades[i]=new grade_class(course_name[i],grade_item[i],score[i],weight[i],result[i]);
        }
        int i=0;
        course=(TextView)findViewById(R.id.textView1);
        course.setText(course_name[i]);
        content=(TextView)findViewById(R.id.textView2);
        content.setText(grade_item[i]);
        scoree=(TextView)findViewById(R.id.textView3);
        scoree.setText(score[i]);
        weightage=(TextView)findViewById(R.id.textView4);
        weightage.setText(weight[i]);
        resultt=(TextView)findViewById(R.id.textView5);
        resultt.setText(result[i]);
        i++;
        course=(TextView)findViewById(R.id.textView6);
        course.setText(course_name[i]);
        content=(TextView)findViewById(R.id.textView7);
        content.setText(grade_item[i]);
        scoree=(TextView)findViewById(R.id.textView8);
        scoree.setText(score[i]);
        weightage=(TextView)findViewById(R.id.textView9);
        weightage.setText(weight[i]);
        resultt=(TextView)findViewById(R.id.textView10);
        resultt.setText(result[i]);
        i++;
        course=(TextView)findViewById(R.id.textView11);
        course.setText(course_name[i]);
        content=(TextView)findViewById(R.id.textView12);
        content.setText(grade_item[i]);
        scoree=(TextView)findViewById(R.id.textView13);
        scoree.setText(score[i]);
        weightage=(TextView)findViewById(R.id.textView14);
        weightage.setText(weight[i]);
        resultt=(TextView)findViewById(R.id.textView15);
        resultt.setText(result[i]);
        i++;
        course=(TextView)findViewById(R.id.textView16);
        course.setText(course_name[i]);
        content=(TextView)findViewById(R.id.textView17);
        content.setText(grade_item[i]);
        scoree=(TextView)findViewById(R.id.textView18);
        scoree.setText(score[i]);
        weightage=(TextView)findViewById(R.id.textView19);
        weightage.setText(weight[i]);
        resultt=(TextView)findViewById(R.id.textView20);
        resultt.setText(result[i]);
        i++;
        course=(TextView)findViewById(R.id.textView21);
        course.setText(course_name[i]);
        content=(TextView)findViewById(R.id.textView22);
        content.setText(grade_item[i]);
        scoree=(TextView)findViewById(R.id.textView23);
        scoree.setText(score[i]);
        weightage=(TextView)findViewById(R.id.textView24);
        weightage.setText(weight[i]);
        resultt=(TextView)findViewById(R.id.textView25);
        resultt.setText(result[i]);
    }

}
