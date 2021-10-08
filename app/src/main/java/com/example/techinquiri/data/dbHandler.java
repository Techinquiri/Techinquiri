package com.example.techinquiri.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class dbHandler extends SQLiteOpenHelper
{
    //Initialize Variables
    private static final String DATABASE_NAME = "techinquiri_db";
    public static final String TABLE1 = "users";   //username, phone, email, password
    public static final String TABLE2 = "story";   //storyid, storyname, storydesc
    public static final String TABLE3 = "branch";  //branchid, storyid, branchname
    public static final String TABLE4 = "questions";   //qid, branchid, question, answer, isFinal, nextStoryId

    public dbHandler(Context context)
    {
        super(context,DATABASE_NAME,null,6);
    }

    @Override
    public void onCreate(SQLiteDatabase DB)
    {
        //Create Tables
        String table1 = "CREATE TABLE "+TABLE1+"(username TEXT, phone INTEGER, email TEXT PRIMARY KEY, password TEXT)";
        DB.execSQL(table1);
        String table2 = "CREATE TABLE "+TABLE2+"(sid INTEGER PRIMARY KEY, sname TEXT , sdesc TEXT, UNIQUE(sname))";
        DB.execSQL(table2);
        String table3 = "CREATE TABLE "+TABLE3+"(bid INTEGER PRIMARY KEY, sid INTEGER, bname TEXT, UNIQUE(bname))";
        DB.execSQL(table3);
        String table4 = "CREATE TABLE "+TABLE4+"(qid INTEGER PRIMARY KEY, branchid INTEGER, question TEXT, answer TEXT, isFinal TEXT, nextStoryId INTEGER, UNIQUE(question))";
        DB.execSQL(table4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //Drop existing tables
        db.execSQL("DROP TABLE IF EXISTS "+TABLE1);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE2);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE3);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE4);
        onCreate(db);
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

    public boolean addStory(String sname, String desc)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put("sname",sname);
        value.put("sdesc",desc);
        long result = sqLiteDatabase.insert(TABLE2,null,value);
        if(result==-1)
            return false;
        else return true;
    }

    public boolean addBranch(Integer sid, String bname)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put("sid",sid);
        value.put("bname",bname);
        long result = sqLiteDatabase.insert(TABLE3,null,value);
        if(result==-1)
            return false;
        else return true;
    }

    public boolean addQuestions(int bid, String question, String answer, String isFinal, int nextStoryId)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("branchid",bid);
        value.put("question",question);
        value.put("answer",answer);
        value.put("isFinal",isFinal);
        value.put("nextStoryId",nextStoryId);
        long result = sqLiteDatabase.insert(TABLE4,null,value);
        if(result==-1)
            return false;
        else return true;
    }

    public boolean deleteStory(String sname)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        long result = sqLiteDatabase.delete(TABLE2,"sname=?",new String[]{sname});
        if(result==-1)
            return false;
        else return true;
    }

    public int getSID(String sname)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String[] columns ={"sid"};
        int sid = -1;
        Cursor cursor = null;
        cursor = sqLiteDatabase.query(TABLE2, columns, "sname=?", new String[] { sname }, null, null, null);
        if(cursor.moveToFirst())
        {
            sid = Integer.parseInt(cursor.getString(0));
        }
        return sid;
    }

    public Cursor viewUser()
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM users",null);
        return cursor;
    }

    public Cursor viewStories()
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE2;

        Cursor cursor = null;
        cursor = sqLiteDatabase.rawQuery(query,null);
        return cursor;
    }

    public Cursor viewBranchByStory(Integer sid)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT bname FROM " + TABLE3 + " WHERE sid = " +sid;

        Cursor cursor= null;
        cursor = sqLiteDatabase.rawQuery(query,null);
        return cursor;
    }
}
