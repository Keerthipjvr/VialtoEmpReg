package com.example.vialtoemployeeregistration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    public Database( Context context) {
        super(context, "EmpEntry.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table EmployeeDetails(name TEXT primary key, address TEXT, skill TEXT, contact TEXT, email TEXT, Location TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists EmployeeDetails");

    }

    public Boolean insertEmp(String name, String address, String skill, String contact, String email, String location)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("address", address);
        contentValues.put("skill", skill);
        contentValues.put("contact", contact);
        contentValues.put("email", email);
        contentValues.put("location", location);

        long result = DB.insert("EmployeeDetails", null, contentValues);
        if(result == -1)
        {
            return false;
        }
        else {
            return true;
        }
    }


    public Cursor getData(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from EmployeeDetails", null);
        return cursor;

    }
}
