package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Buyer {

    public String BuyerName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int BuyerId;
    public String BuyerEmail;
    public int BuyerMobile;
    public String BuyerGender;



    public String getBuyerName() {
        return BuyerName;
    }

    public void setBuyerName(String buyerName) {
        BuyerName = buyerName;
    }

    public int getBuyerId() {
        return BuyerId;
    }

    public void setBuyerId(int buyerId) {
        BuyerId = buyerId;
    }

    public String getBuyerEmail() {
        return BuyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        BuyerEmail = buyerEmail;
    }

    public int getBuyerMobile() {
        return BuyerMobile;
    }

    public void setBuyerMobile(int buyerMobile) {
        BuyerMobile = buyerMobile;
    }

    public String getBuyerGender() {
        return BuyerGender;
    }

    public void setBuyerGender(String buyerGender) {
        BuyerGender = buyerGender;
    }
}
