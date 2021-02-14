package com.example.benchmark.database;

import android.database.CursorWrapper;

import com.example.benchmark.model.Test;

public class WCursor extends CursorWrapper {


    public WCursor(android.database.Cursor cursor) {
        super(cursor);
    }


    public Test getTest() {

        String uuid = getString(getColumnIndex( DbSchema.BenchmarkTable.Cols.UUID));
        String category = getString(getColumnIndex( DbSchema.BenchmarkTable.Cols.CATEGORY));
        String typeOfTest = getString(getColumnIndex( DbSchema.BenchmarkTable.Cols.TYPE_TEST));
        String description = getString(getColumnIndex( DbSchema.BenchmarkTable.Cols.DESCRIPTION));
        String typeOfPhone= getString(getColumnIndex( DbSchema.BenchmarkTable.Cols.TYPE_PHONE));
        long date = getLong(getColumnIndex( DbSchema.BenchmarkTable.Cols.DATE));
        double score = getDouble(getColumnIndex( DbSchema.BenchmarkTable.Cols.SCORE));


        return new Test(uuid, category, typeOfTest, description, typeOfPhone, date, score);
    }
}
