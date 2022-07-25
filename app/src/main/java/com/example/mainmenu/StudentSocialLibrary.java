package com.example.mainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        informFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // sending notifications
                // Elif Sorguç - Butona basılınca notificationa gidecek ("Elif is in the library" gibi)
            }
        });
    }

    // Opening new pages
    private void openFriendsInLibrary() {
        Intent intent = new Intent(this, StudentsInLibrary.class);
        startActivity(intent);
    }
}