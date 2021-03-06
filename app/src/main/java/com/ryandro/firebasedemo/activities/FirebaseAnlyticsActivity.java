package com.ryandro.firebasedemo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.ryandro.firebasedemo.Food;
import com.ryandro.firebasedemo.R;

import java.util.Random;

public class FirebaseAnlyticsActivity extends AppCompatActivity {

    private FirebaseAnalytics firebaseAnalytics;
    private String[] foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foods = new String[]{"Apple", "Banana", "Grape", "Mango", "Orange"};

        firebaseAnalytics = FirebaseAnalytics.getInstance(FirebaseAnlyticsActivity.this);
        Food food = new Food();
        food.setId(12001);
        food.setName(foods[randomIndex()]);
        Bundle bundle = new Bundle();
        bundle.putInt(FirebaseAnalytics.Param.ITEM_ID, food.getId());
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, food.getName());

        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT,bundle);
        firebaseAnalytics.setAnalyticsCollectionEnabled(true);
        firebaseAnalytics.setMinimumSessionDuration(10000);
        firebaseAnalytics.setSessionTimeoutDuration(500);
        firebaseAnalytics.setUserId(String.valueOf(food.getId()));
        firebaseAnalytics.setUserProperty("Food",food.getName());

    }
    private int randomIndex() {
        int min = 0;
        int max = foods.length - 1;
        Random rand = new Random();
        return min + rand.nextInt((max - min) + 1);
    }
}
