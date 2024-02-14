package com.learncodinganywhere.workit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.learncodinganywhere.workit.databinding.ActivityEmplInfoBinding;

public class Empl_info extends DrawerBaseActivity {
    ActivityEmplInfoBinding activityEmplInfoBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityEmplInfoBinding = ActivityEmplInfoBinding.inflate(getLayoutInflater());
        setContentView(activityEmplInfoBinding.getRoot());

        Button btn = findViewById(R.id.btn_save);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Empl_info.this, "User Registered and email sent", Toast.LENGTH_SHORT).show();
            }
        });
    }
}