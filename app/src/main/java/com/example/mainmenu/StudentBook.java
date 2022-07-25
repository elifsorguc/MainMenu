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


        //viewBinding
        binding = ActivityStudentBookBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.bookName.setText("test");


        this.book = new Book("The science of Harry Potter : how magic really works / Roger Highfield.", "English", "Highfield, J.R.L. (John Roger Loxdale)", "London : Headline, 2003.", new Genre(), "0755311515", (LocalDate) null,(int) 12);
        //String name, String language, String author, String publication, Genre genre, String ISBN, LocalDate pubdate,int image){

        //pubdate = LocalDate!!!
        //THERE IS GENRE CLASS!!!
        findBook("str");



    }

    private Book findBook(String name){
        //DATABASE

        return null;
    }

}