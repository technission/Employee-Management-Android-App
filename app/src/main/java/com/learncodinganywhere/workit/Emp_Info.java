package com.learncodinganywhere.workit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Emp_Info extends AppCompatActivity { //interacts with activity_emp_info_xml

    private EditText eFirstName;
    private EditText eLastName;
    private EditText eAddress_1;
    private EditText eAddress_2;
    private EditText eState;
    private EditText eZip;
    private EditText eEmail;
    private EditText ePhone;
    private EditText eContactFirst;
    private EditText eContactLast;
    private EditText eContactPhone;
    private EditText eContactRelation;
    private Button bSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_info);

        eFirstName = findViewById(R.id.etFirstName);//attaches all these variables to the xml file
        eLastName = findViewById(R.id.etLastName);//"e" refers to an editable screen
        eAddress_1 = findViewById(R.id.etAddress_1);
        eAddress_2 = findViewById(R.id.etAddress_2);
        eState = findViewById(R.id.etState);
        eZip = findViewById(R.id.etZip);
        eEmail =findViewById(R.id.etEmail);
        ePhone = findViewById(R.id.etPhone);
        eContactFirst =findViewById(R.id.etContactFirst);
        eContactLast= findViewById(R.id.etContactLast);
        eContactPhone = findViewById(R.id.etContactPhone);
        eContactRelation = findViewById(R.id.etContactRelation);
        bSave =  findViewById(R.id.btnSave);  //need onClick etc
    }
}