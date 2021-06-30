package com.example.conversionapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class CategoryHelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + CategoryContract.CategoryEntry.TABLE_NAME + " (" +
                   CategoryContract.CategoryEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                    CategoryContract.CategoryEntry.COLUMN_NAME_NAMES + " TEXT)";

    private static final String SQL_FIND_ROWS = "Select "+CategoryContract.CategoryEntry.COLUMN_NAME_ID+"  From "
            + CategoryContract.CategoryEntry.TABLE_NAME+" ORDER BY 1 DESC LIMIT 1" ;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Convertor.db";
    public CategoryHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
        Log.i("Tablecreation","category");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS category");
        onCreate(db);

    }
    public void insert(){


      //  deleteData();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        Cursor res = db.rawQuery(SQL_FIND_ROWS,null);
        Log.i("count value:",String.valueOf(res.getCount()));
        if(res.getCount() == 0 ) {
            values.put(CategoryContract.CategoryEntry.COLUMN_NAME_ID, 3);
            values.put(CategoryContract.CategoryEntry.COLUMN_NAME_NAMES, "Temperature");
            db.insert(CategoryContract.CategoryEntry.TABLE_NAME, null, values);
            values.put(CategoryContract.CategoryEntry.COLUMN_NAME_ID, 1);
            values.put(CategoryContract.CategoryEntry.COLUMN_NAME_NAMES, "Currency");
            db.insert(CategoryContract.CategoryEntry.TABLE_NAME, null, values);
            values.put(CategoryContract.CategoryEntry.COLUMN_NAME_ID, 4);
            values.put(CategoryContract.CategoryEntry.COLUMN_NAME_NAMES, "Time");
            db.insert(CategoryContract.CategoryEntry.TABLE_NAME, null, values);
            values.put(CategoryContract.CategoryEntry.COLUMN_NAME_ID, 2);
            values.put(CategoryContract.CategoryEntry.COLUMN_NAME_NAMES, "Length");
            db.insert(CategoryContract.CategoryEntry.TABLE_NAME, null, values);
            values.put(CategoryContract.CategoryEntry.COLUMN_NAME_ID, 5);
            values.put(CategoryContract.CategoryEntry.COLUMN_NAME_NAMES, "Weight");
            db.insert(CategoryContract.CategoryEntry.TABLE_NAME, null, values);

     }

    }
    public List<String> getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<String> list=new ArrayList<String>();
        String  SQL_GET_ENTRY = "select "+ CategoryContract.CategoryEntry.COLUMN_NAME_NAMES +" from  " + CategoryContract.CategoryEntry.TABLE_NAME;
        Cursor c =  db.rawQuery(SQL_GET_ENTRY,null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            list.add(c.getString(c.getColumnIndex("name")));
            Log.i("column index of names " ,c.getString(c.getColumnIndex("name")));
            c.moveToNext();
        }
        db.close();
        return list;

    }
    public void deleteData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("Delete from " + CategoryContract.CategoryEntry.TABLE_NAME);
    }

}
