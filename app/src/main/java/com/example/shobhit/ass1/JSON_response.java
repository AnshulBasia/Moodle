package com.example.shobhit.ass1;

import android.widget.Toast;

import com.example.shobhit.ass1.Login;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ANSHUL BASIA on 21/02/2016.
 */

public class JSON_response {


    public static void response_login(String json){
        try {
            JSONObject jObject = new JSONObject(json);
            String success1 = jObject.getString("success");
            if (success1.equals("true")) {                                                      //TODO generate intent and also something like hello username
                Toast.makeText(Login.get(), "login successful", Toast.LENGTH_LONG).show();
            }
        }
        catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }


    public static void response_notifications(String json){
        ArrayList<String> desc=new ArrayList<>();
        ArrayList<String> is_seen=new ArrayList<>();                                //this store the name of courses
        ArrayList<String> created_at=new ArrayList<>();
        try
        {
            JSONObject jobject= new JSONObject(json);
            JSONArray notifications=jobject.getJSONArray("notifications");

            for(int i=0;i<notifications.length();i++){
                JSONObject jo = notifications.getJSONObject(i);
                desc.add(jo.getString("description"));
                is_seen.add(jo.getString("is_seen"));
                created_at.add(jo.getString("created"));

                Toast.makeText(MainActivity.get(),notifications.toString(), Toast.LENGTH_LONG).show();               //TODO change mainactivity to whatever activity
                //System.out.println("HURRAY");
            }

        }
        catch (org.json.JSONException e) {
            e.printStackTrace();
        }

    }

    public static void response_grades(String json){                    //TODO add a field of course too
        ArrayList grades_names=new ArrayList();
        ArrayList grades_weightage=new ArrayList();
        ArrayList grades_score=new ArrayList();
        ArrayList grades_maximum=new ArrayList();
        try
        {
            JSONObject jobject= new JSONObject(json);
            JSONArray grades=jobject.getJSONArray("grades");
            System.out.println(grades);
            for(int i=0;i<grades.length();i++){
                JSONObject jo = grades.getJSONObject(i);
                grades_names.add(jo.getString("name"));
                grades_weightage.add(jo.getString("weightage"));
                grades_score.add(jo.getString("score"));
                grades_maximum.add(jo.getString("out_of"));

                Toast.makeText(MainActivity.get(),grades_names.toString(), Toast.LENGTH_LONG).show();
                System.out.println("HURRAY");
            }
        }
        catch (org.json.JSONException e) {
            e.printStackTrace();
        }

    }

    public static void response_listassignments(String json) {                                       //TODO this function
        ArrayList assignment_names = new ArrayList();
        ArrayList assignment_id = new ArrayList();
        ArrayList deadline = new ArrayList();
        ArrayList description = new ArrayList();
        try {
            JSONObject jobject = new JSONObject(json);
            JSONArray assignment = jobject.getJSONArray("assignments");
            System.out.println(assignment);
            for (int i = 0; i < assignment.length(); i++) {
                JSONObject jo = assignment.getJSONObject(i);
                assignment_names.add(jo.getString("name"));
                assignment_id.add(jo.getString("id"));
                deadline.add(jo.getString("deadline"));
                description.add(jo.getString("description"));

                Toast.makeText(MainActivity.get(), assignment_names.toString(), Toast.LENGTH_LONG).show();
                System.out.println("HURRAY");
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    public static void response_infoassignments(String json){                                       //TODO this function
        ArrayList assignment_name=new ArrayList();
        ArrayList deadline=new ArrayList();
        ArrayList description=new ArrayList();
        try
        {
            JSONObject jobject= new JSONObject(json);
            JSONArray info=jobject.getJSONArray("assignments");
            System.out.println(info);
            for(int i=0;i<info.length();i++){
                JSONObject jo = info.getJSONObject(i);
                assignment_name.add(jo.getString("name"));
                deadline.add(jo.getString("deadline"));
                description.add(jo.getString("description"));

                Toast.makeText(MainActivity.get(),assignment_name.toString(), Toast.LENGTH_LONG).show();
                System.out.println("HURRAY");
            }
        }
        catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    public static void response_course_grades(String json) {
        ArrayList grades_names = new ArrayList();
        ArrayList grades_weightage = new ArrayList();
        ArrayList grades_score = new ArrayList();
        ArrayList grades_maximum = new ArrayList();
        try {
            JSONObject jobject = new JSONObject(json);
            JSONArray grades = jobject.getJSONArray("grades");
            System.out.println(grades);
            for (int i = 0; i < grades.length(); i++) {
                JSONObject jo = grades.getJSONObject(i);
                grades_names.add(jo.getString("name"));
                grades_weightage.add(jo.getString("weightage"));
                grades_score.add(jo.getString("score"));
                grades_maximum.add(jo.getString("out_of"));

                Toast.makeText(MainActivity.get(), grades_names.toString(), Toast.LENGTH_LONG).show();
                System.out.println("HURRAY");
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    public static void response_course_threads(String json){
        ArrayList threads_title=new ArrayList();
        ArrayList threads_desc=new ArrayList();
        ArrayList threads_createdat=new ArrayList();

        try
        {
            JSONObject jobject= new JSONObject(json);
            JSONArray threads=jobject.getJSONArray("course_threads");

            for(int i=0;i<threads.length();i++){
                JSONObject jo = threads.getJSONObject(i);
                threads_title.add(jo.getString("name"));
                threads_desc.add(jo.getString("description"));
                threads_createdat.add(jo.getString("created_at"));

                Toast.makeText(MainActivity.get(),threads_title.toString(), Toast.LENGTH_LONG).show();
                System.out.println("HURRAY");
            }
        }
        catch (org.json.JSONException e) {
            e.printStackTrace();
        }

    }

    public static void response_info_threads(String json){
        String threads_title="";
        String threads_desc="";
        String threads_createdat="";
        ArrayList threads_comments_desc=new ArrayList();
        ArrayList threads_comments_userid=new ArrayList();
        ArrayList threads_comments_person=new ArrayList();

        try
        {
            JSONObject jobject= new JSONObject(json);
            JSONObject thread=jobject.getJSONObject("thread");
            JSONArray comments=jobject.getJSONArray("comments");
            threads_title=(thread.getString("name"));
            threads_desc=(thread.getString("description"));
            threads_createdat=(thread.getString("created_at"));

            for(int i=0;i<comments.length();i++){
                JSONObject jo = comments.getJSONObject(i);
                threads_comments_desc.add(jo.getString("description"));
                threads_comments_userid.add(jo.getString("user_id"));
                Toast.makeText(MainActivity.get(),threads_title.toString(), Toast.LENGTH_LONG).show();
                System.out.println("HURRAY");
            }

            JSONArray comment_users=jobject.getJSONArray("comment_users");
            for(int i=0;i<threads_comments_userid.size();i++)
            {

                for(int j=0;j<comment_users.length();j++)
                {
                    if(comment_users.getJSONObject(j).getString("id").equals(threads_comments_userid.get(i))){
                        threads_comments_person.add(comment_users.getJSONObject(j).getString("first_name"));
                        break;
                    }
                    j++;
                }

            }


        }
        catch (org.json.JSONException e) {
            e.printStackTrace();
        }

    }

}

