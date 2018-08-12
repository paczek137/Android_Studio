package com.example.paczek.paczek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void OnLogIn(View view) {
        Intent intent = new Intent();

        EditText name = (EditText) findViewById(R.id.editTextName);

        intent.putExtra("name", name.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

}
