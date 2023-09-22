package com.example.tarefa8;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AppAdapter extends ArrayAdapter<ApplicationInfo> {
    public AppAdapter(@NonNull MainActivity mainActivity, int resource, @NonNull List<ApplicationInfo> objects) {
        super(mainActivity, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.item_app_list, parent, false);

        ApplicationInfo applicationInfo = getItem(position);

        TextView textViewAppName = view.findViewById(R.id.app_name);
        ImageView imageViewAppIcon = view.findViewById(R.id.app_icon);

        imageViewAppIcon.setImageDrawable(applicationInfo.loadIcon(getContext().getPackageManager()));
        textViewAppName.setText(applicationInfo.loadLabel(getContext().getPackageManager()));

        return view;
    }
}
