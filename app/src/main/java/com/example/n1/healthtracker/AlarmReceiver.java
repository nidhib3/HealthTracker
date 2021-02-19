package com.example.n1.healthtracker;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;

import static com.example.n1.healthtracker.R.id.contentPanel;
import static com.example.n1.healthtracker.R.id.set;
import static com.example.n1.healthtracker.Tracker.currentH2O;

public class AlarmReceiver extends BroadcastReceiver {
    String givenTask=Integer.toString(R.id.task);
    public static double currenth2O=0;
    @Override
    public void onReceive(Context context, Intent intent) {
        currenth2O=currentH2O;
        int notificationId=intent.getIntExtra("NOTIFICATION : ",0);
        String todo=intent.getStringExtra("TODO");

        Intent mainIntent=new Intent(context,Reminder.class);
        PendingIntent contentIntent=PendingIntent.getActivity(context,0,mainIntent,0);


        NotificationManager notifyMe=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder=new Notification.Builder(context);

        builder.setSmallIcon(android.R.drawable.ic_dialog_info).setContentTitle("Reminder : "+ givenTask).setContentText(todo).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentIntent(contentIntent).setContentIntent(contentIntent).setPriority(Notification.PRIORITY_MAX).setDefaults(Notification.DEFAULT_ALL);
        notifyMe.notify(notificationId,builder.build());
    }
}
