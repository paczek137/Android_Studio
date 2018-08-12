package com.example.paczek.paczek;

import android.app.Notification;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String tag = "EventsFromPaczek";
    int activityCode = 1;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "onDestroy()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "onRestart()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tag, "onCreate()");
    }

    public void OnDialogWindow(View v) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setIcon(R.mipmap.ic_launcher);
        progressDialog.setTitle("Getting data...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getBaseContext(), "Clicked OK", Toast.LENGTH_SHORT).show();
            }
        });
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getBaseContext(), "Clicked Cancel", Toast.LENGTH_SHORT).show();
            }
        });
        progressDialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i;
                for (i = 0; i <= 10; i++) {
                    try {
                        Thread.sleep(1500);
                        progressDialog.incrementProgressBy(10);
                        Log.d(tag, "i: " + Integer.toString(i) + " increased the bar by 10");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                progressDialog.dismiss();
            }
        }).start();
    }

    public void OnSwitchActivity(View view) {
        startActivityForResult(new Intent(this, SecondActivity.class), activityCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == activityCode) {
            if (resultCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                Toast.makeText(this, "Welcome " + name, Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void OnMaps(View view) {
        startActivityForResult(new Intent(this, MapsActivity.class), activityCode);
    }

    public void OnAlarm(View view) {
        startActivityForResult(new Intent(this, AlarmActivity.class), activityCode);
    }

    public void OnFragments(View view) {
        startActivityForResult(new Intent(this, Fragments.class), activityCode);
    }

    public void OnNotifications(View view) {
        startActivityForResult(new Intent(this, Notifications.class), activityCode);
    }

    public void OnUIComponents(View view) {
        startActivityForResult(new Intent(this, UIComponentsActivity.class), activityCode);
    }
}
