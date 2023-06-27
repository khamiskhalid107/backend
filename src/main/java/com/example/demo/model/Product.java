package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int ProId;
    public String ProType;
    public int ProPrice;
    public String ProName;

//    @ManyToOne
//    @JoinColumn(name = "FarmerId")
//    private Farmer farmer;

    public int getProId() {
        return ProId;
    }

    public void setProId(int proId) {
        ProId = proId;
    }

    public String getProType() {
        return ProType;
    }

    public void setProType(String proType) {
        ProType = proType;
    }

    public int getProPrice() {
        return ProPrice;
    }

    public void setProPrice(int proPrice) {
        ProPrice = proPrice;
    }

    public String getProName() {
        return ProName;
    }

    public void setProName(String proName) {
        ProName = proName;
    }

    public void ProName(Object o) {
    }
}
