package com.example.aclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "My Channel";

    private static final int NOTIFICATION_ID = 100;
    Button alert;
    Button prank;
    Button warning;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.icon, null);

        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;

        Bitmap largeIcon = bitmapDrawable.getBitmap();

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
             notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.icon)
                    .setContentText("It is a notification")
                    .setSubText("New message from shibam")
                    .setChannelId(CHANNEL_ID)
                    .build();
            String name;
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID, name="New Channel", NotificationManager.IMPORTANCE_HIGH));
        } else {
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.icon)
                    .setContentText("It is a notification")
                    .setSubText("New message from shibam")
                    .build();
        }

        nm.notify(NOTIFICATION_ID, notification);


        alert = findViewById(R.id.alert);

        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Alert", Toast.LENGTH_SHORT).show();
            }
        });

        prank = findViewById(R.id.prank);

        prank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Notification", Toast.LENGTH_SHORT).show();
            }
        });

        warning = findViewById(R.id.warning);

        warning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "WARNING!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}