package com.model;

public class UserPojo {
    private int id; // Add ID field
    private String username;
    private String email;

    public UserPojo(int id, String username, String email) { // Add ID in constructor
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public int getId() { // Add getter for ID
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserPojo [id=" + id + ", username=" + username + ", email=" + email + "]";
    }
}
