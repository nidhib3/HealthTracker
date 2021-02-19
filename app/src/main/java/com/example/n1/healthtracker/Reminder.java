package com.example.n1.healthtracker;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;
import android.os.SystemClock;
import java.sql.Time;

import static com.example.n1.healthtracker.Tracker.currentH2O;

public class Reminder extends AppCompatActivity implements View.OnClickListener
{
    private int notificationId=1;
    Button set,cancel,addh20;
    EditText task;
    TimePicker Stime;
    Intent intent,ih2oTracker;
    public static double currenth2O=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reminder);
        task=(EditText) findViewById(R.id.task);
        set=(Button) findViewById(R.id.set);
        cancel=(Button) findViewById(R.id.cancel);
        Stime=(TimePicker) findViewById(R.id.Stime);
        addh20=(Button) findViewById(R.id.addh20);
        currenth2O=currentH2O;
        findViewById(R.id.set).setOnClickListener(this);
        findViewById(R.id.cancel).setOnClickListener(this);
    }
    @Override
    public void onClick(View viewing)
    {
         task=(EditText) findViewById(R.id.task);
         set=(Button) findViewById(R.id.set);
        cancel=(Button) findViewById(R.id.cancel);
         Stime=(TimePicker) findViewById(R.id.Stime);
        addh20=(Button) findViewById(R.id.addh20);

        currenth2O=currentH2O;
        intent=new Intent(Reminder.this,AlarmReceiver.class);
        intent.putExtra("NOTIFICATION : ",notificationId);
        intent.putExtra("TODO : ",task.getText().toString());

        PendingIntent alarmIntent=PendingIntent.getBroadcast(Reminder.this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarm=(AlarmManager) getSystemService(ALARM_SERVICE);
        switch(viewing.getId())
        {
            case (R.id.set):
                int hour=Stime.getCurrentHour();
                int min=Stime.getCurrentMinute();

                Calendar startTime=Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY,hour);
                startTime.set(Calendar.MINUTE,min);
                startTime.set(Calendar.SECOND,0);
                long alarmStartTime=startTime.getTimeInMillis();

                alarm.set(AlarmManager.RTC_WAKEUP,alarmStartTime,alarmIntent);
                Toast.makeText(Reminder.this,task.getText().toString()+" REMINDER SET!!",Toast.LENGTH_LONG).show();
                break;
            case (R.id.cancel):
                alarm.cancel(alarmIntent);
                Toast.makeText(Reminder.this,"Reminder Cancel",Toast.LENGTH_LONG).show();
                break;
        }
        addh20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vReminderH2O) {
                ih2oTracker=new Intent(Reminder.this,Tracker.class);
                startActivity(ih2oTracker);
            }
        });
        }
}
