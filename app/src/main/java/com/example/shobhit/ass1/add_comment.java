package com.example.shobhit.ass1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class add_comment extends AppCompatActivity {

    String api="/threads/post_comment.json?thread_id=<thread_id>&description=<desc";
    EditText Comment;
    Button Post;
    String comment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Comment=(EditText)findViewById(R.id.editText5);
        Post=(Button)findViewById(R.id.button6);
        Post.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                try {

                    // CALL GetText method to make post method call
                    GetText();
                } catch (Exception ex) {
                    Comment.setText(" url exeption! ");
                }
            }
        });


    // Create GetText Metod
        setContentView(R.layout.activity_add_comment);
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

    public void GetText(){
        comment=Comment.getText().toString();
        String data = URLEncoder.encode("comment", "UTF-8")
                + "=" + URLEncoder.encode(comment, "UTF-8");
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
        Comment.setText(text);

    }

}


