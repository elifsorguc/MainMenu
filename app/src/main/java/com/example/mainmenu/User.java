/**
 * User
 * @author Gazal Amirrashed
 */
package com.example.mainmenu;
public abstract class User {

    protected String email;
    protected String password;
    protected String bilkentID;
    protected boolean isAdmin;
    protected String name;
    protected String surname;

    public User(String email, String password, String bilkentID, boolean isAdmin, String name,String surname ){
        this.email = email;
        this.password = password;
        this.bilkentID = bilkentID;
        this.isAdmin = isAdmin;
        this.name = name;
        this.surname = surname;
    }

    // getter methods
    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getID(){
        return bilkentID;
    }

    public boolean getUserType;

    // setter methods

    public void setPassword(String password){
        this.password = password;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setID(String id){
        this.bilkentID = id;
    }

    public void setUserStatus(boolean b){
        this.isAdmin = b;
    }

    public void setEmail(String email){
        this.email = email;
    }


}