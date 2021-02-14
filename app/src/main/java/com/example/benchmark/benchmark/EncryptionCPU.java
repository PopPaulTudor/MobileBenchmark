package com.example.benchmark.benchmark;

import android.os.Message;
import android.util.Base64;
import android.util.Log;

import com.example.benchmark.model.Test;
import com.example.benchmark.utills.DeviceInfo;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

public class EncryptionCPU extends Test {


    public EncryptionCPU() {
        setScore(Calendar.getInstance().getTimeInMillis());
        this.setCategory("CPU");
        this.setTypeOfTest("SHA-1 Encryption");
        this.setTypeOfPhone(DeviceInfo.getModel() + " " + DeviceInfo.getManufacturer());
        this.setDescription("This test encrypt the message Benchmark for android using the SHA-1 Encryption. " +
                "The test is performed 20.000 times and the resulted time is saved in the result " +
                "and calculated with a formula");
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

    private void runTest() {
        computeSHAHash();
        setScore((Calendar.getInstance().getTimeInMillis() - getScore()));


    }

    public void computeSHAHash() {

        for (int i = 0; i < 20000; i++) {
            MessageDigest mdSha1 = null;
            try {
                try {
                    mdSha1 = MessageDigest.getInstance("SHA-1");
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                mdSha1.update("Benchmark for android".getBytes("ASCII"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            byte[] data = mdSha1.digest();
            StringBuilder sb = new StringBuilder();
            String hex = Base64.encodeToString(data, 0, data.length, 0);

            sb.append(hex);
        }


    }
}
