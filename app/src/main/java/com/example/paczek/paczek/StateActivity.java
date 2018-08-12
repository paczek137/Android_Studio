package com.example.paczek.paczek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class StateActivity extends AppCompatActivity {

    public int click_counter;
    public String click_counter_key = "click_counter";

    public TextView textView;
    public EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);

    }

    public void OnClick(View view) {
        click_counter++;

        textView.setText(String.format("The button has been pressed %s times", click_counter));
        editText.setText(String.format("The button has been pressed %s times", click_counter));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(click_counter_key, click_counter);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        click_counter = savedInstanceState.getInt(click_counter_key);
        textView.setText(String.format("The button has been pressed %s times", click_counter));
        editText.setText(String.format("The button has been pressed %s times", click_counter));
    }
}
