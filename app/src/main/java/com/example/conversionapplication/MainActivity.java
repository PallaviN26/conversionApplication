package com.example.conversionapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.example.conversionapplication.db.CategoryHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
    }
    public void categoryFile(View view){
        Button button = findViewById(R.id.button);
        Intent intent = new Intent(MainActivity.this,Temperature.class);
        startActivity(intent);
    }
}