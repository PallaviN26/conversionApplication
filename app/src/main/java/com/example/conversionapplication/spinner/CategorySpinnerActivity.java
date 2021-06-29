package com.example.conversionapplication.spinner;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.conversionapplication.Converter;
import com.example.conversionapplication.Length;
import com.example.conversionapplication.Temperature;
import com.example.conversionapplication.Time;
import com.example.conversionapplication.Weight;

import java.util.Currency;
import java.util.concurrent.CopyOnWriteArrayList;

public class CategorySpinnerActivity implements AdapterView.OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       Converter.Category = parent.getItemAtPosition(position).toString();
       Intent intent;
       if(Converter.position == null || position != Converter.position  ) {
           switch (position) {
               case 0:
                   intent = new Intent(Converter.context.getApplicationContext(), Temperature.class);
                   Log.i("Which intent?", "Temperature");

                   Converter.context.startActivity(intent);
                   break;
               case 1:
                   intent = new Intent(Converter.context.getApplicationContext(), Length.class);
                   Log.i("Which intent?", "Length");
                   Converter.context.startActivity(intent);
                   break;
               case 2:
                   intent = new Intent(Converter.context.getApplicationContext(), Currency.class);
                   Log.i("Which intent ?"," Currency");
                   Converter.context.startActivity(intent);
                   break;
               case 3:
                   intent = new Intent(Converter.context.getApplicationContext(), Time.class);
                   Log.i("Which intent ?"," Time");
                   Converter.context.startActivity(intent);
                   break;
               case 4:
                   intent = new Intent(Converter.context.getApplicationContext(), Weight.class);
                   Log.i("Which intent ?"," Weight ");
                   Converter.context.startActivity(intent);
                   break;
           }
           Converter.position = position;
       }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
