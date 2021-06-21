package com.example.conversionapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;


import com.example.conversionapplication.Temperature;
import com.example.conversionapplication.db.contract.CategoryContract;


public class CategoryHelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + CategoryContract.CategoryEntry.TABLE_NAME + " (" +
                   CategoryContract.CategoryEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                    CategoryContract.CategoryEntry.COLUMN_NAME_NAMES + " TEXT)";
    private static final String  SQL_GET_ENTRY = "Select"+ CategoryContract.CategoryEntry.COLUMN_NAME_NAMES +"from" + CategoryContract.CategoryEntry.TABLE_NAME;
    private static final String SQL_FIND_ROWS = "Select COUNT(*)  From " + CategoryContract.CategoryEntry.TABLE_NAME ;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Convertor.db";
    public CategoryHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insert(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        Cursor res = db.rawQuery(SQL_FIND_ROWS,null);
        int num = res.getCount();
        if(num == 0 ) {
            values.put(CategoryContract.CategoryEntry.COLUMN_NAME_ID, 1);
            values.put(CategoryContract.CategoryEntry.COLUMN_NAME_NAMES, "Currency");
            values.put(CategoryContract.CategoryEntry.COLUMN_NAME_ID, 2);
            values.put(CategoryContract.CategoryEntry.COLUMN_NAME_NAMES, "Time");
            values.put(CategoryContract.CategoryEntry.COLUMN_NAME_ID, 2);
            values.put(CategoryContract.CategoryEntry.COLUMN_NAME_NAMES, "Length");
            values.put(CategoryContract.CategoryEntry.COLUMN_NAME_ID, 4);
            values.put(CategoryContract.CategoryEntry.COLUMN_NAME_NAMES, "Weight");
            values.put(CategoryContract.CategoryEntry.COLUMN_NAME_ID, 5);
            values.put(CategoryContract.CategoryEntry.COLUMN_NAME_NAMES, "Temperature");
            db.insert(CategoryContract.CategoryEntry.TABLE_NAME, null, values);
        }
    }
    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(SQL_GET_ENTRY,null);
    }

}
