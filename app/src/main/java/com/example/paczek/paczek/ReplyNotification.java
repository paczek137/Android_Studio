package com.example.paczek.paczek;

import android.app.NotificationManager;
import android.app.RemoteInput;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReplyNotification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_notification);

        Intent intent = getIntent();
        Bundle bundle = RemoteInput.getResultsFromIntent(intent);

        if (bundle != null) {
            TextView textView = (TextView) findViewById(R.id.textViewReplyNotificationActivity);
            String text = bundle.getString(Notifications.keyForReplyNotification);
            textView.setText(text);
        }
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(Notifications.replyNotificationID);
    }
}
