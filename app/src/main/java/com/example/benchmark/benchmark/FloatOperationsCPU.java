package com.example.benchmark.benchmark;

import com.example.benchmark.model.Test;
import com.example.benchmark.utills.DeviceInfo;

import java.security.MessageDigest;
import java.util.Calendar;
import java.util.UUID;


public class FloatOperationsCPU extends Test {


    public FloatOperationsCPU() {
        this.setId(UUID.randomUUID().toString());
        this.setCategory("CPU");
        this.setTypeOfTest("Integer Calculations");
        this.setTypeOfPhone(DeviceInfo.getModel() + " " +DeviceInfo.getManufacturer());
        this.setDescription("This test performs each basic operation for 10.000.000 times. " +
                "The test is performed 5 times and the resulted time is saved in the result and calculated with a formula");
        this.setDate(Calendar.getInstance().getTimeInMillis());
        this.setScore(Calendar.getInstance().getTimeInMillis());
        runTest();
    }


    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public String getTypeOfTest() {
        return super.getTypeOfTest();
    }

    @Override
    public void setTypeOfTest(String typeOfTest) {
        super.setTypeOfTest(typeOfTest);
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(description);
    }

    @Override
    public String getTypeOfPhone() {
        return super.getTypeOfPhone();
    }

    @Override
    public void setTypeOfPhone(String typeOfPhone) {
        super.setTypeOfPhone(typeOfPhone);
    }

    @Override
    public long getDate() {
        return super.getDate();
    }

    @Override
    public void setDate(long date) {
        super.setDate(date);
    }

    @Override
    public double getScore() {
        return super.getScore();
    }

    @Override
    public void setScore(double score) {
        super.setScore(score);
    }

    @Override
    public String getCategory() {
        return super.getCategory();
    }

    @Override
    public void setCategory(String category) {
        super.setCategory(category);
    }

    private void runTest() {
        for (int nr = 0; nr < 5; ++nr) {
            long n  = 1L;
            for (long i = 1L; i < 10000000L; ++i) {
                n /= (double) i / 1000;
                n += i / 100;
                n -= i / 100;
                n *= (double) i /10000;
            }

        }
        setScore((Calendar.getInstance().getTimeInMillis() - getScore()) / 5);
    }


}
