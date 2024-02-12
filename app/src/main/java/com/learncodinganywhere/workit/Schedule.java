package com.learncodinganywhere.workit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.learncodinganywhere.workit.databinding.ActivityScheduleBinding;

public class Schedule extends DrawerBaseActivity {

    ActivityScheduleBinding activityScheduleBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityScheduleBinding = ActivityScheduleBinding.inflate(getLayoutInflater());
        setContentView(activityScheduleBinding.getRoot());
    }
}