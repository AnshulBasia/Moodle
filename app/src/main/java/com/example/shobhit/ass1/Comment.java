package com.example.shobhit.ass1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Comment extends AppCompatActivity {

    EditText Course_code;
    EditText Thread;
    Button Comment;
    Button Post;
    String code,thread;
    String api="/threads/new.json?title=<title>&description=<desc>&course_code=<coursecode>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        Course_code=(EditText)findViewById(R.id.editText3);
        Thread=(EditText)findViewById(R.id.editText4);
        Comment=(Button)findViewById(R.id.button4);
        Post=(Button)findViewById(R.id.button5);

        Post.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                try {

                    // CALL GetText method to make post method call
                    GetText();
                } catch (Exception ex) {
                    Course_code.setText(" url exeption! ");
                }
            }
        });
    }

    // Create GetText Metod
    public  void  GetText()  throws UnsupportedEncodingException
    {
        // Get user defined values
        code = Course_code.getText().toString();
        thread   = Thread.getText().toString();


        // Create data variable for sent values to server

        String data = URLEncoder.encode("course-code", "UTF-8")
                + "=" + URLEncoder.encode(code, "UTF-8");

        data += "&" + URLEncoder.encode("thread", "UTF-8") + "="
                + URLEncoder.encode(thread, "UTF-8");



        String text = "";
        BufferedReader reader=null;
        ///MODIFY URL ACCORDINGLY

        // Send data
        try
        {

            // Defined URL  where to send data
            URL url = new URL(api);

            // Send POST data request

            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write( data );
            wr.flush();

            // Get the server response

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while((line = reader.readLine()) != null)
            {
                // Append server response in string
                sb.append(line + "\n");
            }


            text = sb.toString();
        }
        catch(Exception ex)
        {

        }
        finally
        {
            try
            {

                reader.close();
            }

            catch(Exception ex) {}
        }

        // Show response on activity
        Course_code.setText(text);

    }

    public void comment(View view){
        Intent intent=new Intent(this,add_comment.class);
    }

}




