package com.example.conversionapplication.spinner;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.conversionapplication.Converter;

public class SourceUnitListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Converter.sourceUnit = parent.getItemAtPosition(position).toString();
                Log.i("Source Unit",Converter.sourceUnit);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
                int position= parent.getFirstVisiblePosition();
                Log.i("Nothing Selected", parent.getItemAtPosition(position).toString());
                Converter.sourceUnit = parent.getItemAtPosition(position).toString();
        }
    }
