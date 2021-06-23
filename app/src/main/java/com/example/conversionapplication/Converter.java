package com.example.conversionapplication;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import com.example.conversionapplication.db.CategoryHelper;
import com.example.conversionapplication.db.TemperatureHelper;
import com.example.conversionapplication.spinner.CategorySpinnerActivity;
import com.example.conversionapplication.spinner.ConversionOptionsSpinnerActivity;

import java.util.List;

public abstract class Converter extends AppCompatActivity {
    public static String Category;
    public static String sourceUnit;
    public static String targetUnit;
    public static String value;
    public static double  inputValue;
    public void listMainCategory(Spinner spinner) {
        CategoryHelper helper = new CategoryHelper(this);
        helper.insert();
        List<String> values = helper.getData();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new CategorySpinnerActivity());
    }

    public void listOptions(Spinner dropdown1, Spinner dropdown2,String tableName) {
        TemperatureHelper db=new TemperatureHelper(getApplicationContext(),"UnitDatabase",null,1);
        List<String> label=db.getUnits(tableName);
        Log.i("labelLength:",String.valueOf(label.size()));
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,label);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown1.setAdapter(adapter);
        dropdown2.setAdapter(adapter);
       dropdown1.setOnItemSelectedListener(new ConversionOptionsSpinnerActivity());
        sourceUnit = value;
        dropdown2.setOnItemSelectedListener(new ConversionOptionsSpinnerActivity());
        targetUnit = value;
    }

    // On entering a digit the entered input to be read return the number
    public void  readInput(EditText text) {
        text.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i("Value", "1");
                inputValue = Double.parseDouble(s.toString());
                Log.i("inputValue", String.valueOf(inputValue));
                convert(inputValue,sourceUnit,targetUnit);
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });
    }
    public abstract void convert(double input, String unitFrom, String unitTo);
}