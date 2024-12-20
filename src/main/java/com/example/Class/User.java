package com.example.Class;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class User {
    private int id;
    private String name, email, password;

    public User (){
        this.id = -1;
        this.name = "";
        this.email = "";
        this.password = "";
    }

    public User (int id, String name, String email, String password){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName (){
        return this.name;
    }

    public String getEmail (){
        return this.email;
    }

    public String getPassword (){
        return this.password;
    }

    public int getId (){
        return this.id;
    }

    public void setName (String name){
        this.name = name;
    }

    public void setEmail (String email){
        this.email = email;
    }

    public void setPassword (String password){
        this.password = password;
    }

    public void setId (int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "Id: " + this.id +" - Name: " + this.name + " - Email: " + this.email + " - Password: " + this.password + "\n";
    }

}
