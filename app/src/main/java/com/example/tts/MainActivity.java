package com.example.tts;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    public TextToSpeech tts;
    public EditText editText;
    public Button button;
    private boolean loadTTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.textToSpeech);
        button = findViewById(R.id.buttonSpeak);

        tts = new TextToSpeech(this, this);
        loadTTS = false;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loadTTS){
                    tts.speak(editText.getText().toString(), TextToSpeech.QUEUE_FLUSH, null, null);
                }
            }
        });
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS){
            loadTTS = true;
        } else {
            Log.e("TTS", "TTS não inicializado");
        }
    }
}