package com.example.mainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminControlLibrary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_control_library);

        // Properties
        Button bookAvailabilityButton = findViewById(R.id.buttonBookAvailability);
        Button studyRoomAvailabilityButton = findViewById(R.id.buttonStudyRoomAvailability);

        // Setting ClickListeners
        bookAvailabilityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Elif Sorguç
                // Search for admin eklenecek ve o sayfa açılacak
            }
        });
        studyRoomAvailabilityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdminRoomController();
            }
        });
    }

    // Opening new pages
    private void openAdminRoomController(){
        Intent intent = new Intent(this, AdminRoomController.class);
        startActivity(intent);
    }
}