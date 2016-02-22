package com.example.shobhit.ass1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ANSHUL BASIA on 22/02/2016.
 */
public class Courses extends AppCompatActivity {

    public final String IP_ADDRESS = Login.ipaddress();
    public final String API_COURSES = IP_ADDRESS + "/courses/list.json";

    private static final String SET_COOKIE_KEY = "Set-Cookie";
    private static final String COOKIE_KEY = "Cookie";
    private static final String SESSION_COOKIE = "session_id_moodleplus";
    private RequestQueue requestQueue;
    private SharedPreferences preferences;
    ArrayList<String> course_names=new ArrayList<>();                                //this store the name of courses
    ArrayList<String> course_codes=new ArrayList<>();
    ArrayList<String> course_credits=new ArrayList<>();                                //this store the credit of courses
    ArrayList<String> course_ltp=new ArrayList<>();

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, API_COURSES,
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public void get_courses(View view) {
        requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, API_COURSES,
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

            for(int i=0;i<courses.length();i++){
                JSONObject jo = courses.getJSONObject(i);
                course_names.add(jo.getString("name"));
                course_codes.add(jo.getString("code"));
                course_credits.add(jo.getString("credits"));
                course_ltp.add(jo.getString("l_t_p"));

                Toast.makeText(Courses.this,course_names.toString(), Toast.LENGTH_LONG).show();               //TODO change mainactivity to whatever activity
                //System.out.println("HURRAY");
            }

        }
        catch (org.json.JSONException e) {
            e.printStackTrace();
        }

    }
    public String[] details(String s)
    {
        String[] details=new String[4];
        for(int i=0;i<course_names.size();i++)
        {
            if(s.equals(course_names.get(i)))
            {
                details[0]=course_names.get(i);
                details[1]=course_codes.get(i);
                details[2]=course_credits.get(i);
                details[3]=course_ltp.get(i);
            }
        }
        return details;
    }

}