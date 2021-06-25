package com.example.conversionapplication.spinner;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.conversionapplication.Converter;

public class TargetUnitListener implements AdapterView.OnItemSelectedListener{

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Converter.targetUnit = parent.getItemAtPosition(position).toString();
        Log.i("target Unit ", Converter.targetUnit);
        Converter.getConverter().convert(Converter.inputValue,Converter.sourceUnit,Converter.targetUnit);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        int position= parent.getFirstVisiblePosition();
        Log.i("Nothing Selected", parent.getItemAtPosition(position).toString());
        Converter.targetUnit= parent.getItemAtPosition(position).toString();
    }
}
