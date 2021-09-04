package com.cst438.wk01hw02;

/**
 *
 * <h2><b>User Java Class</b></h2>
 * This java class contains the data model for a User. A User would contain a username,
 * password, and userId. This code only needs a constructor and getters.
 *
 * @author Eric Chavez Velez
 */

public class User {

    private String username;
    private String password;
    private int userId;

    public User(String username, String password, int userId) {
        this.username = username;
        this.password = password;
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getUserId() {
        return userId;
    }

}
