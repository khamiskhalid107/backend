package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int ContID;
    public String contName;
    public int ContCode;

    public String ContType;
    public String ContDate;


    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    public int getContCode() {
        return ContCode;
    }

    public void setContCode(int contCode) {
        ContCode = contCode;
    }

    public int getContID() {
        return ContID;
    }

    public void setContID(int contID) {
        ContID = contID;
    }

    public String getContType() {
        return ContType;
    }

    public void setContType(String contType) {
        ContType = contType;
    }

    public String getContDate() {
        return ContDate;
    }

    public void setContDate(String contDate) {
        ContDate = contDate;
    }
}
