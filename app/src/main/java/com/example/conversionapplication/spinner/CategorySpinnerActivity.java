package com.example.conversionapplication.spinner;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.conversionapplication.Converter;

public class CategorySpinnerActivity implements AdapterView.OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       Converter.Category = parent.getItemAtPosition(position).toString();
       // Log.i("Selected Value",value);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
