package com.example.benchmark.model;

import java.util.UUID;

public class Test {

    private String id;
    private String typeOfTest;
    private String description;
    private String typeOfPhone;
    private String category;
    private long date;
    private double score;

    public Test(String id, String category, String typeOfTest, String description, String typeOfPhone,
                long date, double score) {
        this.id = id;
        this.typeOfTest = typeOfTest;
        this.description = description;
        this.category = category;
        this.typeOfPhone = typeOfPhone;
        this.date = date;
        this.score = score;
    }

    public Test() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeOfTest() {
        return typeOfTest;
    }

    public void setTypeOfTest(String typeOfTest) {
        this.typeOfTest = typeOfTest;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeOfPhone() {
        return typeOfPhone;
    }

    public void setTypeOfPhone(String typeOfPhone) {
        this.typeOfPhone = typeOfPhone;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
