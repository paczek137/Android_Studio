package com.example.paczek.paczek;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class OrientationActivity extends AppCompatActivity {

    public static final String tag = "OrientationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Log.d(tag, "Function onConfigurationChanged()");
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "Portrait orientation", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Landscape orientation", Toast.LENGTH_SHORT).show();
        }
    }
}
