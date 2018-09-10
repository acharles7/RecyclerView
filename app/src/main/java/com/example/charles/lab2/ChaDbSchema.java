package com.example.charles.lab2.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ChaDbSchema extends SQLiteOpenHelper {

    public static final String DB_NAME = "URL";
    public static final String TABLE_NAME = "URLINFO";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "URL";
    public static final String COL_3 = "TITLE";
    public static final String COL_4 = "SUB_TITLE";

    public ChaDbSchema(Context context) {
        super(context, DB_NAME, null, 1);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,URL VARCHAR,TITLE VARCHAR,SUB_TITLE VARCHAR)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    private void saveToDB(){
        SQLiteDatabase database = new ChaDbSchema()
    }




}
