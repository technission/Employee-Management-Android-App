package com.learncodinganywhere.workit;

import static java.lang.String.valueOf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    Button Button;
    TextInputEditText Fname, Lname, Address1, Address2, State, Zip, Email, Phone, Efname, Elname, Ephone, Erelationship;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button = findViewById(R.id.button);
        Fname = findViewById(R.id.first_field);
        Lname = findViewById(R.id.last_field);
        Address1 = findViewById(R.id.address_field1);
        Address2 = findViewById(R.id.address_field2);
        State = findViewById(R.id.state_field);
        Zip = findViewById(R.id.zip_field);
        Email = findViewById(R.id.email_field);
        Phone = findViewById(R.id.phone_field);
        Efname = findViewById(R.id.efirst_field);
        Elname = findViewById(R.id.elast_field);
        Ephone = findViewById(R.id.ephone_field);
        Erelationship = findViewById(R.id.erelationship_field);
    }

    public void onClick(View view) {
        String type = "save";
        String fname = String.valueOf(Fname);
        String lname = String.valueOf(Lname);
        String address1 = String.valueOf(Address1);
        String address2 = String.valueOf(Address2);
        String state = String.valueOf(State);
        String zip = String.valueOf(Zip);
        String email = String.valueOf(Email);
        String phone = String.valueOf(Phone);
        String efname = String.valueOf(Efname);
        String elname = String.valueOf(Elname);
        String ephone = String.valueOf(Ephone);
        String erelationship = valueOf(Erelationship);

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, fname, lname, address1, address2, state, zip, email, phone, efname, elname, ephone, erelationship);
    }


    public void baseLayout(View loginButton) {
        setContentView(R.layout.activity_base);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_shiftCalender:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShiftCalender()).commit();
                break;
            case R.id.nav_schedule:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Schedule()).commit();
                break;
            case R.id.nav_messenger:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Messenger()).commit();
                break;
            case R.id.nav_hoursPay:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HoursPay()).commit();
                break;
            case R.id.nav_paymentInfo:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PaymentInfo()).commit();
                break;
            case R.id.nav_employeeInfo:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EmployeeInfo()).commit();
                break;
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Profile()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}