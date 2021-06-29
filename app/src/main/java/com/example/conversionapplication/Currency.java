package com.example.conversionapplication;

import android.widget.Toast;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
public class Currency extends Converter {
    ImageView swapImage;
    Spinner mainCategory, initialUnit,finalUnit;
    EditText input1,input2;
    TextView output;
    double value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        context = this;
        converter = this;
        setContentView(R.layout.activity_temperature);
        swapImage = findViewById(R.id.swap);
        swapImage.setRotation(90);
        mainCategory = findViewById(R.id.category);
        initialUnit = findViewById(R.id.temperatureUnit1);
        finalUnit= findViewById(R.id.temperatureUnit2);
        input1 = findViewById(R.id.input1);
        output=findViewById(R.id.output);
        Toast.makeText(this,"HI ",Toast.LENGTH_SHORT).show();
        // readInput(input1);
        // value = Converter.inputValue;
        // listMainCategory(mainCategory);
        // listOptions(initialUnit,finalUnit,"temperature");
    }
    @Override
    public void convert(double input, String unitFrom, String unitTo) {


    }
}
