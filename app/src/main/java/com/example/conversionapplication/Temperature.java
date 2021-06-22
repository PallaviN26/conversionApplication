package com.example.conversionapplication;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.conversionapplication.db.TemperatureHelper;

public class Temperature extends Converter {
    ImageView swapImage;
    Spinner mainCategory, initialUnit,finalUnit;
    EditText input1,input2;
    double value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        TemperatureHelper db=new TemperatureHelper(getApplicationContext(),"UnitDatabase",null,1);
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

    public  double convertCelsiusToKelvin(double celsius){
        return  celsius+273.15;
    }

    public double convertKelvinToCelsius(double kelvin){
        return kelvin-273.15;
    }

    public double convertCelsiusToFahrenheit(double celsius){
        double Fahrenheit = (celsius*1.8) + 32;
        return  Fahrenheit;
    }


}