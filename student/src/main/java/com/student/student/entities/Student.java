package com.student.student.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")

public class Student {

    @Id
       @Column(name="student_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String rollNo;
    private String email;
    private String address;
    private String mobileNo;

    

    public Student() {
    }
    
    public Student(int id, String name, String rollNo, String email, String address, String mobileNo) {
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.email = email;
        this.address = address;
        this.mobileNo = mobileNo;
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
    public String getRollNo() {
        return rollNo;
    }
    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getMobileNo() {
        return mobileNo;
    }
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", rollNo=" + rollNo + ", email=" + email + ", address="
                + address + ", mobileNo=" + mobileNo + "]";
    }


    
    
}
