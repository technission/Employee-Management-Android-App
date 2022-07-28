package com.learncodinganywhere.workit;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.volley.AuthFailureError;
import com.google.android.volley.Request;
import com.google.android.volley.Response;
import com.google.android.volley.VolleyError;
import com.google.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class EmployeeInfo extends Fragment {

    Button button;
    TextInputEditText Fname, Lname, Address1, Address2, State, Zip, Email, Phone, Efname, Elname, Ephone, Erelationship;
    String server_url = "http://192.168.1.94/app/dbconfig.php";
    AlertDialog.Builder builder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_employee, container, false);

        button = (Button) findViewById(R.id.button);
        Fname = (TextInputEditText) findViewById(R.id.first_field);
        Lname = (TextInputEditText) findViewByID(R.id.last_field);
        Address1 = (TextInputEditText) findViewById(R.id.address_field1);
        Address2 = (TextInputEditText) findViewByID(R.id.address_field2);
        State = (TextInputEditText) findViewById(R.id.state_field);
        Zip = (TextInputEditText) findViewByID(R.id.zip_field);
        Email = (TextInputEditText) findViewById(R.id.email_field);
        Phone = (TextInputEditText) findViewByID(R.id.phone_field);
        Efname = (TextInputEditText) findViewById(R.id.efirst_field);
        Elname = (TextInputEditText) findViewByID(R.id.elast_field);
        Ephone = (TextInputEditText) findViewById(R.id.ephone_field);
        Erelationship = (TextInputEditText) findViewByID(R.id.erelationship_field);

        builder = new AlertDialog.Builder(EmployeeInfo.this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String fname, lname, address1, address2, state, zip, email, phone, efname, elname, ephone, erelationship;

                fname = Fname.getText().toString();
                lname = Lname.getText().toString();
                address1 = Address1.getText().toString();
                address2 = Address2.getText().toString();
                state = State.getText().toString();
                zip = Zip.getText().toInt();
                email = Email.getText().toString();
                phone = Phone.getText().toInt();
                efname = Efname.getText().toString();
                elname = Elname.getText().toString();
                ephone = Ephone.getText().toInt();
                erelationship = Erelationship.getText().toString();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        builder.setTitle("Server Response");
                        builder.setMessage("Response: " + response);
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Fname.setText("");
                                Lname.setText("");
                                Address1.setText("");
                                Address2.setText("");
                                State.setText("");
                                Zip.setText("");
                                Email.setText("");
                                Phone.setText("");
                                Efname.setText("");
                                Elname.setText("");
                                Ephone.setText("");
                                Erelationship.setText("");
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }
                }
                , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(EmployeeInfo.this,"some error found...", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> Params = new HashMap<String, String>();

                        Params.put("fname", fname);
                        Params.put("lname", lname);
                        Params.put("address1", address1);
                        Params.put("address2", address2);
                        Params.put("state", state);
                        Params.put("zip", zip);
                        Params.put("email", email);
                        Params.put("phone", phone);
                        Params.put("efname", efname);
                        Params.put("elname", elname);
                        Params.put("ephone", ephone);
                        Params.put("erelationship", erelationship);

                        return Params;
                    }
                };
                MySingleton.getInstance(EmployeeInfo.this).addTorequestque(stringRequest);
            }
        });
    }
}
