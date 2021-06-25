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

import java.util.Currency;

public class CategorySpinnerActivity implements AdapterView.OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       Converter.Category = parent.getItemAtPosition(position).toString();
//       Intent intent;
//       switch(position){
//           case 0 :
//                    intent = new Intent(Converter.context.getApplicationContext(), Temperature.class);
//                    Converter.context.startActivity(intent);
//                    break;
//           case 1 :
//                    intent = new Intent(Converter.context.getApplicationContext(), Time.class);
//                    Converter.context.startActivity(intent);
//                    break;
//           case 2:
//                    intent = new Intent(Converter.context.getApplicationContext(), Length.class);
//                    Converter.context.startActivity(intent);
//                    break;
//           case 3 :
//                    intent = new Intent(Converter.context.getApplicationContext(),Temperature.class);
//                    Converter.context.startActivity(intent);
//                    break;
//       }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
