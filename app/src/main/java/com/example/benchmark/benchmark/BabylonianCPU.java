package com.example.benchmark.benchmark;

import com.example.benchmark.model.Test;
import com.example.benchmark.utills.DeviceInfo;

import java.util.Calendar;
import java.util.UUID;

public class BabylonianCPU extends Test {


    public BabylonianCPU() {
        this.setId(UUID.randomUUID().toString());
        this.setCategory("CPU");
        this.setTypeOfTest("Babylonian Method");
        this.setTypeOfPhone(DeviceInfo.getModel() + " " +DeviceInfo.getManufacturer());
        this.setDescription("This test approximates square roots using the Babylonian Method. "+
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

    private void runTest(){
        for(int j = 0; j < 5; ++j){
            double sqrtPi = 1.0;
            double sqrtE = 1.0;
            double temp  = 1;
            for (double i = 0.0; i < 10000000L; i++) {
                temp = sqrtPi + Math.PI / sqrtPi;
                sqrtPi = temp * 0.5;
                temp = sqrtE + Math.E / sqrtE;
                sqrtE = temp * 0.5;
            }
        }

        setScore((Calendar.getInstance().getTimeInMillis() - getScore()) / 5);


    }
}
