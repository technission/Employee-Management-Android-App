package com.learncodinganywhere.workit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (findViewById(R.id.loginButton));
        btn.setOnClickListener(v -> setContentView(R.layout.activity_landing_page));
    }

    public void showPopUp(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.schedule:
                Toast.makeText(this, "Item 1 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.messenger:
                Toast.makeText(this, "Item 2 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.pay:
                Toast.makeText(this, "Item 3 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.paymentInfo:
                Toast.makeText(this, "Item 4 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.employee_info:
                Toast.makeText(this, "Item 5 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.profile:
                Toast.makeText(this, "Item 6 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }

    public void EmployeeInfo(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.employee_info) {
            setContentView(R.layout.activity_emp_info);
        }
    }
}