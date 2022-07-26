package com.example.mainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    private Button bookLists;
    private Button pastBooks;
    private Button favorites;
    private Button borrowed;
    private TextView name;
    private TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        bookLists = findViewById(R.id.booklists_btn);
        bookLists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, BookList.class);
                startActivity(intent);
            }
        });

        pastBooks = findViewById(R.id.pastBooks_btn);
        pastBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, pastBooks.class);
                startActivity(intent);
            }
        });

        favorites = findViewById(R.id.favorites_btn);
        favorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, favorites.class);
                startActivity(intent);
            }
        });

        borrowed = findViewById(R.id.borrowedbooks_btn);
        borrowed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, BorrowedBooks.class);
                startActivity(intent);
            }
        });

        //SET TEXT => DATABASE
        name = findViewById(R.id.nameSurname);
        name.setText("NAME");

        email = findViewById(R.id.emailtxt);
        email.setText("EMAIL");



    }


}