package com.example.conversionapplication;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public abstract class Converter extends AppCompatActivity {
    public void listMainCategory(Spinner spinner) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.basic_category_array, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }
    public void listOptions(Spinner dropdown1,Spinner dropdown2){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.temperature_options, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown1.setAdapter(adapter);
//        TextView textView=(TextView)findViewById(R.id.textView);
//        textView.setText(dropdown1.getSelectedItem().toString());
        dropdown2.setAdapter(adapter);
    }

}
