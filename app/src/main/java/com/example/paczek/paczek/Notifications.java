package com.example.paczek.paczek;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.RemoteInput;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Notifications extends AppCompatActivity {

    public static final String tag = "NotificationsPaczek";
    public static final String NOTIFICATION_CHANNEL_ID = "1";
    public static int basicNotificationID = 1;
    public static int actionNotificationID = 2;
    public static int expandedNotificationID = 3;
    public static int groupedNotificationID1 = 4;
    public static int groupedNotificationID2 = 5;
    public static int groupedNotificationID3 = 6;
    public static int groupedNotificationID4 = 7;
    public static int replyNotificationID = 8;

    public static String keyForReplyNotification = "keyForReplyNotification";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
    }

    public void OnBasicNotification(View view) {

        Intent activityForBasicNotifications =
                new Intent(this, BasicNotification.class);

        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 0, activityForBasicNotifications,
                        PendingIntent.FLAG_UPDATE_CURRENT);

        Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Log.d(tag, "Oreo");
            createNotificationChannel();
            notificationBuilder =
                    new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);
        } else {
            notificationBuilder = new NotificationCompat.Builder(this);
        }

        Notification basicNotification = notificationBuilder
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Notification")
                .setContentText("Message")
                .setSound(sound)
                .setContentIntent(pendingIntent)
                .build();

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(basicNotificationID, basicNotification);
    }

    public void OnActionNotification(View view) {
        Intent activityForActionNotification = new
                Intent(this, ActionNotification.class);
        PendingIntent pendingIntent =
                PendingIntent.getActivity(this,
                        0,
                        activityForActionNotification,
                        PendingIntent.FLAG_UPDATE_CURRENT);

//        NotificationCompat.Action action =
//                new NotificationCompat.Action.Builder(android.R.drawable.sym_action_email,
//                        "Open", pendingIntent).build();

        Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Log.d(tag, "Oreo");
            createNotificationChannel();
            notificationBuilder =
                    new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);
        } else {
            notificationBuilder = new NotificationCompat.Builder(this);
        }

        Notification actionNotification = notificationBuilder
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Action Notification")
                .setContentText("Message")
                .setSound(sound)
                //.addAction(action)
                .addAction(android.R.drawable.sym_action_chat, "Open", pendingIntent)
                .build();

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(actionNotificationID, actionNotification);

    }

    public void OnExpandedNotification(View view) {
        NotificationCompat.InboxStyle inboxStyle =
                new NotificationCompat.InboxStyle();

        String[] events = {
                "Event 1",
                "Event 2",
                "Event 3",
                "Event 4"};

        inboxStyle.setBigContentTitle("Event details");
        for (int i=0; i < events.length; i++) {
            inboxStyle.addLine(events[i]);
        }

        NotificationCompat.Builder notificationBuilder;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Log.d(tag, "Oreo");
            createNotificationChannel();
            notificationBuilder =
                    new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);
        } else {
            notificationBuilder = new NotificationCompat.Builder(this);
        }

        Notification expandedNotification = notificationBuilder
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Notifications")
                .setContentText("Message")
                .setStyle(inboxStyle)
                .build();

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(expandedNotificationID, expandedNotification);
    }

    public void OnGroupedNotification(View view) {
        String groupKey = "GroupKey";

        NotificationCompat.Builder notificationBuilder;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Log.d(tag, "Oreo");
            createNotificationChannel();
            notificationBuilder =
                    new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);
        } else {
            notificationBuilder = new NotificationCompat.Builder(this);
        }

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification groupedNotification1 = notificationBuilder
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Grouped notifications")
                .setContentText("You have got 3 new notifications")
                .setGroup(groupKey)
                .setGroupSummary(true)
                .build();

        notificationManager.notify(groupedNotificationID1, groupedNotification1);

        Notification groupedNotification2 = notificationBuilder
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("New notification")
                .setContentText("1. notification")
                .setGroup(groupKey)
                .setGroupSummary(false) // only once
                .build();

        notificationManager.notify(groupedNotificationID2, groupedNotification2);

        Notification groupedNotification3 = notificationBuilder
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("New notification")
                .setContentText("2. notification")
                .setGroup(groupKey)
                .build();

        notificationManager.notify(groupedNotificationID3, groupedNotification3);

        Notification groupedNotification4 = notificationBuilder
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("New notification")
                .setContentText("3. notification")
                .setGroup(groupKey)
                .build();

        notificationManager.notify(groupedNotificationID4, groupedNotification4);
    }

    public void OnReplydNotification(View view) {
        String reply = "Reply...";
        RemoteInput remoteInput = new RemoteInput.Builder(keyForReplyNotification)
                .setLabel(reply)
                .build();

        Intent intent = new Intent(this, ReplyNotification.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Action replyAction =
                new NotificationCompat.Action.Builder(
                        android.R.drawable.ic_dialog_info,
                        "Reply",
                        pendingIntent)
                        .addRemoteInput(remoteInput).build();

        NotificationCompat.Builder notificationBuilder;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Log.d(tag, "Oreo");
            createNotificationChannel();
            notificationBuilder =
                    new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);
        } else {
            notificationBuilder = new NotificationCompat.Builder(this);
        }

        Notification replyNotification = notificationBuilder
                .setColor(ContextCompat.getColor(this, R.color.colorPrimary))
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Notification")
                .setContentText("Message")
                .addAction(replyAction)
                .build();

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(replyNotificationID, replyNotification);

    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //CharSequence name = getString(R.string.channel_name);
            //String description = getString(R.string.channel_description);
            CharSequence name = "Channel_1";
            String description = "Basic_channel";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel =
                    new NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
