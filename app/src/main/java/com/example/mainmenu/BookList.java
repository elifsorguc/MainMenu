
package com.example.mainmenu;
import java.util.ArrayList;

/**
 * BookList
 */
public class BookList {

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