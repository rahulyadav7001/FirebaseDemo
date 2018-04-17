package com.ryandro.firebasedemo.service;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.LocalBroadcastManager;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.ryandro.firebasedemo.activities.FcmNotificationActivity;
import com.ryandro.firebasedemo.app.Config;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String TAG = MyFirebaseInstanceIDService.class.getSimpleName();

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshToken = FirebaseInstanceId.getInstance().getToken();
        storeTokenInPreferance(refreshToken);

        Intent intent = new Intent(Config.REGISTRATION_COMPLETE);
        intent.putExtra("token",refreshToken);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    private void storeTokenInPreferance(String token) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences(Config.SHARED_PREF, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("regId", token);
        editor.commit();
    }
}
