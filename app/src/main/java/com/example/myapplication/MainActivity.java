package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editTextMinValue;
    EditText editTextMaxValue;
    int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_counter);
        editTextMinValue = findViewById(R.id.editTextMinValue);
        editTextMaxValue = findViewById(R.id.editTextMaxValue);
    }

    public void counter(View view){
        System.out.println(textView.getText().toString() + " !!!!!!!");
        counter = Integer.parseInt(textView.getText().toString());
        counter++;
        textView.setText(Integer.toString(counter));
    }

    public void sortBetween(View view){
        int min = Integer.parseInt(editTextMinValue.getText().toString());
        int max = Integer.parseInt(editTextMaxValue.getText().toString());
        Random r = new Random();
        int result = r.nextInt(max-min) + min;
        textView.setText(Integer.toString(result));
    }
}