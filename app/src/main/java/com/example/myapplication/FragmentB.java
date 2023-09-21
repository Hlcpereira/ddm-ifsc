package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentB extends Fragment {
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_b,container,false);
        textView=v.findViewById(R.id.textView);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getArguments()!= null && getArguments().containsKey("message")) {
            textView.setText(getArguments().getString("message"));
        }
    }
}