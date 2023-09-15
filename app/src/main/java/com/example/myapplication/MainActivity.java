package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    String [] kekw = new String[] {"hu3", "hu3hu3", "hu3hu3hu3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.listView);
        ArrayList<Item> arrayList = new ArrayList<>();
        arrayList.add(new Item(1, "cachorro", R.drawable.cachorro));
        arrayList.add(new Item(1, "gardem", R.drawable.gardem));
        arrayList.add(new Item(1, "happy", R.drawable.happy));
        arrayList.add(new Item(1, "patinho", R.drawable.patinho));

        ArrayItemsAdapter adapter = new ArrayItemsAdapter(this, R.layout.lista,arrayList);

        lv.setAdapter(adapter);
    }
}