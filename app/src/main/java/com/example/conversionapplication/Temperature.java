package com.example.conversionapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class Temperature extends Converter {
    ImageView swapImage;
    Spinner spinner,dropdown1,dropdown2;
    EditText input1,input2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_temperature);
        swapImage = findViewById(R.id.swap);
        swapImage.setRotation(90);
        spinner = findViewById(R.id.category);
        dropdown1 = findViewById(R.id.temperatureUnit1);
        dropdown2= findViewById(R.id.temperatureUnit2);
        listMainCategory(spinner);
        listOptions(dropdown1,dropdown2);
    }


}