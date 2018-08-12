package com.example.paczek.paczek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class AutoCompleteActivity extends AppCompatActivity {

    private static String[] voivodeships;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);

        voivodeships = getResources().getStringArray(R.array.voivodeships);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, voivodeships);
        AutoCompleteTextView textView1 = (AutoCompleteTextView)
                findViewById(R.id.autoCompleteTextView);
        textView1.setAdapter(adapter);

        MultiAutoCompleteTextView textView2 = (MultiAutoCompleteTextView)
                findViewById(R.id.multiAutoCompleteTextView);
        textView2.setAdapter(adapter);
        textView2.setTokenizer(
                new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
