package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    ArrayList<String> kekw = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);

        lv = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.lista,
                R.id.textViewKek,
                kekw
        );

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input = findViewById(R.id.editText);
                kekw.add(input.getText().toString());
                lv.setAdapter(adapter);
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                AlertDialog.Builder albuilder = new AlertDialog.Builder(MainActivity.this);
                albuilder.setTitle("Delete");
                albuilder.setMessage("Excluir item?");
                albuilder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        kekw.remove(pos);
                        adapter.notifyDataSetChanged();
                    }
                });
                albuilder.setNegativeButton("Não", null);
                albuilder.show();
            }
        });
    }
}