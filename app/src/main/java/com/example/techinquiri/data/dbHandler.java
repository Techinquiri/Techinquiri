package com.example.techinquiri.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHandler extends SQLiteOpenHelper
{
    //Initialize Variables
    private static final String DATABASE_NAME = "techinquiri_db";
    public static final String TABLE1 = "users";   //username, phone, email, password
    public static final String TABLE2 = "story";   //storyid, storyname, relevant image
    public static final String TABLE3 = "branch";  //branchid, storyid, branchname
    public static final String TABLE4 = "questions";   //qid, branchid, question, answer, isFinal, nextStoryId

    public dbHandler(Context context)
    {
        super(context,DATABASE_NAME,null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase DB)
    {
        //Create Tables
        String table1 = "CREATE TABLE "+TABLE1+"(username TEXT, phone INTEGER, email TEXT PRIMARY KEY, password TEXT)";
        //String table2 = "CREATE TABLE "+TABLE2+"(sid INTEGER PRIMARY KEY, sname TEXT)";
        DB.execSQL(table1);
        //db.execSQL(table2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //Drop existing tables
        db.execSQL("DROP TABLE IF EXISTS "+TABLE1);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE2);
    }

    //Create Insert Method
    public boolean insertUser(String name, String phone, String email, String password)
    {
        //Get writable database
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        //Create content values
        ContentValues value1 = new ContentValues();
        value1.put("username",name);
        value1.put("phone",phone);
        value1.put("email",email);
        value1.put("password",password);
        long result = sqLiteDatabase.insert(TABLE1,null,value1);
        if(result==-1)
            return false;
        else return true;
    }

    public Cursor viewUser()
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM users",null);
        return cursor;
    }
}
