package com.example.conversionapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import com.example.conversionapplication.db.CategoryHelper;
import java.util.List;

public abstract class Converter extends AppCompatActivity {

    public void listMainCategory(Spinner spinner) {
        CategoryHelper helper = new CategoryHelper(this);
        helper.insert();
        List<String> values = helper.getData();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


    }

    public void listOptions(Spinner dropdown1, Spinner dropdown2,String tableName) {
        DatabaseHandler db=new DatabaseHandler(getApplicationContext(),"UnitDatabase",null,1);
        List<String> label=db.getUnits(tableName);
//        for(String s:label)
//            Log.i("tableContents",s);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,label);
            //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.temperature_options, android.R.layout.simple_spinner_dropdown_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dropdown1.setAdapter(adapter);
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