package com.example.mainmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentSocialLibrary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_social_library);

        // Properties
        Button friendsInLibraryButton = findViewById(R.id.buttonFriendsInLibrary);
        Button informFriends = findViewById(R.id.buttonInformFriends);

        // Setting ClickListeners
        friendsInLibraryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFriendsInLibrary();
            }
        });

        /*if(Build.VERSION.PREVIEW_SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("I am in the library", "Not", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }*/
        informFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Notification code
                NotificationCompat.Builder builder = (NotificationCompat.Builder)
                        new NotificationCompat.Builder(getApplicationContext())
                        .setContentTitle("Notification")
                        .setContentText("In the library");

                NotificationManager managerCompat = (NotificationManager)
                        getSystemService(NOTIFICATION_SERVICE);
                        managerCompat.notify(0, builder.build());
            }
        });
    }

    // Opening new pages
    private void openFriendsInLibrary() {
        Intent intent = new Intent(this, StudentsInLibrary.class);
        startActivity(intent);
    }
}