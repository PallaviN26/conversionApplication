package com.example.conversionapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class Temperature extends Converter {
    ImageView swapImage;
    Spinner mainCategory, initialUnit,finalUnit;
    EditText input1,input2;
    double value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        DatabaseHandler db=new DatabaseHandler(getApplicationContext(),"UnitDatabase",null,1);
        db.deleteTable("temperature");
        db.insertLabel("Kelvin",273,"temperature");
        db.insertLabel("Celsius",0,"temperature");
        db.insertLabel("Fahrenheit",300,"temperature");

        setContentView(R.layout.activity_temperature);
        swapImage = findViewById(R.id.swap);
        swapImage.setRotation(90);
        mainCategory = findViewById(R.id.category);
        initialUnit = findViewById(R.id.temperatureUnit1);
        finalUnit= findViewById(R.id.temperatureUnit2);
        input1 = findViewById(R.id.input1);
        value = readInput(input1);
        listMainCategory(mainCategory);
        listOptions(initialUnit,finalUnit,"temperature");
    }


    @Override
    public double convert(double input, String unitFrom, String unitTo) {
        return 0;
    }
}