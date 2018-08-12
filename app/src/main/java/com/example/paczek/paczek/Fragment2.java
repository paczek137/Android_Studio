package com.example.paczek.paczek;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Fragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment2, container, false);
        View view = inflater.inflate(R.layout.fragment2, container, false);
        Button button = (Button) view.findViewById(R.id.buttonFragment2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity activity = getActivity();
                EditText editText = (EditText) activity.findViewById(R.id.editTextFragment1);
                Toast.makeText(activity, editText.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
