package com.example.techinquiri.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHandler extends SQLiteOpenHelper
{
    //Initialize Variables
    private static final String DATABASE_NAME = "techinquiri_db";
    private static final String TABLE1 = "users";   //userid, username, phone, emailaddress
    private static final String TABLE2 = "story";   //storyid, storyname, relevant image
    private static final String TABLE3 = "branch";  //branchid, storyid, branchname
    private static final String TABLE4 = "questions";   //qid, branchid, question, answer, isFinal, nextStoryId

    public dbHandler(Context context)
    {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //Create Tables
        String table2 = "CREATE TABLE "+TABLE2+"(sid INTEGER PRIMARY KEY, sname TEXT)";
        db.execSQL(table2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //Drop existing tables
        db.execSQL("DROP TABLE IF EXISTS "+TABLE2);
    }

    //Create Insert Method
    public boolean insert(String sname)
    {
        //Get writable database
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        //Create content values
        ContentValues value2 = new ContentValues();
        value2.put("sname",sname);
        long result = sqLiteDatabase.insert(TABLE2,null,value2);
        if(result==-1)
            return false;
        else return true;
    }
}
