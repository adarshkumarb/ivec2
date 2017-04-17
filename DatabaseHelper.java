package com.example.vecmo.ivec;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.PublicKey;

/**
 * Created by vecmo on 22-03-2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "List.db";
    public static final String TABLE_NAME = "User_Table";
    public static final String SERIAL = "SERIAL";
    public static final String USERNAME = "USERNAME";
    public static final String PASSWORD = "PASSWORD";
    public static final String MOBILE = "MOBILE";
    public static final String VEHICLE = "VEHICLE";
    public static final String VEHICLE_NO = "REGISTRATION";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME + " (SERIAL INTEGER PRIMARY KEY AUTOINCREMENT,USERNAME TEXT, PASSWORD TEXT,MOBILE INTEGER,VEHICLE TEXT , REGISTRATION INTEGER) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData (String username , String password ,String mobile, String vehicle , String registration ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues ();
        contentValues.put(USERNAME,username);
        contentValues.put(PASSWORD,password);
        contentValues.put(MOBILE,mobile);
        contentValues.put(VEHICLE,vehicle);
        contentValues.put(VEHICLE_NO,registration);
        long result = db.insert(TABLE_NAME,null,contentValues);

        if (result == -1) return false ;
        else return true ;
    }
}
