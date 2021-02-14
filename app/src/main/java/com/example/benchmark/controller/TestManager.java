package com.example.benchmark.controller;

import android.app.Activity;
import android.content.ContentValues;

import com.example.benchmark.database.DbHelper;
import com.example.benchmark.database.TestDAO;
import com.example.benchmark.model.Test;

import java.util.List;

public class TestManager {

    private static TestManager instance;

    private TestDAO testsDAO;
    private List<Test> tests;


    private TestManager(Activity activity){
       DbHelper dbHelper = DbHelper.getInstance(activity);
       this.testsDAO = new TestDAO(dbHelper, activity);

    }

    public static TestManager getInstance(Activity activity){
        if(instance == null){
            instance = new TestManager(activity);
        }
        return instance;
    }

    public void initList(){
        tests = testsDAO.getTests();
    }

    public List<Test> getTests() {
        return tests;
    }


    public void addTest(Test test) {
        testsDAO.addTest(test);
        tests.add(test);
    }


}
