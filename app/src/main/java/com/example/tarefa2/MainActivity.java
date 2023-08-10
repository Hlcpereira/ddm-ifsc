package com.example.tarefa2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondaryActivity.class);
                EditText editTextMsgMass = findViewById(R.id.editTextMsgMass);
                EditText editTextMsgHeight = findViewById(R.id.editTextMsgHeight);
                double result = calculateBMI(editTextMsgMass.getText().toString(), editTextMsgHeight.getText().toString());
                intent.putExtra("result", Double.toString(result));
                intent.putExtra("mass", editTextMsgMass.getText().toString());
                intent.putExtra("height", editTextMsgHeight.getText().toString());
                startActivity(intent);
            }
        });
    }

    public double calculateBMI(String mass, String height)
    {
        double result = 0.0;

        result = Double.parseDouble(mass) / (Double.parseDouble(height) * Double.parseDouble(height));

        return result;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Init:", "Application started successfully");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Execution:", "Application paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Execution:", "Application resumed");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Exit:", "Gotta go. Bye, bye");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Exit:", "Ctrl-Alt-Del on my life");
    }
}