package com.example.mainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import com.example.mainmenu.databinding.ActivityStudentBookBinding;

import java.util.ArrayList;

public class StudentBook extends AppCompatActivity {
    private ActivityStudentBookBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //viewBinding
        binding = ActivityStudentBookBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();

        Book selectedBook = (Book) intent.getSerializableExtra("bookSelected");
        binding.bookName.setText(selectedBook.getName());
        binding.bookAuthor.setText(selectedBook.getauthor());
        binding.bookLanguage.setText(selectedBook.getLang());
        binding.bookPublicationInformation.setText(selectedBook.getPublication());
        binding.bookPublicationDate.setText(selectedBook.getPubdate());
        binding.bookGenre.setText(selectedBook.getGenre().toString());
        binding.bookISBN.setText(selectedBook.getISBN());


    }


}