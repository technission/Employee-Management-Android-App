package com.learncodinganywhere.workit;

import androidx.appcompat.app.AppCompatActivity; //this section defines elements of login page


import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
{ //interacts with activity.main.xml
    private EditText eUserName;
    private EditText ePassword;
    private Button eLogin;
    private CheckBox eRemember; //not attached yet


    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        eUserName = findViewById(R.id.Text_Username);//attaches all these variables to the xml file
        ePassword = findViewById(R.id.text_Password);//"e" refers to an editable screen
        eLogin = findViewById(R.id.button_Login);
        eRemember = findViewById(R.id.checkBox_Remember);
        //button not linked - button_createAccount

        String username = "ABCDE";//tests for UN
        String password = "12345";//tests for PW
        final boolean[] loginIsValid = {false}; //if login is NOT valid
    }
}

//add link to new page next here
//button not linked - button_createAccount


//NOTES
//checkBox_Remember
//Text_Username
//text_Password
//button_login