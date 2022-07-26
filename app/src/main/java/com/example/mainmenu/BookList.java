package com.example.mainmenu;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class BookList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_lists);

    }

    private ArrayList<Book> bookList;

    // constructor
    public BookList(ArrayList<Book> books){
        this.bookList = books;
    }

    public void addBook(Book book){
        bookList.add(book);
    }

    public void removeBook(Book book){
        bookList.remove(book);
    }
}