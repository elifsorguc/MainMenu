package com.example.mainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.mainmenu.databinding.ActivityStudentBookBinding;

import java.time.LocalDate;
import java.util.ArrayList;

public class StudentBook extends AppCompatActivity {
    private ActivityStudentBookBinding binding;
    private Book book;
    ArrayList<Book> books;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        books = new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_book);

        this.book = new Book("STRING NAME", "LANGUAGE", "AUTHOR", "PUBLICATION", new Genre(), "ISBN", (LocalDate) null,(int) 12);
        //pubdate = LocalDate!!!
        //THERE IS GENRE CLASS!!!
        findBook("str");

        //viewBinding
        binding = ActivityStudentBookBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.bookName.setText("test");

    }

    private Book findBook(String name){
        //DATABASE

        return null;
    }

}