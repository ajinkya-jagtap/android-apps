package com.ajinkya.sqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Databasehelper extends SQLiteOpenHelper {

    private static final String TAG="Databasehelper";
    private static final String TABLE_NAME="peopleTable";
    private static final String COL1="ID";
    private static final String COL2="name";




    public Databasehelper(Context context) {
        super(context,TABLE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = " CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 +" + TEXT)";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE EXIST"+ TABLE_NAME);
            onCreate(db);
    }

    public long addData(String item) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item);

        long result = database.insert(TABLE_NAME, null, contentValues);
return result;
    }

    public Cursor getData(){
        SQLiteDatabase database=this.getWritableDatabase();
        String query="SELECT * FROM " + TABLE_NAME;
        Cursor data=database.rawQuery(query,null);
        return data;
    }


}
