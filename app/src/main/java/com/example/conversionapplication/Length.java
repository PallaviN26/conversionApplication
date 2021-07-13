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

public class Length extends Converter{
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
        //context = this;
        converter= this;
        setContentView(R.layout.activity_temperature);
        swapImage = findViewById(R.id.swap);
        swapImage.setRotation(90);
        mainCategory = findViewById(R.id.category);
        initialUnit = findViewById(R.id.temperatureUnit1);
        finalUnit= findViewById(R.id.temperatureUnit2);
        input1 = findViewById(R.id.input1);
        output=findViewById(R.id.output);

        listMainCategory(mainCategory);
        db=new DatabaseHelper(getApplicationContext(),"UnitDatabase",null,1);
        insertDataToDB();
        readInput(input1);
        listOptions(initialUnit,finalUnit,"length");
        mainCategory.setOnItemSelectedListener(new CategorySpinnerActivity());
        Converter.sourceUnit = "Metre";
        Converter.targetUnit = "Metre";
        output.setText("");
    }

    private void insertDataToDB() {

        db.deleteTable("length");
        Log.i("Length ","start");
        db.insertLabel("Millimetre", (double) 1000,"length");
        db.insertLabel("Centimetre", (double) 100,"length");
        db.insertLabel("Decimetre", (double) 10,"length");
        db.insertLabel("Metre", (double) 1,"length");
        db.insertLabel("Kilometre",0.001,"length");
        db.insertLabel("Mile", 0.00062137,"length");
        db.insertLabel("Yard", 1.0936133,"length");
        db.insertLabel("Foot", 3.2808399,"length");
        db.insertLabel("Inch", 39.3700787,"length");
        db.insertLabel("Chain",0.0497097,"length");
        db.insertLabel("Furlong",0.00497097,"length");

    }

    @Override
    public void convert(double input, String unitFrom, String unitTo) {
        double sourceInmetres = db.getValues("length",Converter.sourceUnit);
        double targetInmetres = db.getValues("length",Converter.targetUnit);
        value = Converter.inputValue *  targetInmetres/sourceInmetres;
        output.setText(String.format("%.3f",value));
    }
}
