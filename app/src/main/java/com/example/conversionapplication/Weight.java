package com.example.conversionapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.conversionapplication.db.DatabaseHelper;
import com.example.conversionapplication.spinner.CategorySpinnerActivity;

import java.util.List;

public class Weight extends Converter {
    ImageView swapImage;
    Spinner mainCategory, initialUnit,finalUnit;
    EditText input1,input2;
    TextView output;
    double value;

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        //context= this;
        converter = this;
        setContentView(R.layout.activity_temperature);
        swapImage = findViewById(R.id.swap);
        swapImage.setRotation(90);
        mainCategory = findViewById(R.id.category);
        initialUnit = findViewById(R.id.temperatureUnit1);
        finalUnit= findViewById(R.id.temperatureUnit2);
        input1 = findViewById(R.id.input1);
        output=findViewById(R.id.output);
        output.setText("");
        readInput(input1);
        value = Converter.inputValue;
        listMainCategory(mainCategory);

        db=new DatabaseHelper(getApplicationContext(),"UnitDatabase",null,1);
        db.deleteTable("weight");
        Log.i("Weight ","start");
        db.insertLabel("Tonne", 0.001,"weight");
        Log.i("weight","inserted");
        db.insertLabel("Kilogram", (double) 1,"weight");
        db.insertLabel("Gram", (double) 1000,"weight");
        db.insertLabel("Quintal", (double) 0.01,"weight");
        db.insertLabel("Pound", (double) 2.2046226218,"weight");
        db.insertLabel("Ounce", (double) 35.27396195,"weight");
        listOptions(initialUnit,finalUnit,"weight");
        Converter.sourceUnit="Kilogram";
        Converter.targetUnit="Kilogram";
        mainCategory.setOnItemSelectedListener(new CategorySpinnerActivity());
        output.setText("");
    }
    @Override
    public void convert(double input, String unitFrom, String unitTo) {
        Log.i("sourceValue",Converter.sourceUnit);
        Log.i("targetValue",Converter.targetUnit);
        double sourceValue=db.getValues("weight",Converter.sourceUnit);
        double targetValue=db.getValues("weight",Converter.targetUnit);
        double resValue=Converter.inputValue/sourceValue*targetValue;
        output.setText(String.format("%.4f",resValue));
    }
}
