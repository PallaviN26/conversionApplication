package com.example.conversionapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.conversionapplication.db.CategoryContract;
import com.example.conversionapplication.db.TemperatureHelper;

public class Temperature extends Converter {
    ImageView swapImage;
    Spinner mainCategory, initialUnit,finalUnit;
    EditText input1,input2;
    TextView output;
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
        output=findViewById(R.id.output);
        readInput(input1);
        value = Converter.inputValue;
        listMainCategory(mainCategory);
        listOptions(initialUnit,finalUnit,"temperature");
    }


    @Override
    public void convert(double input, String unitFrom, String unitTo) {
        Log.i("currentfunction","convert for switch");
        double currInput=Converter.inputValue;
        Log.i("currentinput",String.valueOf(currInput));
        double resultValue=0.0;
        Log.i("sourcetargetunit",Converter.sourceUnit+" "+Converter.targetUnit);
        switch (Converter.sourceUnit){
            case "Kelvin":
                switch (Converter.targetUnit){
                case "Celsius":
                    resultValue=convertKelvinToCelsius(currInput);
                    break;
                case "Fahrenheit":
                    resultValue=convertKelvinToFahrenheit(currInput);
                    break;
                default:
                    resultValue=currInput;
            }
                break;
            case "Fahrenheit":
            switch(Converter.targetUnit){
                case "Kelvin":
                    resultValue=convertFahrenheitToKelvin(currInput);
                    break;
                case "Celsius":
                    resultValue=convertFahrenheitToCelsius(currInput);
                    break;
                default:
                    resultValue=currInput;
            }
            break;
            case "Celsius":
            switch (Converter.targetUnit){
                case "Fahrenheit":
                    resultValue=convertCelsiusToFahrenheit(currInput);
                    break;
                case "Kelvin":
                    resultValue=convertCelsiusToKelvin(currInput);
                    break;
                default:
                    resultValue=currInput;
            }
            default:
                Log.i("Invalid","invalid input by source");
        }
        Log.i("resValue",String.valueOf(resultValue));
        output.setText(String.format("%.2f",resultValue));
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
    public double convertKelvinToFahrenheit(double kelvin){
        return (kelvin-273.15)*9/5+32;
    }
    public double convertFahrenheitToKelvin(double fahrenheit){
        return (fahrenheit-32)*5/9+273.15;
    }
    public double convertFahrenheitToCelsius(double fahrenheit){
        return (273-32)*5/9;
    }

}