package com.example.benchmark.database;

import android.app.Activity;
import android.content.ContentValues;

import com.example.benchmark.model.Test;

import java.util.ArrayList;
import java.util.List;

public class TestDAO {

    private DbHelper help;
    private Activity activity;

    public TestDAO(DbHelper help,Activity activity) {
        this.help = help;
        this.activity= activity;
    }

    private static ContentValues getContentValues(Test test) {

        ContentValues values = new ContentValues();

        values.put(DbSchema.BenchmarkTable.Cols.UUID, test.getId());
        values.put(DbSchema.BenchmarkTable.Cols.CATEGORY, test.getCategory());
        values.put(DbSchema.BenchmarkTable.Cols.TYPE_TEST, test.getTypeOfTest());
        values.put(DbSchema.BenchmarkTable.Cols.DESCRIPTION, test.getDescription());
        values.put(DbSchema.BenchmarkTable.Cols.TYPE_PHONE, test.getTypeOfPhone());
        values.put(DbSchema.BenchmarkTable.Cols.DATE, test.getDate());
        values.put(DbSchema.BenchmarkTable.Cols.SCORE, test.getScore());

        return values;
    }


    public List<Test> getTests() {

        List<Test> tests = new ArrayList<>();
        try (WCursor cursor = (WCursor) help.queryTest(null, null)) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                tests.add(cursor.getTest());
                cursor.moveToNext();
            }
        }
        return tests;
    }

    public void addTest(Test test) {
        ContentValues values = getContentValues(test);
        help.getDatabase().insert(DbSchema.BenchmarkTable.NAME, null, values);
    }




}
