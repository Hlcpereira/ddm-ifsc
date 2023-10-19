package com.example.tts;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
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

    private SQLiteDatabase banco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.textToSpeech);
        button = findViewById(R.id.buttonSpeak);

        tts = new TextToSpeech(this, this);
        loadTTS = false;

        handleDatabase("Olá");
        handleDatabase("Bom dia");
        handleDatabase("Boa Tarde");
        handleDatabase("Boa Noite");
        handleDatabase("Até logo");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = banco.rawQuery("SELECT _id, text FROM text ", null);
                cursor.moveToFirst();
                while (cursor.moveToNext()){
                    String text = cursor.getString(cursor.getColumnIndex("text"));
                    speak(text);
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

    public void speak(String text){
        if (loadTTS){
            tts.speak(text, TextToSpeech.QUEUE_ADD, null, null);
        }
    }

    public void handleDatabase(String text){
        this.banco = openOrCreateDatabase("banco", getBaseContext().MODE_PRIVATE,null);

        banco.execSQL("CREATE TABLE IF NOT EXISTS text (_id INTEGER PRIMARY KEY AUTOINCREMENT,text TEXT )" );

        ContentValues contentValues = new ContentValues();
        contentValues.put("text",text);
        banco.insert("text",null,contentValues );
    }
}