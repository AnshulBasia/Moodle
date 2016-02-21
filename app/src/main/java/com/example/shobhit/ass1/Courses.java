package com.example.shobhit.ass1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.shobhit.ass1.dummy.course;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Courses extends AppCompatActivity {

    public final String IP_ADDRESS="http://10.192.45.86:8000";
    public final String API_COURSES=IP_ADDRESS+"/courses/list.json";
    private RequestQueue requestQueue;
    private SharedPreferences preferences;


    public int no_of_courses;
    public ArrayList<String> course_names=new ArrayList<>();                                //this store the name of courses
    public ArrayList<String> course_codes=new ArrayList<>();

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
        get_courses();
        get_courses_data();

    }
    course subject[];
    public void get_courses_data() {
        //use localhost:8000​/default/login.json?userid=username&password=password to login and then
        // ​use localhost:8000/courses/list.json and parse it's response to save the
        // no. of courses, smeseter number and name of courses along with code,description, ltp, credits , id
       //no. of courses
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
            code[i]=course_codes.get(i)+";"+course_names.get(i);
            button[i].setText(code[i]);
        }
        for(int i=no_of_courses;i<=5;i++){              //TODO to get the no. of courses
            View b=
        }

    }//
    public void get_courses(){
        requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET,API_COURSES,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        response_courses(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Courses.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        requestQueue.add(stringRequest);
    }

    public void response_courses(String json){

        try
        {
            JSONObject jobject= new JSONObject(json);
            JSONArray courses=jobject.getJSONArray("courses");
            no_of_courses = courses.length();
            for(int i=0;i<courses.length();i++){
                JSONObject jo = courses.getJSONObject(i);
                course_names.add(jo.getString("name"));
                course_codes.add(jo.getString("code"));

                //TODO change mainactivity to whatever activity
                //System.out.println("HURRAY");
            }

        }
        catch (org.json.JSONException e) {
            e.printStackTrace();
        }

    }


    void details(View v){
        Intent intent =new Intent(this,details_of_course.class);
            startActivity(intent);
    }

}
