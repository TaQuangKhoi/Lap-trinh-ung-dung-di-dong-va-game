package com.taquangkhoi.notificationlesson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button btn_send_notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_send_notification = findViewById(R.id.btn_send_notification);
        btn_send_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotification();
            }
        });
    }

    private void sendNotification() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, getNotificationId(),
                intent, PendingIntent.FLAG_IMMUTABLE);

        Notification notificationBuilder
                = new NotificationCompat.Builder(this, NotificationApp.CHANNEL_ID)
                .setContentTitle("Thông báo")
                .setContentText("Đây là TB")
                .setSmallIcon(R.drawable.ic_notifications_24)
                .addAction(R.drawable.ic_notifications_24, "Xem", pendingIntent)
                .build();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(getNotificationId(), notificationBuilder);
    }

    // Tạo Notification không trùng nhau bằng giá trị ngày - Date của java.util
    private int getNotificationId(){
        return (int) new Date().getTime();
    }
}