package com.test.interviewer.model;

import com.test.interviewer.Interviewer;

public class Candidate {
    private int id;
    private String name;
    private boolean isActive;
    private String lastName;
    private String email;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void add() {

    }
    public void save(){

    }
    public void delete(){

    }
    public void getByEmail(){

    }

}
