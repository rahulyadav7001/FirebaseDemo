package com.ryandro.firebasedemo.app;

public class Config {

    // id to handle the notification in the notification tray
    public static final int NOTIFICATION_ID = 100;
    public static final int NOTIFICATION_ID_BIG_IMAGE = 101;
    // broadcast receiver intent filters
    public static final String REGISTRATION_COMPLETE = "REGISTRATION_COMPLETE";
    public static final String PUSH_NOTIFICAATION = "PUSH_NOTIFICAATION";
    // global topic to receive app wide push notifications
    public static final String TOPIC_GLOBAL = "TOPIC_GLOBAL";

    public static final String SHARED_PREF = "SHARED_PREF";
}
