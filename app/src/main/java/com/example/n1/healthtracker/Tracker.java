package com.example.n1.healthtracker;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import java.math.*;
import static com.example.n1.healthtracker.Calculate.h2oDaily;
import static java.lang.Math.round;
/*
import static com.example.n1.healthtracker.R.id.height;
import static com.example.n1.healthtracker.SignIn._age;
import static com.example.n1.healthtracker.SignIn._gender;
import static com.example.n1.healthtracker.SignIn.ht;
import static com.example.n1.healthtracker.SignIn.wt;*/
/*
//1 kg = 2.2046 lb
// kg*2.2046*2.2*agefactor/28.3/4 glass
// 0-15=50
//15-30=40
//30-55=45
//55>=30
//1 liter = 33.814022702 fluid ounce*/
public class Tracker extends AppCompatActivity{
    public TextView perAmt;
    public SeekBar seePerAmt;
    public ProgressBar progressPerAmt;
    public static double currentH2O=0,currentPerH2O,h2o_Daily_;//current h20 drank till now,//daily h20 for body
    Button addh2o;
    String proText;
    int h20CurrentDrink=250,h2oDaily_,amtH2ODrank=250,progress;
    EditText amtH2Odrank;

    public void onClick_(View vProgress)
    {
        h2o_Daily_=h2oDaily;
        addh2o=(Button)findViewById(R.id.addh2o);
        amtH2Odrank=(EditText)findViewById(R.id.amtH2Odrank);
        perAmt=(TextView) findViewById(R.id.perAmt);
        //seePerAmt=(SeekBar) findViewById(R.id.seekPerAmt);
        progressPerAmt=(ProgressBar) findViewById(R.id.proPerAmt);
        try {
            h2o_Daily_=h2oDaily;
            h2oDaily_ = ((int) (round(h2oDaily * 1000)));
            progressPerAmt.setMax((int)h2oDaily_/10);
            amtH2ODrank = (Integer.parseInt(amtH2Odrank.getText().toString()));
            currentH2O += (amtH2ODrank);
            progressPerAmt.setProgress((int)((currentH2O*1.76*39/h2o_Daily_)));
            proText=Double.toString((((int) ((currentH2O/(h2o_Daily_))))));
            perAmt.setText(proText + " %");
        }
        catch (Exception e)
        {
            /*
            h2o_Daily_=h2oDaily;
            h2oDaily_ = ((int) (round(h2oDaily * 1000)));
            progressPerAmt.setMax((int)h2oDaily_/10);
            amtH2ODrank = (Integer.parseInt(amtH2Odrank.getText().toString()));
            currentH2O += (amtH2ODrank);
            progressPerAmt.setProgress((int)((currentH2O+1)));
            proText=Double.toString((((int) ((currentH2O/(h2o_Daily_*10))))));
            perAmt.setText(proText + " %");*/
            h2o_Daily_=h2oDaily;
            h2oDaily_ = ((int) (round(h2oDaily * 1000)));
            progressPerAmt.setMax((int)h2oDaily_/10);
            amtH2ODrank = (Integer.parseInt(amtH2Odrank.getText().toString()));
            currentH2O += (amtH2ODrank);
            progressPerAmt.setProgress((int)((currentH2O*1.76*39/h2o_Daily_)));
            proText=Double.toString((((int) ((currentH2O/(h2o_Daily_))))));
            perAmt.setText(proText + " %");
        }
        /*h2oDaily_ = ((int) (round(h2oDaily * 1000)));
            progressPerAmt.setMax(h2oDaily_*1000);
            amtH2ODrank = (Integer.parseInt(amtH2Odrank.getText().toString()));
            currentH2O += (amtH2ODrank);
            progressPerAmt.setProgress((int) ((currentH2O)));
            proText=Double.toString((((int) ((currentH2O/(h2o_Daily_*10))))));
            perAmt.setText(proText + " %");*/
        //seePerAmt.setProgress((int)currentH2O);
        //seePerAmt.setMax(h2oDaily_*1000);
        //seePerAmt.setProgress((int)currentH2O);

        /*seePerAmt.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                amtH2ODrank=(Integer.parseInt(amtH2Odrank.getText().toString()));
                currentH2O+=(progress+amtH2ODrank);
                progress=(int)currentH2O;
                progressPerAmt.setProgress(progress);
                seePerAmt.setProgress(progress);
                proText=Double.toString(((currentH2O/h2o_Daily_)*100));
                perAmt.setText(proText +" %");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });*/
        /*
        try{
            addh2o.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View vProgress) {
                    amtH2ODrank=(Integer.parseInt(amtH2Odrank.getText().toString()));
                    seePerAmt.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
                    {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                            currentH2O+=(amtH2ODrank);
                            progress=((int)currentH2O);
                            progressPerAmt.setProgress(progress/h2oDaily_);
                            seePerAmt.setProgress(progress/h2oDaily_);
                            proText=Double.toString((((currentH2O/h2o_Daily_)*100)));
                            perAmt.setText(proText +" %");
                        }
                        /*seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    int val = (progress * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
                    textView.setText("" + progress);
                    textView.setX(seekBar.getX() + val + seekBar.getThumbOffset() / 2);
                    //textView.setY(100); just added a value set this properly using screen with height aspect ratio , if you do not set it by default it will be there below seek bar

                }* /
                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {
                        }
                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {
                        }
                    });
                }
            });
        }
        catch (Exception e)
        {
            addh2o.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View vProgress) {
                    amtH2ODrank=Integer.parseInt(amtH2Odrank.getText().toString());
                    seePerAmt.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
                    {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                            currentH2O+=(amtH2ODrank);
                            progress=((int)currentH2O);
                            progressPerAmt.setProgress(progress/h2oDaily_);
                            seePerAmt.setProgress(progress/h2oDaily_);
                            proText=Double.toString((((currentH2O/h2o_Daily_)*100)));
                            perAmt.setText(proText +" %");
                        }
                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {
                        }
                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {
                        }
                    });
                }
            });
        }*/
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trackerprogress);

