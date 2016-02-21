package com.example.shobhit.ass1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class details_of_course extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_course);
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

    void course_details(){
        String code;
        String name;
        String description;
        String credits;
        String id;
        String l_t_p;
        TextView Code;
        TextView LTP;
        TextView Name;
        TextView Description;
        TextView Credit;
        TextView Id;
        Code=(TextView)findViewById(R.id.textView3);
        Code.setText(code);
        LTP=(TextView)findViewById(R.id.textView5);
        LTP.setText(l_t_p);
        Name=(TextView)findViewById(R.id.textView8);
        Name.setText(name);
        Description=(TextView)findViewById(R.id.textView10);
        Description.setText(description);
        Credit=(TextView)findViewById(R.id.textView12);
        Credit.setText(credits);
        Id=(TextView)findViewById(R.id.textView14);
        Id.setText(id);

    }

}
