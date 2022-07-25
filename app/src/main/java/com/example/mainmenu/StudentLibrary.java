package com.example.mainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentLibrary extends AppCompatActivity {

    Button socialLibraryButton;
    Button studyRoomsButton;
    Button multimediaRoomsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_library);

        // Properties
        socialLibraryButton = findViewById(R.id.buttonSocial);
        studyRoomsButton = findViewById(R.id.buttonStudyRooms);
        multimediaRoomsButton = findViewById(R.id.buttonMultimediaRooms);

        // Setting ClickListeners
        socialLibraryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentLibrary.this, StudentSocialLibrary.class);
                startActivity(intent);
            }
        });
        studyRoomsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStudyMultiMediaRooms();
            }
        });
        multimediaRoomsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStudyMultiMediaRooms();
            }
        });

    }

    // Opening new pages
    private void openSocialLibrary(){
        Intent intent = new Intent(StudentLibrary.this, StudentSocialLibrary.class);
        startActivity(intent);
    }
    private void openStudyMultiMediaRooms(){
        Intent intent = new Intent(StudentLibrary.this, StudentStudyMultiMediaRooms.class);
        startActivity(intent);
    }
}