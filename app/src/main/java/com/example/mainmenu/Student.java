package com.example.mainmenu;
import java.util.ArrayList;

/**
 * Student
 */
public class Student extends User {

    private boolean isStudent = true;
    private String department;
    private boolean isAtLibrary;
    private boolean isProfileVisible;
    private boolean isStatusVisible;
    private boolean isListVisible;
    private BookList bookList;
    private String currentBook;

    ArrayList<Genre> genres = new ArrayList<Genre>();
    ArrayList<BookList> bookLists = new ArrayList<BookList>();
    ArrayList<Student> friends = new ArrayList<Student>();
    ArrayList<Book> previousBooks = new ArrayList<Book>();
    ArrayList<Book> favorites = new ArrayList<Book>();

    public  Student(String email, String password,String bilkentID, boolean isAdmin, String name,String surname,boolean isStudent, String department, boolean isAtLibrary, boolean isProfileVisible, boolean isStatusVisible,  boolean isListVisible){
        super(email,password,bilkentID,isAdmin,name,surname);
        this.isStudent = isStudent;
        this.department = department;
        this.isAtLibrary = isAtLibrary;
        this.isProfileVisible = isProfileVisible;
        this.isStatusVisible = isStatusVisible;
        this.isListVisible = isListVisible;
    }

    // getter methods

    public boolean getIsAtLibrary(){
        return isAtLibrary;
    }
    public boolean getProfileVisibility(){
        return isProfileVisible;
    }
    public boolean getListVisibility(){
        return isListVisible;
    }
    public boolean getStatusVisibility(){
        return isStatusVisible;
    }
    public ArrayList<Student> getFriends(){
        return friends;
    }
    public ArrayList<BookList> getBookLists(){
        return bookLists;
    }
    public ArrayList<Book> getPrevBooks(){
        return previousBooks;
    }
    public ArrayList<Book> getFavBooks(){
        return favorites;
    }
    public String getCurrentBook(){return currentBook; }

    public ArrayList<Genre> getGenres(){
        return genres;
    }

    public String getDepartment(){
        return department;
    }


    public boolean getUserType(){
        return isStudent;
    }

    // setter methods

    public void setUserStatus(){
        this.isAdmin = isStudent;
    }
    public void setDepartment(String department){
        this.department = department;
    }

    public void setIsAtLibrary(boolean isAtLibrary){
        this.isAtLibrary = isAtLibrary;
    }

    public void setProfileVisibility(boolean isProfileVisible){
        this.isProfileVisible = isProfileVisible;
    }

    public void setLisVisibilty(boolean isListVisible){
        this.isListVisible = isListVisible;
    }

    public void setStatusVisibility(boolean isStatusVisible){
        this.isStatusVisible = isStatusVisible;
    }

    public void setGenres(ArrayList<Genre> genres){
        this.genres = genres;
    }

    public void setFriends(ArrayList<Student> friends){
        this.friends = friends;
    }

    public void setBookLists(ArrayList<BookList> bookLists){
        this.bookLists = bookLists;
    }

    public void setFavs(ArrayList<Book> favorites){
        this.favorites = favorites;
    }

    public void setPrevs(ArrayList<Book> previosBooks){
        this.previousBooks = previosBooks;
    }

    public void setCurrentBook( String book){
        this.currentBook = book;
    }

    public void addFriends(Student friend){
        friends.add(friend);
    }

    public void borrowBook(Book book){

        previousBooks.add(book);
    }

    public void createBookList(BookList list){
        bookLists.add(list);
    }

    public void addBookToBookList(BookList list, Book book){
        list.addBook(book);
        this.bookList = list;
    }

    public void deleteBookFromBookList(BookList list, Book book){
        list.removeBook(book);
        this.bookList = list;
    }



}