package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity// first
@Data //forth to generate getter and setter
public class Farmer {
    @Id //second
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //third
    public int FarmerId;
    public   String Fname;
    public   String Address;
    public   String Fgender;
    public   String Email;


    public int getFarmerId() {
        return FarmerId;
    }

    public void setFarmerId(int farmerId) {
        FarmerId = farmerId;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getFgender() {
        return Fgender;
    }

    public void setFgender(String fgender) {
        Fgender = fgender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
