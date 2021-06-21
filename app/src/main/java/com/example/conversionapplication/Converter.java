package com.example.conversionapplication;

import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.conversionapplication.db.CategoryHelper;
import com.example.conversionapplication.db.contract.CategoryAdapter;

public abstract class Converter extends AppCompatActivity {

    public void listMainCategory(Spinner spinner) {
        CategoryHelper helper = new CategoryHelper(this);
        helper.insert();
        //CategoryAdapter adapter = new CategoryAdapter(this,helper.getData());
        String[] values = {"TEMP", "TOMP"};
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.activity_temperature, values);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


    }

    public void listOptions(Spinner dropdown1, Spinner dropdown2) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.temperature_options, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown1.setAdapter(adapter);
//        TextView textView=(TextView)findViewById(R.id.textView);
//        textView.setText(dropdown1.getSelectedItem().toString());
        dropdown2.setAdapter(adapter);
    }

    public double readInput(EditText text) {
        final double[] inputValue = new double[1];
        text.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i("Value", s.toString());
                inputValue[0] = Double.parseDouble(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });
        // On entering a digit the entered input to be read return the number
        return inputValue[0];
    }


    public abstract double convert(double input, String unitFrom, String unitTo);
}