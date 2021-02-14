package com.example.benchmark.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {


    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "testbench.db";
    private Context mContext;
    private SQLiteDatabase mDatabase;
    private static DbHelper instance;

    private DbHelper(Context context) {

        super(context, DATABASE_NAME, null, VERSION);
        mContext=context.getApplicationContext();
        openDataBase();
    }

    public SQLiteDatabase getDatabase() {
        return mDatabase;
    }

    public static DbHelper getInstance(Context context){

        if(instance==null){
            instance= new DbHelper(context);

        }
        return  instance;
    }

    public void openDataBase(){
        try {
            if (mDatabase == null || !mDatabase.isOpen()) {
                mDatabase = getWritableDatabase();
            }
        }catch (Exception e){
            mDatabase = getReadableDatabase();

        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.beginTransaction();
        db.execSQL("create table " + DbSchema.BenchmarkTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                DbSchema.BenchmarkTable.Cols.UUID + ", " +
                DbSchema.BenchmarkTable.Cols.CATEGORY + ", " +
                DbSchema.BenchmarkTable.Cols.TYPE_TEST+", "+
                DbSchema.BenchmarkTable.Cols.DESCRIPTION+", "+
                DbSchema.BenchmarkTable.Cols.TYPE_PHONE + ", " +
                DbSchema.BenchmarkTable.Cols.DATE+ ", " +
                DbSchema.BenchmarkTable.Cols.SCORE +  ")");

        db.setTransactionSuccessful();
        db.endTransaction();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    WCursor queryTest(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                DbSchema.BenchmarkTable.NAME, null,
                whereClause, whereArgs,
                null, null, null);

        return new WCursor(cursor);

    }
}
