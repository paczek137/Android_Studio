package com.example.paczek.paczek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UIComponentsActivity extends AppCompatActivity {

    public static int stateActivityCode = 1;
    public static int orientationActivityCode = 2;
    public static int autoCompleteActivityCode = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uicomponents);
    }

    public void OnActivityState(View view) {
        startActivityForResult(new Intent(this, StateActivity.class),
                stateActivityCode);
    }

    public void OnOrientation(View view) {
        startActivityForResult(new Intent(this, OrientationActivity.class),
                orientationActivityCode);
    }

    public void OnAutoComplete(View view) {
        startActivityForResult(new Intent(this, AutoCompleteActivity.class),
                autoCompleteActivityCode);
    }
}
