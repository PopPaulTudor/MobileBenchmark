package com.example.benchmark.benchmark;

import android.os.Environment;
import android.util.Log;

import com.example.benchmark.model.Test;
import com.example.benchmark.utills.DeviceInfo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class FilesWriteStorage extends Test {

    private static final int BUFFER_SIZE = 1024 * 4;
    private static final int FILE_SIZE = 1024 * 1024 * 5;
    private static String FILE_NAME = "benchmark.dat";
    private File file;


    public FilesWriteStorage() {

        file = new File(Environment.getExternalStorageDirectory(), "output.txt");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file );
            fos.write(FILE_SIZE);


        } catch (Exception e) {
            e.printStackTrace();
        }


        setScore(Calendar.getInstance().getTimeInMillis());
        this.setCategory("Files Access");
        this.setTypeOfTest("Storage Write");
        this.setTypeOfPhone(DeviceInfo.getModel() + " " + DeviceInfo.getManufacturer());
        this.setDescription("This test measures the speed of  writing of the internal storage.");
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
        computeScore();
        setScore((Calendar.getInstance().getTimeInMillis() - getScore()) / 16);


    }

    public void computeScore() {

        BufferedOutputStream outputStream = null;
        BufferedInputStream inputStream;
        Random rand = new Random();
        this.setScore(Calendar.getInstance().getTimeInMillis());

        byte[] buffer = new byte[BUFFER_SIZE];

        for (int i = 0; i < 16; i++) {
            try {
                outputStream = new BufferedOutputStream(new FileOutputStream(file));
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
            for (int j = 0; j < FILE_SIZE; j += BUFFER_SIZE) {
                rand.nextBytes(buffer);

                try {
                    outputStream.write(buffer);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            try {
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //stop timer
        }


    }
}
