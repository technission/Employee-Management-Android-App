package com.learncodinganywhere.workit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.learncodinganywhere.workit.databinding.ActivityEmplInfoBinding;

public class Empl_info extends DrawerBaseActivity {
    ActivityEmplInfoBinding activityEmplInfoBinding;
    private EditText fName, lName, addressA, addressB, state, zip, email, phone, ECfname, EClname, ECphone, ECrelationship;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    DatabaseReference reff;
    DatabaseReference reff2;
    Employee_Stored_Data employee_Stored_Data;
    Emergency_contact_data emergencyContactData;
    long max = 0;
    long max2 = 0;
    long Emp_id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityEmplInfoBinding = ActivityEmplInfoBinding.inflate(getLayoutInflater());
        setContentView(activityEmplInfoBinding.getRoot());


        //store data from the edit texts into variables
        fName = findViewById(R.id.input_fName);
        lName = findViewById(R.id.input_lName);
        addressA = findViewById(R.id.input_addressA);
        addressB = findViewById(R.id.input_addressB);
        state = findViewById(R.id.input_state);
        zip = findViewById(R.id.input_zip);
        email = findViewById(R.id.input_email);
        phone = findViewById(R.id.input_phone);
        ECfname = findViewById(R.id.input_efName);
        EClname = findViewById(R.id.input_elName);
        ECphone = findViewById(R.id.input_ePhone);
        ECrelationship = findViewById(R.id.input_eRelationship);
        employee_Stored_Data = new Employee_Stored_Data();
        emergencyContactData = new Emergency_contact_data();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff= FirebaseDatabase.getInstance().getReference().child("employees");
        reff2 = FirebaseDatabase.getInstance().getReference().child("emergency_contacts");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    max=(snapshot.getChildrenCount());
                    Emp_id += snapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        reff2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    max2=(snapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Button btn = findViewById(R.id.btn_save);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FirstName = fName.getText().toString();
                String LastName = lName.getText().toString();
                String Address = addressA.getText().toString() + " " + addressB.getText().toString();
                String State = state.getText().toString();
                String Zip = zip.getText().toString();
                String Email = email.getText().toString();
                String Phone = phone.getText().toString();
                String ECfName = ECfname.getText().toString();
                String EClName = EClname.getText().toString();
                String ECPhone = ECphone.getText().toString();
                String ECRelationship = ECrelationship.getText().toString();
                String Role = "Associate";

                if (TextUtils.isEmpty(FirstName)
                        || TextUtils.isEmpty(LastName)
                        || TextUtils.isEmpty(Address)
                        || TextUtils.isEmpty(State)
                        || TextUtils.isEmpty(Zip)
                        || TextUtils.isEmpty(Email)
                        || TextUtils.isEmpty(Phone)
                        || TextUtils.isEmpty(ECfName)
                        || TextUtils.isEmpty(EClName)
                        ||TextUtils.isEmpty(ECPhone)
                        ||TextUtils.isEmpty(ECRelationship)
                ) {
                    Toast.makeText(Empl_info.this, "ALL fields are required", Toast.LENGTH_SHORT).show();
                } else {

                    //storing all data for each edit text when save button is clicked
                    employee_Stored_Data.setEmp_id(String.valueOf((max+1)));
                    employee_Stored_Data.setFirstName(fName.getText().toString());
                    employee_Stored_Data.setLastName(lName.getText().toString());
                    employee_Stored_Data.setAddress(addressA.getText().toString() + " " + addressB.getText().toString());
                    employee_Stored_Data.setState(state.getText().toString());
                    employee_Stored_Data.setZip(zip.getText().toString());
                    employee_Stored_Data.setEmail(email.getText().toString());
                    employee_Stored_Data.setPhone(phone.getText().toString());
                    emergencyContactData.setEmp_id(String.valueOf((max+1)));
                    emergencyContactData.seteCfName(ECfname.getText().toString());
                    reff2.child(String.valueOf(max2+1)).setValue(employee_Stored_Data);
                    employee_Stored_Data.setRole("Associate");
                    reff.child(String.valueOf(max+1)).setValue(employee_Stored_Data);

                    //sending a message that the info was submitted
                    Toast.makeText(Empl_info.this, "User Registered and email sent", Toast.LENGTH_SHORT).show();

                    //Erasing all edit texts after save button is clicked
                    fName.getText().clear();
                    lName.getText().clear();
                    addressA.getText().clear();
                    addressB.getText().clear();
                    state.getText().clear();
                    zip.getText().clear();
                    email.getText().clear();
                    phone.getText().clear();
                    ECfname.getText().clear();
                    EClname.getText().clear();
                    ECphone.getText().clear();
                    ECrelationship.getText().clear();
                }

            }


        });
    }
}