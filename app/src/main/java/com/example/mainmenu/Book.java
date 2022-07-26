package com.example.mainmenu;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Book
 */
public class Book implements Serializable {

    private String name;
    private String language;
    private String author;
    private String publication;
    private int publicationdDate;
    private ArrayList<String> genre;
    private String ISBN;
    private boolean isAvailable;
    private ArrayList<Integer> ratings;
    private int image;


    // constructor
    public Book(String name, String language, String author, String publication, ArrayList<String> genre, String ISBN, int pubdate,int image){
        this.name = name;
        this.language = language;
        this.author = author;
        this.publication = publication;
        this.ISBN = ISBN;
        this.publicationdDate = pubdate;
        this.genre = genre;
        this.image = image;
    }

    // getter and setter methods

    public void setAvailability(boolean b){
        this.isAvailable = b;
    }

    public String getName(){

        return name;
    }

    public String getPublication(){
        return publication;
    }

    public String getLang(){
        return language;
    }

    public int getPubdate(){
        return publicationdDate;
    }

    public ArrayList<String> getGenre(){
        return genre;
    }

    public boolean getAvailability(){
        return isAvailable;
    }

    public String getISBN(){
        return ISBN;
    }

    public void addRating(int rating){
        if (rating <= 5 && rating >= 0) {
            ratings.add(rating);
        }
    }

    public String getauthor(){
        return author;
    }

}