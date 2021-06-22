package com.example.conversionapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TemperatureHelper extends SQLiteOpenHelper {


    public TemperatureHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS temperature(unit TEXT, value INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS temperature");
        onCreate(db);

    }
    public void insertLabel(String unit,Integer value,String tableName){
        Log.i("table","insertLabel");
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("unit",unit);
        values.put("value",value);
        db.insert(tableName,null,values);
        db.close();
    }

    public List<String> getUnits(String tableName){
        Log.i("table","getUnits");
        List<String> list=new ArrayList<String>();
        String selectQuery="SELECT * FROM "+tableName;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery(selectQuery,null);
//        int indexUnit=c.getColumnIndex("unit");
//        Log.i("table","Index:"+indexUnit);
        c.moveToFirst();
//        Log.i("table",c.getString(indexUnit));
        while(!c.isAfterLast()){
            list.add(c.getString(0));
//            Log.i("table",c.getString(indexUnit));
//            Log.i("table","1");
            c.moveToNext();
        }
        db.close();
        return list;
    }

    public void deleteTable(String tableName){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DELETE FROM "+tableName);
    }
}
