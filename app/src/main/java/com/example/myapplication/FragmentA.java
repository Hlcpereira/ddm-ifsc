package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentA extends Fragment {
    TextView textView ;
    Button buttonSend;
    EditText editText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_a,container,false);
        textView = v.findViewById(R.id.tvMsg);
        buttonSend=v.findViewById(R.id.buttonSend);
        editText = v.findViewById(R.id.edMsg);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentB  fragmentB =new FragmentB();

                Bundle b = new Bundle( );
                b.putString("message", editText.getText().toString());
                fragmentB.setArguments(b);

                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout,fragmentB);
                transaction.commit();
            }
        });

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        if ( getArguments()!=null && getArguments().containsKey("msg")) {
            this.textView.setText(getArguments().getString("msg"));
        }
    }
}
