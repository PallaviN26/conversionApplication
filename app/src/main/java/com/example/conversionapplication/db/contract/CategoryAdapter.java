package com.example.conversionapplication.db.contract;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.Spinner;

import com.example.conversionapplication.R;

import static com.example.conversionapplication.db.contract.CategoryContract.CategoryEntry.COLUMN_NAME_NAMES;

public class CategoryAdapter extends CursorAdapter {


    public CategoryAdapter(Context context, Cursor c) {
        super(context, c,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.activity_temperature,parent,false);
    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        Spinner spinner =  view.findViewById(R.id.category);
//        String  str = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME_NAMES));
//
//        spinner.setAdapter();
    }
}
