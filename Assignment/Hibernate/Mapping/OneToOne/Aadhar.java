package com.lpu.TestMaven.Mapping_one_to_one;

import javax.persistence.*;

@Entity
public class Aadhar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;

    private String aadharNumber;

    // Getters & Setters
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }
}
