package com.bignerdranch.android.liveschedule.Models;

public class User {
    private String id_user, firstname, secondname, lastname, id_post, email, password;

    public User() {}

    public User(String id_user, String firstname, String secondname, String lastname, String id_post, String email, String password) {
        this.id_user = id_user;
        this.firstname = firstname;
        this.secondname = secondname;
        this.lastname = lastname;
        this.id_post = id_post;
        this.email = email;
        this.password = password;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getId_post() {
        return id_post;
    }

    public void setId_post(String id_post) {
        this.id_post = id_post;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
