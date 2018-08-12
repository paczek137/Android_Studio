package com.example.paczek.paczek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UIComponentsActivity extends AppCompatActivity {

    private static final int stateActivityCode = 1;
    private static final int orientationActivityCode = 2;
    private static final int autoCompleteActivityCode = 3;
    private static final int listViewActivityCode = 4;
    private static final int listViewActivityCode2 = 5;
    private static final int spinnerActivityCode = 6;

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

    public void OnListview(View view) {
        startActivityForResult(new Intent(this, ListViewActivity.class),
                listViewActivityCode);
    }

    public void OnListview2(View view) {
        startActivityForResult(new Intent(this, ListView2Activity.class),
                listViewActivityCode2);
    }

    public void OnSpinner(View view) {
        startActivityForResult(new Intent(this, SpinnerActivity.class),
                spinnerActivityCode);
    }
}
