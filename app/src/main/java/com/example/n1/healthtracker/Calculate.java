package com.example.n1.healthtracker;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.n1.healthtracker.R.id.height;
import static com.example.n1.healthtracker.SignIn._age;
import static com.example.n1.healthtracker.SignIn._gender;
import static com.example.n1.healthtracker.SignIn.ht;
import static com.example.n1.healthtracker.SignIn.wt;
import static com.example.n1.healthtracker.Tracker.currentH2O;
/*
//1 kg = 2.2046 lb
// kg*2.2046*2.2*agefactor/28.3/4 glass
// 0-15=50
//15-30=40
//30-55=45
//55>=30
//1 liter = 33.814022702 fluid ounce*/

public class Calculate extends AppCompatActivity
    {
    Button Sedentary,ModeratelyActive,Active ,HighlyActive,h20reminder,h20tracker;
    TextView show_count,amtavt,mins;
    int Ht=0,Wt=0,Age=0,AF,Etime,extrah20=175;
    char Gender=' '; EditText amtAct; int ActiveTime=0;
    EditText name_,email_,password_,passwordc_,height_,weight_,age_,gender_;
    double h20_needed,h20_needed_; Button excTime;public static double h2oDaily;
    public static double h20_drank; Intent iH2OTracker,iH2OReminder;
        public static double currenth2O=0;
        ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate);
        img=(ImageView)findViewById(R.id.img);
        amtAct=(EditText)findViewById(R.id.amtAct);
        amtavt=(TextView)findViewById(R.id.amtact);
        mins=(TextView)findViewById(R.id.mins);
        show_count = (TextView) findViewById(R.id.showcount);
        excTime=(Button) findViewById(R.id.excTime);
        h20reminder=(Button)findViewById(R.id.h20Reminder);
        h20tracker=(Button)findViewById(R.id.h20Tracker);
        //height_=(EditText) findViewById(R.id.height) ;
        //Ht=Integer.parseInt(height_.getText().toString());
        currenth2O=currentH2O;
        Wt=wt;
        try {
            ActiveTime = Integer.parseInt(amtAct.getText().toString());
            Gender=_gender;
            Ht=ht;
            Wt=wt;
            Age=_age;
            if (Age <= 5 && Age >= 0) {
                AF = 45;
            } else if (Age <= 30 && Age >= 5) {
                AF = 40;
            } else if (Age <= 55 && Age >= 30) {
                AF = 35;
            } else if (Age > 55) {
                AF = 30;
            }
            h20_needed=(((Wt*2.2046*2/3)*0.029574));
            excTime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View vOfCount) {
                    ActiveTime = Integer.parseInt(amtAct.getText().toString());
                    if (ActiveTime >= 0 && ActiveTime <= 15) {
                        extrah20 = 175;
                        h20_needed_ =h20_needed+ extrah20;
                        h2oDaily=h20_needed_;
                        show_count.setText("FOR A SEDENTARY " + Gender + " OF " + Wt + " KGS " + Ht + " CM NEEDS " + h20_needed + " L WATER ");
                    } else if (ActiveTime >= 15 && ActiveTime <= 45) {
                        extrah20 = 18;
                        h20_needed_ =h20_needed+ extrah20;
                        h2oDaily=h20_needed_;
                        show_count.setText("FOR A MODERATELY ACTIVE " + Gender + " OF " + Wt + " KGS " + Ht + " CM NEEDS " + h20_needed + " L WATER ");
                    } else if (ActiveTime >= 45 && ActiveTime <= 75) {
                        extrah20 = 30;
                        h20_needed_ =h20_needed+ extrah20;
                        h2oDaily=h20_needed_;
                        show_count.setText("FOR AN ACTIVE " + Gender + " OF " + Wt + " KGS " + Ht + " CM NEEDS " + h20_needed + " L WATER ");
                    } else if (ActiveTime >= 75 && ActiveTime <= 90 || ActiveTime >= 90) {
                        extrah20 = 42;
                        h20_needed_ =h20_needed+ extrah20;
                        h2oDaily=h20_needed_/10;
                        show_count.setText("FOR A HIGHLY ACTIVE " + Gender + " OF " + Wt + " KGS " + Ht + " CM NEEDS " + h20_needed_/10+ " L WATER ");
                    }
                    //h2oDaily=h20_needed_;
                }
            });
            h20reminder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iH2OReminder=new Intent(Calculate.this,Reminder.class);
                    startActivity(iH2OReminder);
                }
            });
            h20tracker.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View vTrackh2o) {
                    iH2OTracker=new Intent(Calculate.this,Tracker.class);
                    startActivity(iH2OTracker);
                }
            });
        }
        catch (Exception e)
        {
            Gender=_gender;
            Ht=ht;
            Wt=wt;
            Age=_age;
            //ActiveTime =0;
            //h20_needed=8;
            h20_needed=(Math.round((((Wt*2.2046*2/3)*0.029574))*10))/10;
            excTime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View vOfCount) {
                    ActiveTime = Integer.parseInt(amtAct.getText().toString());
                    if (ActiveTime >= 0 && ActiveTime <= 15) {
                        extrah20 = 175;
                        h20_needed_ =h20_needed+ extrah20;
                        h2oDaily=h20_needed_;
                        show_count.setText("FOR A SEDENTARY " + Gender + " OF " + Wt + " KGS " + Ht + " CM NEEDS " + h20_needed + " L WATER ");
                    } else if (ActiveTime >= 15 && ActiveTime <= 45) {
                        extrah20 = 18;
                        h20_needed_ =h20_needed+ extrah20;
                        h2oDaily=h20_needed_;
                        show_count.setText("FOR A MODERATELY ACTIVE " + Gender + " OF " + Wt + " KGS " + Ht + " CM NEEDS " + h20_needed + " L WATER ");
                    } else if (ActiveTime >= 45 && ActiveTime <= 75) {
                        extrah20 = 30;
                        h20_needed_ =h20_needed+ extrah20;
                        h2oDaily=h20_needed_;
                        show_count.setText("FOR AN ACTIVE " + Gender + " OF " + Wt + " KGS " + Ht + " CM NEEDS " + h20_needed + " L WATER ");
                    } else if (ActiveTime >= 75 && ActiveTime <= 90 || ActiveTime >= 90) {
                        extrah20 = 42;
                        h20_needed_ =h20_needed+ extrah20;
                        h2oDaily=h20_needed_/10;
                        show_count.setText("FOR A HIGHLY ACTIVE " + Gender + " OF " + Wt + " KGS " + Ht + " CM NEEDS " + h20_needed_/10+ " L WATER ");
                    }
                }
            });
            //h2oDaily=h20_needed_;
            h20reminder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iH2OReminder=new Intent(Calculate.this,Reminder.class);
                    startActivity(iH2OReminder);
                }
            });
            h20tracker.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View vTrackh2o) {
                    iH2OTracker=new Intent(Calculate.this,Tracker.class);
                    startActivity(iH2OTracker);
                }
            });

        }
        /*
        Sedentary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vsed) {
                extrah20=175;
                //Set Text on button click via this function.
               show_count.setText("FOR A SEDENTARY "+Gender+" OF "+Wt+"KGS "+Ht+" CM NEEDS "+h20_needed+"WATER ");
            }
        });*//*
        ModeratelyActive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vmod) {
                extrah20=350;
                //Set Text on button click via this function.
                show_count.setText("FOR A MODERATELY ACTIVE "+Gender+" OF "+Wt+"KGS "+Ht+" CM NEEDS "+h20_needed+"WATER ");
            }
        });
        Active.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vact) {
                extrah20=175*3;
                //Set Text on button click via this function.
                show_count.setText("FOR AN ACTIVE "+Gender+" OF "+Wt+"KGS "+Ht+" CM NEEDS "+h20_needed+"WATER ");
            }
        });
         HighlyActive.setOnClickListener(new View.OnClickListener() {
             @Override
              public void onClick(View vhact) {
                     extrah20=175*4;
                        //Set Text on button click via this function.
                      show_count.setText("FOR A HIGHLY ACTIVE "+Gender+" OF "+Wt+"KGS "+Ht+" CM NEEDS "+h20_needed+"WATER ");
                    }
                });


                 <Button
        android:text="Sedentary (0-15 min)"
        android:layout_width="match_parent"
        android:layout_height="51dp"
        android:id="@+id/sact"
        android:layout_alignParentTop="true"
        android:layout_alignParentStart="true"
        android:onClick="onClick"/>

    <Button
        android:text="Moderately Active (15-45 min)"
        android:layout_width="match_parent"
        android:layout_height="51dp"
        android:id="@+id/mact"
        android:layout_below="@+id/sact"
        android:layout_alignParentStart="true"
        android:onClick="onClick"/>

    <Button
        android:text="Highly Active (75-90 min)"
        android:layout_width="match_parent"
        android:id="@+id/hact"
        android:layout_height="51dp"
        android:layout_below="@+id/act"
        android:layout_alignParentStart="true"
        android:onClick="onClick"/>

    <Button
        android:text="Active (45-75 min)"
        android:layout_width="match_parent"
        android:layout_height="51dp"
        android:id="@+id/act"
        android:layout_below="@+id/mact"
        android:layout_alignParentStart="true"
        android:onClick="onClick"/>
*/

    }
    /*

    public void navigate_h20_reminder(){}
    public void navigate_h20_tracker(){}
    */
}
