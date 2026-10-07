package com.college.erp.model;

public class Faculty {

    private int id;
    private String name;
    private String email;
    private String department;
    private String designation;
    private String phone;
    private String address;

    public Faculty() {
    }

    public Faculty(int id,
                   String name,
                   String email,
                   String department,
                   String designation,
                   String phone,
                   String address) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.designation = designation;
        this.phone = phone;
        this.address = address;
    }

    public Faculty(String name,
                   String email,
                   String department,
                   String designation,
                   String phone,
                   String address) {

        this.name = name;
        this.email = email;
        this.department = department;
        this.designation = designation;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}