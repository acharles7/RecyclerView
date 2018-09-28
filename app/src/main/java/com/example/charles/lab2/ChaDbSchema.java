package com.example.charles.lab2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ChaDbSchema extends SQLiteOpenHelper {

    public static final String DB_NAME = "URL";
    public static final String TABLE_NAME = "SNAME";
    public static final String COL_1 = "NAME";
    public static final String COL_2 = "TITLE";
    public static final String COL_3 = "SUBTITLE";

    public ChaDbSchema(Context context) {
        super(context, DB_NAME, null, 1);


    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+TABLE_NAME+" (NAME TEXT,TITLE TEXT,SUBTITLE TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+TABLE_NAME);
        //onCreate(sqLiteDatabase);

    }

    public boolean insertData(String name,String title, String subTitle){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,title);
        contentValues.put(COL_3,subTitle);

        long result = sqLiteDatabase.insert(TABLE_NAME,null, contentValues);

        if(result== -1)
            return false;
        else
            return true;
    }

    public List allData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+TABLE_NAME,null);

       List<CData> Clist = new ArrayList();

        if(cursor.moveToFirst()){
            do{
                String s1 = cursor.getString(0);
                String s2 = cursor.getString(1);
                String s3 = cursor.getString(2);

                CData cData = new CData(s1,s2,s3);
                Clist.add(cData);



            }while(cursor.moveToNext());
        }

        return Clist;

    }




}
