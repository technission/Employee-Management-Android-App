package com.learncodinganywhere.workit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (findViewById(R.id.loginButton));
        btn.setOnClickListener(v -> setContentView(R.layout.activity_landing_page));
    }

    public void showPopUp(View v) {
        setContentView(R.layout.menu_item_popout);
    }

    public void closePopUp(View v) {
        setContentView(R.layout.activity_landing_page);
    }

    public void EmployeeInfo(View v) {
        setContentView(R.layout.activity_emp_info);
    }
}