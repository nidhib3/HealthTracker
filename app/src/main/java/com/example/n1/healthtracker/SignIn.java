package com.example.n1.healthtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignIn extends AppCompatActivity{
     EditText name,email,password,passwordc,height,weight,age,gender;
     Button signinb,homeb;
    int ht1,wt1,_age1;char _gender1;
    public static int ht,wt,_age;
    public static char _gender;
    Intent iCount,iHome;
    /*
    public void signIn(View view)
    {
        /*
        if((password.equals(passwordc)==false))
        {
            Toast.makeText(SignIn.this,"BOTH PASSWORD DONT MATCH! RE-ENTER",Toast.LENGTH_LONG).show();
            bsignin.setVisibility(View.INVISIBLE);
        }
        else{
            intent=new Intent(SignIn.this,Tracker.class);
        }* /
    }*//*
    public void assign()
    {
        ht1=Integer.parseInt(height.getText().toString());
        wt1=Integer.parseInt(weight.getText().toString());
        _age1=Integer.parseInt(age.getText().toString());
        //_gender1=gender.getText().toString();
        _gender1=gender.getText().toString().charAt(0);
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        name=(EditText) findViewById(R.id.name);
        email=(EditText) findViewById(R.id.email_);
        password =(EditText) findViewById(R.id.password);
        passwordc =(EditText) findViewById(R.id.passwordc);
        height=(EditText) findViewById(R.id.height);
        weight=(EditText) findViewById(R.id.weight);
        gender=(EditText) findViewById(R.id.gender);
        age=(EditText) findViewById(R.id.age);
        signinb=(Button) findViewById(R.id.signinb);
        homeb=(Button) findViewById(R.id.homeb);
        Log.i("EMAIL : ",email.getText().toString());
        Log.i("NAME : ",name.getText().toString());

        iCount=new Intent(SignIn.this, Calculate.class);
        iHome=new Intent(SignIn.this,MainActivity.class);
        try{
        signinb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vCount) {
                //assign();
                ht1=Integer.parseInt(height.getText().toString());
                ht=ht1;
                wt1=Integer.parseInt(weight.getText().toString());wt=wt1;
                _age1=Integer.parseInt(age.getText().toString());
                _age=_age1;
                //_gender1=gender.getText().toString();
                _gender1=gender.getText().toString().charAt(0);
                _gender=_gender1;
                navigate_tracker_count();
            }
        });}catch (Exception e)
        {
            ht1=Integer.parseInt(height.getText().toString());
            wt1=Integer.parseInt(weight.getText().toString());
            _age1=Integer.parseInt(age.getText().toString());
            //_gender1=gender.getText().toString();
            _gender1=gender.getText().toString().charAt(0);
            iCount=new Intent(SignIn.this,Calculate.class);
            startActivity(iCount);
        }
        try{
        homeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vH) {
                navigate_home();
            }
        });}
        catch (Exception e)
        {
            iHome=new Intent(SignIn.this,MainActivity.class);
            startActivity(iHome);
        }
        /*ht=ht1;
        wt=wt1;
        _age=_age1;
        _gender=_gender1;*/
    }
    public void navigate_tracker_count()
    {
        iCount=new Intent(SignIn.this,Calculate.class);
        startActivity(iCount);
    }
    public void navigate_home()
    {
        iHome=new Intent(SignIn.this,MainActivity.class);
        startActivity(iHome);
    }
}
