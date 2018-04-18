package com.ryandro.firebasedemo.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ryandro.firebasedemo.R;

public class DashBoardActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_Analytics,btn_Notification,btn_Cashlytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        btn_Analytics = (Button) findViewById(R.id.btn_Analytics);
        btn_Notification = (Button) findViewById(R.id.btn_Notification);
        btn_Cashlytics = (Button) findViewById(R.id.btn_Cashlytics);

        btn_Analytics.setOnClickListener(this);
        btn_Notification.setOnClickListener(this);
        btn_Cashlytics.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_Analytics:
                startActivity(new Intent(DashBoardActivity.this,FirebaseAnlyticsActivity.class));
                break;
            case R.id.btn_Notification:
                startActivity(new Intent(DashBoardActivity.this,FcmNotificationActivity.class));
                break;
            case R.id.btn_Cashlytics:
                startActivity(new Intent(DashBoardActivity.this,FirebaseCrashlyticsActivity.class));
                break;
            default:
                break;
        }

    }
}
