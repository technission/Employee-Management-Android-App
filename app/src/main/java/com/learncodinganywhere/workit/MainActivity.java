package com.learncodinganywhere.workit;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;


    ImageView imageView;
    ImageView imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn = (Button)findViewById(R.id.btnLogin);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.landing_page);

                drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
                navigationView = (NavigationView) findViewById(R.id.nav_view);
                ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
                drawerLayout.setDrawerListener(toggle);
                toggle.syncState();

                imageView = findViewById(R.id.imageView3);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        drawerLayout.openDrawer(GravityCompat.START);
                        imageView2 = findViewById(R.id.closeButton);
                        imageView2.setOnClickListener(new View.OnClickListener(){

                            @Override
                            public void onClick(View v) {
                                drawerLayout.closeDrawer(GravityCompat.START);

                            }
                        });

                    }
                });


            }
        });


    }
}