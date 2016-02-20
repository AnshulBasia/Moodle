package com.example.shobhit.ass1;

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
    public void get_courses_data(){
        //use localhost:8000​/default/login.json?userid=username&password=password to login and then
        // ​use localhost:8000/courses/list.json and parse it's response to save the
        // no. of courses, smeseter number and name of courses along with code,description, ltp, credits , id
        int no_of_courses;//no. of courses
        int semester_no; //semester number in which user is enrolled in
        String code[]=new String[no_of_courses];
        String name[]=new String[no_of_courses];
        String description[]=new String[no_of_courses];
        String credits[]=new String[no_of_courses];
        String id[]=new String[no_of_courses];
        String l_t_p[]=new String[no_of_courses];

        course subject[]=new course[no_of_courses];
        Button button[]=new Button[no_of_courses];
        button[0]=(Button)findViewById(R.id.button1);
        button[1]=(Button)findViewById(R.id.button2);
        button[2]=(Button)findViewById(R.id.button3);
        button[3]=(Button)findViewById(R.id.button4);
        button[4]=(Button)findViewById(R.id.button5);
        for(int i=0;i<no_of_courses;i++){
            //get these parameters after parsing the Json response ad initialize them

            subject[i]=new course(code[i],name[i],description[i],credits[i],id[i],l_t_p[i]);
            button[i].setText(code[i]);


        }




    }
    private TextView Code;
    private TextView code;
    private TextView LTP;
    private TextView ltp;
    private TextView Name;
    private TextView name;
    private TextView Description;
    private TextView description;
    private TextView Credit;
    private TextView credit;
    private TextView Id;
    private TextView id;


    public void first(){
        code=(TextView)findViewById(R.id.textView3);
        code.setText(subject[0].get_code());
        ltp=(TextView)findViewById(R.id.textView5);
        ltp.setText(subject[0].get_ltp());
        name=(TextView)findViewById(R.id.textView8);
        name.setText(subject[0].get_name());
        description=(TextView)findViewById(R.id.textView10);
        description.setText(subject[0].get_description());
        credit=(TextView)findViewById(R.id.textView12);
        credit.setText(subject[0].get_credit());
        id=(TextView)findViewById(R.id.textView14);
        id.setText(subject[0].get_id());

    }
    public void second(){
        code=(TextView)findViewById(R.id.textView3);
        code.setText(subject[1].get_code());
        ltp=(TextView)findViewById(R.id.textView5);
        ltp.setText(subject[1].get_ltp());
        name=(TextView)findViewById(R.id.textView8);
        name.setText(subject[1].get_name());
        description=(TextView)findViewById(R.id.textView10);
        description.setText(subject[1].get_description());
        credit=(TextView)findViewById(R.id.textView12);
        credit.setText(subject[1].get_credit());
        id=(TextView)findViewById(R.id.textView14);
        id.setText(subject[1].get_id());

    }
    public void third(){
        code=(TextView)findViewById(R.id.textView3);
        code.setText(subject[2].get_code());
        ltp=(TextView)findViewById(R.id.textView5);
        ltp.setText(subject[2].get_ltp());
        name=(TextView)findViewById(R.id.textView8);
        name.setText(subject[2].get_name());
        description=(TextView)findViewById(R.id.textView10);
        description.setText(subject[2].get_description());
        credit=(TextView)findViewById(R.id.textView12);
        credit.setText(subject[2].get_credit());
        id=(TextView)findViewById(R.id.textView14);
        id.setText(subject[2].get_id());

    }
    public void fourth(){
        code=(TextView)findViewById(R.id.textView3);
        code.setText(subject[3].get_code());
        ltp=(TextView)findViewById(R.id.textView5);
        ltp.setText(subject[3].get_ltp());
        name=(TextView)findViewById(R.id.textView8);
        name.setText(subject[3].get_name());
        description=(TextView)findViewById(R.id.textView10);
        description.setText(subject[3].get_description());
        credit=(TextView)findViewById(R.id.textView12);
        credit.setText(subject[3].get_credit());
        id=(TextView)findViewById(R.id.textView14);
        id.setText(subject[3].get_id());

    }
    public void fifth(){
        code=(TextView)findViewById(R.id.textView3);
        code.setText(subject[4].get_code());
        ltp=(TextView)findViewById(R.id.textView5);
        ltp.setText(subject[4].get_ltp());
        name=(TextView)findViewById(R.id.textView8);
        name.setText(subject[4].get_name());
        description=(TextView)findViewById(R.id.textView10);
        description.setText(subject[4].get_description());
        credit=(TextView)findViewById(R.id.textView12);
        credit.setText(subject[4].get_credit());
        id=(TextView)findViewById(R.id.textView14);
        id.setText(subject[4].get_id());

    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
     */

}
