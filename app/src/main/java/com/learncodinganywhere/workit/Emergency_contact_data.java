package com.learncodinganywhere.workit;

public class Emergency_contact_data {
    private String emp_id;
    private String eCfName;
    private String eClName;
    private String ecPhone;

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
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

    private String ecRelationship;
}
