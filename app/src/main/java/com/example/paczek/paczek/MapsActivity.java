package com.example.paczek.paczek;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MapsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
    }

    public void OnOpenWebsite(View view) {
        EditText editText = (EditText) findViewById(R.id.editTextWebsite);
        String www = editText.getText().toString();

        Uri uri = Uri.parse("http://" + www);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);

        startActivity(intent);
    }

    public void OnShowTheCity(View view) {
        EditText editText = (EditText) findViewById(R.id.editTextCity);
        String city = editText.getText().toString();

        Uri geoUri = Uri.parse("geo:0,0?q=" + city);
        Intent intent = new Intent(Intent.ACTION_VIEW, geoUri);

        startActivity(intent);
    }

    public void OnShowTheLocation(View view) {
        EditText editText = (EditText) findViewById(R.id.editTextLatitude);
        String lat = editText.getText().toString();

        EditText editText2 = (EditText) findViewById(R.id.editTextLongnitude);
        String lon = editText2.getText().toString();

        String s = String.format("geo:%s,%s", lon, lat);
        Uri geoUri = Uri.parse(s);
        Intent intent = new Intent(Intent.ACTION_VIEW, geoUri);
        startActivity(intent);
    }
}
