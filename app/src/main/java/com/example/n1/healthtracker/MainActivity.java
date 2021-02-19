package com.example.n1.healthtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.n1.healthtracker.Tracker.currentH2O;

public class MainActivity extends AppCompatActivity {
    Intent iSignIn,iLogIn;
    Button Blogin,Bsignin;
    public static double currenth2O=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currenth2O=currentH2O;
        Blogin=(Button) findViewById(R.id.Blogin);
        Bsignin=(Button) findViewById(R.id.Bsignin);
        Bsignin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View vSignin)
            {
                navigate_signin();
            }
        });
        Blogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View vLogin)
        {
            navigate_login();
        }
        });
    }
    public void navigate_signin()
    {
        iSignIn=new Intent(MainActivity.this,SignIn.class);
        startActivity(iSignIn);
    }
    public void navigate_login()
    {
        iLogIn=new Intent(MainActivity.this,LogIn.class);
        startActivity(iLogIn);
    }
}
