package com.example.mainmenu;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BookList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_lists);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}