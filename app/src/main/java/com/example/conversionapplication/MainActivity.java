package com.example.conversionapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.conversionapplication.db.CategoryHelper;

public class MainActivity extends AppCompatActivity {

    TextView temp,curr,wt,ln;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        temp=(TextView) findViewById(R.id.textViewTemperature);
//        curr=(TextView)findViewById(R.id.textViewCurrency);
        wt=(TextView) findViewById(R.id.textViewWeight);
        ln=(TextView)findViewById(R.id.textViewLength);
    }
    public void categoryFile(View view){
//        Button button = findViewById(R.id.button);
//        Intent intent = new Intent(MainActivity.this,Temperature.class);
//        Converter.position = 2;
//        startActivity(intent);
        if(view.equals(temp)){
            Intent intent = new Intent(MainActivity.this,Temperature.class);
            Converter.position = 0;
            startActivity(intent);
        }
//        else  if(view.equals(curr)){
//            Intent intent = new Intent(MainActivity.this,Currency.class);
//            Converter.position = 0;
//            startActivity(intent);
//        }
        else  if(view.equals(wt)){
            Intent intent = new Intent(MainActivity.this,Weight.class);
            Converter.position = 2;
            startActivity(intent);
        }
        else  if(view.equals(ln)){
            Intent intent = new Intent(MainActivity.this,Length.class);
            Converter.position = 1;
            startActivity(intent);
        }
    }
}