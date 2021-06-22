package com.example.conversionapplication.spinner;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

public class CategorySpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String value = (String)parent.getItemAtPosition(position);
        Log.i("Selected Value",value);
        switch(value){
            case "Temperature" : ;
            case "Weight" :;
            case "Length":;
            case "Currency ":;
            case "Time":;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