        addh2o=(Button)findViewById(R.id.addh2o);
        amtH2Odrank=(EditText)findViewById(R.id.amtH2Odrank);
        perAmt=(TextView) findViewById(R.id.perAmt);
        //seePerAmt=(SeekBar) findViewById(R.id.seekPerAmt);
        progressPerAmt=(ProgressBar) findViewById(R.id.proPerAmt);
        h2oDaily_=((int)(round(h2oDaily)));
        //seePerAmt.setProgress((int)currentH2O);
        //seePerAmt.setMax(h2oDaily_);
        //seePerAmt.setProgress((int)currentH2O);
        try{
            addh2o.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View vProgress) {

                    amtH2ODrank=(Integer.parseInt(amtH2Odrank.getText().toString()));

                    h2o_Daily_=h2oDaily;
                    h2oDaily_ = ((int) (round(h2oDaily * 1000)));
                    progressPerAmt.setMax((int)h2oDaily_/10);
                    amtH2ODrank = (Integer.parseInt(amtH2Odrank.getText().toString()));
                    currentH2O += (amtH2ODrank);
                    progressPerAmt.setProgress((int)((currentH2O*1.76*39/h2o_Daily_)));
                    proText=Double.toString((((int) ((currentH2O/(h2o_Daily_))))));
                    perAmt.setText(proText + " %");
                    /*seePerAmt.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
                    {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                            currentH2O+=(amtH2ODrank+progress);
                            progress=((int)currentH2O);
                            progressPerAmt.setProgress(progress);
                            seePerAmt.setProgress(progress);
                            proText=Double.toString(((currentH2O/h2o_Daily_)*100));
                            perAmt.setText(proText +" %");
                        }
                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {
                        }
                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {
                        }
                    });*/
                }
            });
            }
        catch (Exception e)
        {
            addh2o.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View vProgress) {
                    amtH2ODrank=Integer.parseInt(amtH2Odrank.getText().toString());

                    h2o_Daily_=h2oDaily;
                    h2oDaily_ = ((int) (round(h2oDaily * 1000)));
                    progressPerAmt.setMax((int)h2oDaily_/10);
                    amtH2ODrank = (Integer.parseInt(amtH2Odrank.getText().toString()));
                    currentH2O += (amtH2ODrank);
                    progressPerAmt.setProgress((int)((currentH2O*1.76*39/h2o_Daily_)));
                    proText=Double.toString((((int) ((currentH2O/(h2o_Daily_))))));
                    perAmt.setText(proText + " %");
                    /*seePerAmt.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
                    {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                            currentH2O+=(amtH2ODrank+progress);
                            progress=((int)currentH2O);
                            progressPerAmt.setProgress(progress);
                            seePerAmt.setProgress(progress);
                            proText=Double.toString(((currentH2O/h2o_Daily_)*100));
                            perAmt.setText(proText +" %");
                        }
                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {
                        }
                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {
                        }
                    });*/
                }
            });
        }
 }
    /*
    public void navigate_h20_reminder(){}
    public void navigate_h20_tracker(){}
    */
}
