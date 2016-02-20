package com.example.shobhit.ass1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.NumberKeyListener;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.NetworkResponse;
import com.android.volley.toolbox.Volley;


//import org.apache.http.impl.client.BasicCookieStore;
//import org.apache.http.client.CookieStore;
//import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {


    public static final String JSON_URL ="http://10.192.45.86:8000/default/login.json?userid=cs1110200&password=john";
    public static final String JSON_COURSES="http://10.192.45.86:8000/courses/list.json";
    private static final String SET_COOKIE_KEY = "Set-Cookie";
    private static final String COOKIE_KEY = "Cookie";
    private static final String SESSION_COOKIE = "sessionid";
    private static MainActivity _instance;
    private RequestQueue requestQueue;
    private SharedPreferences preferences;

    public static MainActivity get() {
        return _instance;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _instance=this;
        setContentView(R.layout.activity_main);
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
    public void sendrequest(){
        requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET,JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        getJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        //RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public final void checkSessionCookie(Map<String, String> headers) {
        System.out.println("yoyo1");
        if (headers.containsKey(SET_COOKIE_KEY)
                && headers.get(SET_COOKIE_KEY).startsWith(SESSION_COOKIE)) {
            String cookie = headers.get(SET_COOKIE_KEY);
            if (cookie.length() > 0) {
                String[] splitCookie = cookie.split(";");
                String[] splitSessionId = splitCookie[0].split("=");
                cookie = splitSessionId[1];
                System.out.println(cookie);
                SharedPreferences.Editor prefEditor = preferences.edit();
                prefEditor.putString(SESSION_COOKIE, cookie);
                prefEditor.commit();
            }
        }
    }
    /**
     * Adds session cookie to headers if exists.
     * @param headers
     */
    public final void addSessionCookie(Map<String, String> headers) {
        System.out.println("yoyo");
        String sessionId = preferences.getString(SESSION_COOKIE, "");
        System.out.println(sessionId);
        if (sessionId.length() > 0) {
            StringBuilder builder = new StringBuilder();
            builder.append(SESSION_COOKIE);
            builder.append("=");
            builder.append(sessionId);
            if (headers.containsKey(COOKIE_KEY)) {
                builder.append("; ");
                builder.append(headers.get(COOKIE_KEY));
            }
            System.out.println(builder);
            headers.put(COOKIE_KEY, builder.toString());
        }
    }


    public void getJSON(String json){
        try {
            JSONObject jObject = new JSONObject(json);
            String success1 = jObject.getString("success");
            if (success1.equals("true")) {
                Toast.makeText(MainActivity.this, "login successful", Toast.LENGTH_LONG).show();
            }
        }
        catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }
    public void get_courses(){
        requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET,JSON_COURSES,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        get_JSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        requestQueue.add(stringRequest);
    }
    public void get_JSON(String json){
        String[] course_names={};
        try
        {
            System.out.println("HURRAY");
            JSONObject jobject= new JSONObject(json);
            JSONArray courses=jobject.getJSONArray("courses");
            System.out.println(courses);
            for(int i=0;i<courses.length();i++){
                JSONObject jo = courses.getJSONObject(i);
                course_names[i] = jo.getString("name");
                Toast.makeText(MainActivity.this,"courses", Toast.LENGTH_LONG).show();
                System.out.println("HURRAY");
            }

        }
        catch (org.json.JSONException e) {
            e.printStackTrace();
        }

    }
    public void submit(View view){
        sendrequest();
    }
    public void courses_list(View view){
        get_courses();
    }
}
