package com.taquangkhoi.notificationlesson;

import android.app.Application;

public class Notification extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannel();
    }

    private void createNotificationChannel() {
    }

}
