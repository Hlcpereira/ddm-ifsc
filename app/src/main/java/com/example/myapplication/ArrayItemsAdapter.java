package com.example.myapplication;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ArrayItemsAdapter extends ArrayAdapter<Item> {
    int mResource;
    public ArrayItemsAdapter(@NonNull Context context, int resource, @NonNull List<Item> objects) {
        super(context, resource, objects);
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View v = inflater.inflate(mResource,parent,false);

        Item item = getItem(position);

        TextView tv = v.findViewById(R.id.textViewKek);
        tv.setText(item.name);

        ImageView iv = v.findViewById(R.id.imageView);
        iv.setImageResource(item.photo);

        return v;
    }
}
