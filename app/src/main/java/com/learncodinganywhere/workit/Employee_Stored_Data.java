package com.learncodinganywhere.workit;

import android.widget.EditText;

public class Employee_Stored_Data {
    private String emp_id, firstName, lastName, address, state, zip, email, phone, role, eCfName, eClName, ecPhone, ecRelationship;

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String geteCfName() {
        return eCfName;
    }

    public void seteCfName(String eCfName) {
        this.eCfName = eCfName;
    }

    public String geteClName() {
        return eClName;
    }

    public void seteClName(String eClName) {
        this.eClName = eClName;
    }

    public String getEcPhone() {
        return ecPhone;
    }

    public void setEcPhone(String ecPhone) {
        this.ecPhone = ecPhone;
    }

    public String getEcRelationship() {
        return ecRelationship;
    }

    public void setEcRelationship(String ecRelationship) {
        this.ecRelationship = ecRelationship;
    }

    public Employee_Stored_Data() {

        //empty constructor
        //required for firebase
    }


}
