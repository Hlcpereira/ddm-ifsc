package com.example.tarefa2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondaryActivity extends AppCompatActivity {

    TextView textViewResult;
    TextView textViewMass;
    TextView textViewHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        Button btn = findViewById(R.id.button);
        Bundle bundle = getIntent().getExtras();
        String result = bundle.getString("result");
        String mass = bundle.getString("mass");
        String height = bundle.getString("height");

        textViewResult = findViewById(R.id.textBoxResult);
        textViewMass = findViewById(R.id.textBoxMass);
        textViewHeight = findViewById(R.id.textBoxHeight);

        textViewResult.setText(result);
        textViewMass.setText(mass);
        textViewHeight.setText(height);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondaryActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}