package com.example.conversionapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.conversionapplication.Converter;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS temperature(unit TEXT, value REAL)");
        Log.i("Tablecreation","Temp");
        db.execSQL("CREATE TABLE IF NOT EXISTS weight(unit TEXT, value REAL)");
        Log.i("Tablecreation","Weight");
        db.execSQL("CREATE TABLE IF NOT EXISTS length(unit TEXT, value REAL)");
        Log.i("Tablecreation","Length");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS temperature");
        db.execSQL("DROP TABLE IF EXISTS weight");
        db.execSQL("DROP TABLE IF EXISTS length");
        onCreate(db);

    }
    public void insertLabel(String unit,Double value,String tableName){
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

    public double getValues(String tableName,String currUnit){
//        Log.i("status of db","entered getValues");
        SQLiteDatabase db=this.getReadableDatabase();
//        Log.i("CheckingSourceTarget","SELECT * FROM "+tableName+" WHERE unit = '"+currUnit+"'");
        Cursor cursor=db.rawQuery("SELECT * FROM "+tableName+" WHERE unit like '"+currUnit+"'",null);
//        Log.i("Cursor Length", String.valueOf(cursor.getCount()));
        cursor.moveToFirst();
//        Log.i("ValueOfWeightUnit", String.valueOf(cursor.getDouble(1)));
        return cursor.getDouble(1);
//        return 1.0;
    }

    public void deleteTable(String tableName){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DELETE FROM "+tableName);
    }
}
