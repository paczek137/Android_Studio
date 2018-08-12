package com.example.paczek.paczek;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class AlarmActivity extends AppCompatActivity {

    String tag = "AlarmActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
    }

    public void OnSetTheAlarm(View view) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "Time to wake up")
                .putExtra(AlarmClock.EXTRA_HOUR, 17)
                .putExtra(AlarmClock.EXTRA_MINUTES, 54);
        startActivity(intent);
    }

    public void OnSetTheTimer(View view) {
        Log.d(tag, "OnSetTheTimer()");
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "Counting...")
                .putExtra(AlarmClock.EXTRA_LENGTH, 15)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, false);
        startActivity(intent);
    }
}
