package com.example.mainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Notifications extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
    }
    /*
    * NotificationCompat.Builder builder = new NotificationCompat.Builder();
    * builder.setContentTitle("MyTitle" );
    * builder.setContentText("TEXT DATABASE NOTIFICATION");
    * builder.setSmallIcon(R.drawable.ic_launcher_background);
     * */

    public String friendInLibraryNotification(){
        return "in library";
    }
    public String bookOverDueNotification(){
        return " 3 days left for this book";
    }
    public String addedByFriendNotification(){
        return " added you!";
    }
}