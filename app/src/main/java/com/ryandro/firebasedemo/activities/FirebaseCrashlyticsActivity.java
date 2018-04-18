package com.ryandro.firebasedemo.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;
import com.ryandro.firebasedemo.R;

import io.fabric.sdk.android.Fabric;

public class FirebaseCrashlyticsActivity extends AppCompatActivity {

    private TextView tv_crashText;
    private Button btn_crash;
    private boolean isTrue = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this,new Crashlytics());
        setContentView(R.layout.activity_firebase_crashlytics);
        btn_crash = (Button) findViewById(R.id.btn_crash);
        tv_crashText = (TextView) findViewById(R.id.tv_crashText);




        /*************this part is used for Crashlytics of firebase */


        btn_crash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Crashlytics.getInstance().crash();

                Fabric fabric =   new Fabric.Builder(getApplicationContext()).kits(new Crashlytics()).debuggable(true).build();
                Fabric.with(fabric);
                Exception exception = new Exception("Oops!!, Exception Arise (Firebase Test)");
                Crashlytics.logException(exception);
                Crashlytics.log("Log String Test");
                Crashlytics.setInt("Integer_tag",5);
                tv_crashText.setText("Oops...!! \n Exception Arise (Firebase Test)");
                tv_crashText.setTextColor(Color.RED);

                Crashlytics.setInt("Integer_TAG",10);
                Crashlytics.setString("String_TAG",exception.getMessage());
                Crashlytics.setFloat("Float_Tag",10f);
                Crashlytics.setUserEmail("123@gmail.com");
                Crashlytics.setUserName("John");
                Crashlytics.setUserIdentifier("John123");


                try {
                    int sumValue, i = 10;
                    sumValue = i / 0;
                } catch (Exception e) {
                    e.printStackTrace();
                    Crashlytics.logException(exception);
                    tv_crashText.setText(e.getMessage());
                    Crashlytics.log(e.toString());
                    Log.d(FirebaseCrashlyticsActivity.this.getClass().getSimpleName(),e.toString());
                    Crashlytics.setInt("Integer_TAG",10);
                    Crashlytics.setString("String_TAG",e.getMessage());
                    Crashlytics.setFloat("Float_Tag",10f);
                    Crashlytics.setUserEmail("123@gmail.com");
                    Crashlytics.setUserName("John");
                    Crashlytics.setUserIdentifier("John123");
                    Crashlytics.log(FirebaseCrashlyticsActivity.this.getClass().getSimpleName());
                }
            }
        });


        /*************this part is used for Crash report of firebase which is previously used and now its going to deprercate*/

       /* btn_crash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTrue) {
                    Exception exception = new Exception("Oops!!, Exception Arise (Firebase Test)");
                    FirebaseCrash.report(exception);
                    exception.printStackTrace();
                    tv_crashText.setText("Oops...!! \n Exception Arise (Firebase Test)");
                    FirebaseCrash.log(FirebaseCrashlyticsActivity.this.getClass().getSimpleName());
                    isTrue = false;
                } else {
                    try {
                        int sumValue, i = 10;
                        sumValue = i / 0;
                    } catch (Exception e) {
                        e.printStackTrace();
                        FirebaseCrash.report(e);
                        tv_crashText.setText(e.getMessage());
                        FirebaseCrash.log(FirebaseCrashlyticsActivity.this.getClass().getSimpleName());
                    }
                    isTrue = true;

                }
                tv_crashText.setTextColor(Color.RED);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        tv_crashText.setText("Thanks!! \n Exception sent to Firebase");
                        tv_crashText.setTextColor(Color.BLUE);
                    }
                }, 2000);
            }
        });*/


    }
}
