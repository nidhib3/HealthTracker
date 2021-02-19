package com.example.n1.healthtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.n1.healthtracker.Tracker.currentH2O;

public class LogIn extends AppCompatActivity {
    Intent iCount,iHome;
    EditText email_,password_;
    public static double currenth2O=0;
    Button bhome,loginb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        currenth2O=currentH2O;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        loginb=(Button)findViewById(R.id.loginb);
        bhome=(Button) findViewById(R.id.bhome);
        bhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vH) {
                navigate_home();
            }
        });

        email_=(EditText) findViewById(R.id.email_);
        password_=(EditText)findViewById(R.id.password_);
        try{
            loginb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View vCount) {
                    //assign();
                    navigate_tracker_count();
                }
            });}catch (Exception e)
        {
            iCount=new Intent(LogIn.this,Calculate.class);
            startActivity(iCount);
        }
    }
    public void navigate_home()
    {
        iHome=new Intent(LogIn.this,MainActivity.class);
        startActivity(iHome);
    }public void navigate_tracker_count()
    {
        iCount=new Intent(LogIn.this,Calculate.class);
        startActivity(iCount);
    }
}
