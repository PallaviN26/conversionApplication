package com.example.conversionapplication.spinner;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.conversionapplication.Converter;
import com.example.conversionapplication.Currency;
import com.example.conversionapplication.Length;
import com.example.conversionapplication.R;
import com.example.conversionapplication.Temperature;
import com.example.conversionapplication.Time;
import com.example.conversionapplication.Weight;

import java.util.concurrent.CopyOnWriteArrayList;

public class CategorySpinnerActivity implements AdapterView.OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       Converter.Category = parent.getItemAtPosition(position).toString();
//       Log.i("Which poistion",String.valueOf(position));
       Intent intent;
       if(position != Converter.position ) {
           switch (position) {
               case 0:
                   intent = new Intent(Converter.converter.getApplicationContext(), Temperature.class);
                   Log.i("Which intent?", "Temperature");
                   Converter.converter.startActivity(intent);
                   break;
               case 1:
                   intent = new Intent(Converter.converter.getApplicationContext(), Length.class);
                   Log.i("Which intent?", "Length");
                   Converter.converter.startActivity(intent);
                   break;
//               case 2:
//                   intent = new Intent(Converter.converter.getApplicationContext(), Temperature.class);
//                   Log.i("Which intent ?"," Currency");
//                   Converter.converter.startActivity(intent);
//                   break;
//               case 3:
//                   intent = new Intent(Converter.converter.getApplicationContext(), Time.class);
//                   Log.i("Which intent ?"," Time");
//                   Converter.converter.startActivity(intent);
//                   break;
               case 2:
                   intent = new Intent(Converter.converter.getApplicationContext(), Weight.class);
                   Log.i("Which intent ?"," Weight ");
                   Converter.converter.startActivity(intent);
                   break;
           }
           Converter.position = position;
           Log.i("POSITION",String.valueOf(Converter.position));
       }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
